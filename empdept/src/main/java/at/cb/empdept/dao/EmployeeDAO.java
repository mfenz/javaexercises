package at.cb.empdept.dao;

import at.cb.empdept.model.Department;

import java.sql.*;

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
}
