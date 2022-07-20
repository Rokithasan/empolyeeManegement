package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.example.empolyeemanegement.model.Role;
import com.example.empolyeemanegement.model.User;
import com.example.empolyeemanegement.repository.UserDAO;
import com.example.empolyeemanegement.utils.Links;
import com.example.empolyeemanegement.utils.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill all require Information");
            alert.showAndWait();
        } else {
            if (adminLoginVerifier(username, password)) {
                ((Node) event.getSource()).getScene().getWindow().hide();
                adminDashboardScene(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password, please try again");
                alert.showAndWait();
            }
        }
    }

    // after validation move/load admin dashboard
    public void adminDashboardScene(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource(Links.ADMIN_DASHBOARD));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Admin Dashbord ");
        stage.setScene(scene);
        stage.show();
    }
}
