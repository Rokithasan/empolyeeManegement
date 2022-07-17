package com.example.empolyeemanegement.repository;

import com.example.empolyeemanegement.model.User;
import com.example.empolyeemanegement.utils.HibernateUtil;

public class UserDAO extends AbsDAO<User>{
    public UserDAO(){
        super.sessionFactory = HibernateUtil.getSessionFactory();
        setClazz(User.class);
    }
}
