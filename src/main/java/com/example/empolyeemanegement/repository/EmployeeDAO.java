package com.example.empolyeemanegement.repository;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.model.Role;
import com.example.empolyeemanegement.model.User;
import com.example.empolyeemanegement.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;

public class EmployeeDAO extends AbsDAO<Employee> {
    public EmployeeDAO() {
        super.sessionFactory = HibernateUtil.getSessionFactory();
        setClazz(Employee.class);
    }

    public Employee getByUsername(String username) {
        List<Employee> all = this.findAll();
        for (Employee employee : all) {
            if (employee.getUser().getUsername().equals(username)) {
                return employee;
            }
        }
        return null;
    }
}
