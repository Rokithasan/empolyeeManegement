package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.empolyeemanegement.utils.Links;
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

/**
 * @author Hp
 */
public class EmployeeLoginController implements Initializable {

    @FXML
    public TextField usernameFiled;

    @FXML
    public PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {

        String name = usernameFiled.getText();
        String password = passwordField.getText();

        if (name.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill all requre Information");
            alert.showAndWait();
        } else {
            if (name.equals("admin") && password.equals("admin")) {
                ((Node) event.getSource()).getScene().getWindow().hide();
                loadEmployeeDashboard(event);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid Data");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleAdminLoginButtonAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource(Links.ADMIN_LOGIN);
        Parent layout = FXMLLoader.load(resource);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Admin Login");
        stage.setScene(scene);
        stage.show();
    }

    public void loadEmployeeDashboard(ActionEvent event) throws IOException {
        URL resource = getClass().getResource(Links.EMPLOYEE_DASHBOARD);
        Parent layout = FXMLLoader.load(resource);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Employee Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
