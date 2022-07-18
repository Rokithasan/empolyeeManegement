package com.example.empolyeemanegement.repository;

import com.example.empolyeemanegement.model.Role;
import com.example.empolyeemanegement.model.User;
import com.example.empolyeemanegement.utils.HibernateUtil;
import org.hibernate.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

public class UserDAO extends AbsDAO<User> {
    public UserDAO() {
        super.sessionFactory = HibernateUtil.getSessionFactory();
        setClazz(User.class);
    }

    public User getUserByUsername(String username) {
        try {
            // if Transaction is not active
            Transaction tx = getCurrentSession().getTransaction();
            if (!tx.isActive()) tx.begin();

            Session session = this.sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("select * from user where username='" + username + "';");
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List results = query.list();

            HashMap map = (HashMap) results.get(0);

            //long id, String name, String mobileNum, Role role, String username, String password
            User user = new User();
            user.setId(Long.parseLong(String.valueOf(map.get("id"))));
            user.setName((String) map.get("name"));
            user.setMobileNum((String) map.get("mobileNum"));
            user.setRole(Role.values()[(int) map.get("role")]);
            user.setUsername((String) map.get("username"));
            user.setPassword((String) map.get("password"));

            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
