package at.cb.empdept.model;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private float salary;
    private Department department;

    public Employee(int id, String firstname, String lastname, float salary,
                    Department department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Float.compare(employee.salary, salary) == 0 && Objects.equals(firstname,
                employee.firstname) && Objects.equals(lastname, employee.lastname) && Objects.equals(department,
                employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, salary, department);
    }
}
