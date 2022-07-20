package com.example.empolyeemanegement.helpers;

import com.example.empolyeemanegement.model.Role;
import com.example.empolyeemanegement.model.User;
import com.example.empolyeemanegement.repository.UserDAO;
import com.example.empolyeemanegement.utils.PasswordManager;

public class AdminAdders {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // add 2 admin in database
        User admin1 = new User();
        admin1.setName("Jhon Due");
        admin1.setUsername("admin1");
        admin1.setPassword(PasswordManager.getInstance().encode("admin1"));
        admin1.setMobileNum("123456");
        admin1.setRole(Role.ADMIN);

        // add 2 admin in database
        User admin2 = new User();
        admin2.setName("Tom Harry");
        admin2.setUsername("admin2");
        admin2.setPassword(PasswordManager.getInstance().encode("admin2"));
        admin2.setMobileNum("123456");
        admin2.setRole(Role.ADMIN);

        // save in db
        userDAO.create(admin1);
        userDAO.create(admin2);
    }
}
