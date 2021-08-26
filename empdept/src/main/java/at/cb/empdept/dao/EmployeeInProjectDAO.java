package at.cb.empdept.dao;

import at.cb.empdept.model.Department;
import at.cb.empdept.model.Employee;
import at.cb.empdept.model.EmployeeInProject;
import at.cb.empdept.model.Project;

import java.sql.*;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public static List<EmployeeInProject> getEmployeesInProjects(){
        try(Connection connection = DbConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("" +
                    "SELECT *, d.name AS dName, p.name AS pName " +
                    "FROM employee_in_project eip " +
                    "INNER JOIN employee e ON (e.id = eip.employee_id) " +
                    "INNER JOIN project p ON (eip.project_id = p.id) " +
                    "INNER JOIN department d ON (e.department_id = d.id) ");

            List<EmployeeInProject> result = new ArrayList<>();

            while (rs.next()){
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("dName");
                Department department = new Department(departmentId, departmentName);

                int employeeId = rs.getInt("employee_id");
                String empFirstname = rs.getString("firstname");
                String empLastname = rs.getString("lastname");
                float empSalary = rs.getFloat("salary");
                Employee employee = new Employee(employeeId, empFirstname, empLastname, empSalary, department);

                int projectId = rs.getInt("project_id");
                String projectName = rs.getString("pName");
                Instant projectDeadline = rs.getObject("deadline", OffsetDateTime.class).toInstant();
                Project project = new Project(projectId, projectName, projectDeadline);

                Instant eipStart = rs.getObject("start", OffsetDateTime.class).toInstant();
                Instant eipEnd = rs.getObject("end", OffsetDateTime.class).toInstant();

                EmployeeInProject employeeInProject = new EmployeeInProject(employee, project, eipStart, eipEnd);

                result.add(employeeInProject);
            }
            return result;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
