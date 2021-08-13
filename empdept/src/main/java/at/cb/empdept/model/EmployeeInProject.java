package at.cb.empdept.model;

import java.time.Instant;

public class EmployeeInProject {
    private Employee employee;
    private Project project;
    private Instant start;
    private Instant end;

    public EmployeeInProject(Employee employee, Project project,
                             Instant start, Instant end) {
        this.employee = employee;
        this.project = project;
        this.start = start;
        this.end = end;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }
}
