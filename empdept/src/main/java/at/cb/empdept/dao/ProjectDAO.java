package at.cb.empdept.dao;

import at.cb.empdept.model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    public static List<Project> getProjects(){
        try(Connection connection = DbConnection.getConnection()){
            Statement statement = connection.createStatement();
            // SELECT-Statement an den Server schicken
            ResultSet rs = statement.executeQuery("SELECT * FROM project");
            // Result-Set auswerten
            List<Project> result = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                // MySQL Timestamp (deadline) in Instant umwandeln
                OffsetDateTime odt = rs.getObject("deadline", OffsetDateTime.class);
                Instant deadline = odt.toInstant(); // Konvertieren von "OffsetDateTime" nach "Instant"

                result.add(new Project(id, name, deadline));
            }
            return result;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
