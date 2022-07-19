package com.example.empolyeemanegement.repository;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.utils.HibernateUtil;

public class EmployeeDAO extends AbsDAO<Employee> {
    public EmployeeDAO() {
        super.sessionFactory = HibernateUtil.getSessionFactory();
        setClazz(Employee.class);
    }
}
