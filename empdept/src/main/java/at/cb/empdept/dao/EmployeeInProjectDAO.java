package at.cb.empdept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class EmployeeInProjectDAO {
    public static void createEmployeeInProjectDAO(int employeeId, int projectId, Instant start, Instant end){
        try (Connection connection = DbConnection.getConnection()){
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO employee_in_project " +
                            "(employee_id, project_id, start, end) " +
                            "VALUES " +
                            "(?, ?, ?, ?)");
            ps.setInt(1, employeeId);
            ps.setInt(2, projectId);

            // Instant --> Timestamp
            Timestamp startTimestamp = new Timestamp(start.toEpochMilli());
            Timestamp endTimestamp = new Timestamp(end.toEpochMilli());

            ps.setTimestamp(3, startTimestamp);
            ps.setTimestamp(4, endTimestamp);

            int rowCount = ps.executeUpdate();
            if(rowCount == 0){
                throw new DAOException("Es konnte keine Projektzeit angelegt werden");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
