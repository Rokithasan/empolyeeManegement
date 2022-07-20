package com.example.empolyeemanegement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private String designation;

    @OneToOne()
    private User user;

    public Employee() {
    }

    public Employee(long employeeId, String department, double salary, String designation, User user) {
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.designation = designation;
        this.user = user;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Objects.equals(user, employee.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, user);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", designation=" + designation +
                ", user=" + user +
                '}';
    }
}
