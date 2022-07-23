package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.repository.EmployeeDAO;
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

/**
 * @author Hp
 */
public class EmployeeLoginController implements Initializable {

    @FXML
    public TextField usernameTxtFld;
    @FXML
    public PasswordField passwordTxtFld;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {

        String username = usernameTxtFld.getText();
        String password = passwordTxtFld.getText();

        if (username.isEmpty() || password.isEmpty()) {
            FXUtil.showAlert(Alert.AlertType.WARNING,
                    "Please fill all require information");
        } else {
            // verify employee data
            EmployeeDAO empDao = new EmployeeDAO();
            Employee emp = empDao.getByUsername(username);

            if (emp != null &&
                    PasswordManager.getInstance().matches(password, emp.getUser().getPassword())
            ) {
                ((Node) event.getSource()).getScene().getWindow().hide();
                FXUtil.loadView(getClass(), event, Links.EMPLOYEE_DASHBOARD, "Employee Dashboard");
            } else {
                FXUtil.showAlert(Alert.AlertType.ERROR, "Invalid username or password");
            }

            Class<?> aClass = getClass();
        }
    }

    @FXML // move to admin login
    private void handleAdminLoginButtonAction(ActionEvent event) throws IOException {
        FXUtil.loadView(getClass(), event, Links.ADMIN_LOGIN, "Admin Login");
    }
}
