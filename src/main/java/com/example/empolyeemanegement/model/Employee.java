package com.example.empolyeemanegement.model;

public class Employee extends User {

    //    //like employee id,
    //    //// employee name, department name, mobile number, and employee salary.
    private String employeeId;
    private String department;
    private String salary;

    public Employee() {
    }

    public Employee(String employeeId, String department, String salary) {
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public Employee(int userId, String name, String mobileNum, Role role,
                    String employeeId, String department, String salary) {
        super(userId, name, mobileNum, role);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", salary='" + salary + '\'' +
                '}' + super.toString();
    }
}
