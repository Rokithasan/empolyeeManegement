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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Hp
 */
public class EmployeeLoginController implements Initializable {

    private String username = "admin";
    private String password = "admin";

    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField passwordTxtField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {

        String name = nameTxtField.getText();
        String password = passwordTxtField.getText();

        if (name.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill all requre Information");
            alert.showAndWait();
        } else {
            if (name.equals(username) && password.equals(this.password)) {
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
