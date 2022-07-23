package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.empolyeemanegement.model.Role;
import com.example.empolyeemanegement.model.User;
import com.example.empolyeemanegement.repository.UserDAO;
import com.example.empolyeemanegement.utils.FXUtil;
import com.example.empolyeemanegement.utils.Links;
import com.example.empolyeemanegement.utils.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdminLoginController implements Initializable {

    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordFiled;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    // verify password from db
    private boolean adminLoginVerifier(String username, String password) {
        UserDAO dao = new UserDAO();
        List<User> allUsers = dao.findAll();
        for (User user : allUsers) {
            // verify password
            if (user.getRole() == Role.ADMIN
                    && user.getUsername().equals(username)
                    && PasswordManager.getInstance().matches(password, user.getPassword())
            ) {
                return true;
            }
        }

        return false;
    }

    // admin login button handler
    public void adminLoginBtnAction(ActionEvent event) throws IOException {

        String username = usernameField.getText();
        String password = passwordFiled.getText();

        if (username.isEmpty() || password.isEmpty()) {
            FXUtil.showAlert(
                    Alert.AlertType.WARNING,
                    "Please Fill all require Information"
            );
        } else {
            if (adminLoginVerifier(username, password)) {
                ((Node) event.getSource()).getScene().getWindow().hide();
                // after validation move/load admin dashboard
                FXUtil.loadView(getClass(), event, Links.ADMIN_DASHBOARD, "Admin Dashboard");
            } else {
                FXUtil.showAlert(
                        Alert.AlertType.WARNING,
                        "Invalid username or password, please try again"
                );
            }
        }
    }
}
