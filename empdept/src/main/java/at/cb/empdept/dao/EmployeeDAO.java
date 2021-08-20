package at.cb.empdept.dao;

import at.cb.empdept.model.Department;
import at.cb.empdept.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
    public static int createEmployee(String firstname, String lastname, float salary, Department department)
    {
        try(Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement("" +
                    "INSERT INTO employee " +
                    "(firstname, lastname, salary, department_id) " +
                    "VALUES " +
                    "(?, ?, ?, ?) ", Statement.RETURN_GENERATED_KEYS);
            // Platzhalter ? mit Werten ersetzen
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setFloat(3, salary);
            ps.setInt(4, department.getId());

            // Query an DB-Server senden
            // executeUpdate: liefert die Anzahl der modifizierten Zeilen zurück
            int rowCount = ps.executeUpdate();
            if(rowCount == 0){
                // es wurde keine Zeile eingefügt --> Exception werfen
                throw new DAOException("Create Employee: Es wurde keine Zeile verändert");
            }

            // ID des erzeugten Datensatzes herausholen und zurückgeben
            ResultSet rs = ps.getGeneratedKeys();
            // Innerhalb vom ResultSet ist der Key
            if(rs.next()){
                // Key aus ResultSet herausholen und zurückgeben
                return rs.getInt(1);
            }
            throw new DAOException("Create Employee: Es wurde kein Key generiert");

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Liest alle Employees aus der Datenbank aus
     * @return
     */
    public static List<Employee> getEmployees(){
        try(Connection connection = DbConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *, d.id AS dId, e.id AS eId " +
                    "FROM employee e INNER JOIN department d ON (e.department_id = d.id) ");
            List<Employee> result = new ArrayList<>();

            // über jeden Eintrag im ResultSet iterieren (jeweils ein Datensatz)
            while (rs.next()){
                Employee employee = map(rs);
                result.add(employee);
            }

            return result;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Was ist wenn kein Employee anhand der ID gefunden wird?
     * Mögliche Vorgehensweisen:
     * 1) Rückgabedatentyp Employee, Exception werfen
     * 2) Rückgabedatentyp Employee, Null zurückgeben
     * 3) Rückgabedatentyp Optional<Employee>, Optional<Employee> zurückgeben
     */

    public static Optional<Employee> getEmployeeById(int employeeId){
        try (Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement("SELECT *, d.id AS dId, e.id AS eId " +
                    "FROM employee e INNER JOIN department d ON (e.department_id = d.id) " +
                    "WHERE e.id = ? ");
            ps.setInt(1, employeeId);

            // SQL Statement an die DB schicken und ausführen lassen
            ResultSet rs = ps.executeQuery();

            // Benötigen nun ein Employee Objekt (aus dem ResultSet zusammenbauen)
            if(rs.next()){
                Employee employee = map(rs);

                return Optional.of(employee);
            }

            // Wenn kein Employee mit dieser ID gefunden wurde --> leeren Container zurückgeben
            return Optional.empty();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private static Employee map(ResultSet rs) throws SQLException {
        int departmentId = rs.getInt("dId");
        String departmentName = rs.getString("name");
        Department department = new Department(departmentId, departmentName);

        int employeeId = rs.getInt("eId");
        String firstname = rs.getString("firstname");
        String lastname = rs.getString("lastname");
        float salary = rs.getFloat("salary");

        Employee employee = new Employee(employeeId, firstname, lastname, salary, department);
        return employee;
    }
}
