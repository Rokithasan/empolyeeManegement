package com.example.empolyeemanegement.repository;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.model.Project;
import com.example.empolyeemanegement.utils.HibernateUtil;

public class ProjectDAO extends AbsDAO<Project> {
    public ProjectDAO() {
        super.sessionFactory = HibernateUtil.getSessionFactory();
        setClazz(Project.class);
    }
}
