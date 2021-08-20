package at.cb.empdept.model;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

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

    public long getDuration(){
        long between = ChronoUnit.HOURS.between(start, end);
        return between;
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
