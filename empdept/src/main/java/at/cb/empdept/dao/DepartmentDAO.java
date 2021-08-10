package at.cb.empdept.dao;

import at.cb.empdept.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentDAO {
    public static int createDepartment(String name){
        try(Connection connection = DbConnection.getConnection()) {
            // Prepared Statements: Platzhalter verwenden um SQL-Injections vorzubeugen!
            PreparedStatement ps = connection.prepareStatement("" +
                    "INSERT INTO department " +
                    "(name) " +
                    "VALUES " +
                    "(?)", Statement.RETURN_GENERATED_KEYS);
            // Platzhalter durch eigentlichen Wert ersetzen
            ps.setString(1, name);
            // Statement an die DB schicken

            // executeUpdate: liefert die Anzahl der modifizierten Zeilen zurück
            int rowCount = ps.executeUpdate();
            if(rowCount == 0){
                // es wurde keine Zeile eingefügt --> Exception werfen
                throw new DAOException("Create Department: Es wurde keine Zeile verändert");
            }

            // ID des erzeugten Datensatzes herausholen und zurückgeben
            ResultSet rs = ps.getGeneratedKeys();
            // Innerhalb vom ResultSet ist der Key
            if(rs.next()){
                // Key aus ResultSet herausholen und zurückgeben
                return rs.getInt(1);
            }
            throw new DAOException("Create Department: Es wurde kein Key generiert");
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static List<Department> getDepartments(){
        try (Connection connection = DbConnection.getConnection()){
            // SELECT * FROM department
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM department");

            // Liste in der alle Ergebnisse gespeichert werden
            List<Department> result = new ArrayList<>();

            while (rs.next()){
                // jeden gefundenen Datensatz anschauen
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Department department = new Department(id, name);
                result.add(department);
            }

            return result;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public static Optional<Department> getDepartmentById(int id){
        try(Connection connection = DbConnection.getConnection()){
            // SELECT * FROM department WHERE id = 4
            PreparedStatement ps = connection.prepareStatement("" +
                    "SELECT * " +
                    "FROM department " +
                    "WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                // Daten auslesen ...
                int departmentId = rs.getInt("id");
                String name = rs.getString("name");
                return Optional.of(new Department(departmentId, name));
            }

            // kein Department mit der ID gefunden
            return Optional.empty();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
