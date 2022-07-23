/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.empolyeemanegement.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.model.User;
import com.example.empolyeemanegement.repository.EmployeeDAO;
import com.example.empolyeemanegement.repository.UserDAO;
import com.example.empolyeemanegement.utils.FXUtil;
import com.example.empolyeemanegement.utils.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class EmployeeUpdateController implements Initializable {

    @FXML
    public TextField usernameTxtFld;
    @FXML
    public TextField nameTxtFld;
    @FXML
    public TextField departTxtFld;
    @FXML
    public TextField mobileTxtFld;
    @FXML
    public TextField designationTxtFld;
    @FXML
    public TextField salaryTxtFLd;
    @FXML
    public TextField updatePassTxtFld;

    private EmployeeDAO employeeDAO;
    private UserDAO userDAO;
    private boolean dataLoaded = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.employeeDAO = new EmployeeDAO();
        this.userDAO = new UserDAO();
    }

    @FXML
    public void loadEmployeeDataBtnAction(ActionEvent actionEvent) {
        Employee employee = employeeDAO.getByUsername(usernameTxtFld.getText());
        if (employee == null) {
            FXUtil.showAlert(Alert.AlertType.WARNING, "Invalid username, data not found!");
            dataLoaded = false;
            clear();
        } else {
            nameTxtFld.setText(employee.getUser().getName());
            departTxtFld.setText(employee.getDepartment());
            mobileTxtFld.setText(employee.getUser().getMobileNum());
            designationTxtFld.setText(employee.getDesignation());
            salaryTxtFLd.setText(employee.getSalary() + "");
            dataLoaded = true;
        }
    }

    @FXML
    public void updateDataBtnAction(ActionEvent actionEvent) {
        // if data not loaded
        if (!dataLoaded) {
            FXUtil.showAlert(Alert.AlertType.WARNING, "without load data can't update!");

            dataLoaded = false;
            clear();
        } else {
            Employee employee = employeeDAO.getByUsername(usernameTxtFld.getText());
            User user = employee.getUser();

            user.setName(nameTxtFld.getText());
            user.setMobileNum(mobileTxtFld.getText());
            if (!updatePassTxtFld.getText().isEmpty()) {
                user.setPassword(PasswordManager.getInstance().encode(updatePassTxtFld.getText()));
            }
            userDAO.update(user); // update user

            employee.setDepartment(departTxtFld.getText());
            employee.setDesignation(designationTxtFld.getText());
            employee.setSalary(Double.parseDouble(salaryTxtFLd.getText()));

            employeeDAO.update(employee); // update employee

            // alert
            FXUtil.showAlert(Alert.AlertType.INFORMATION, "Data updated successfully!");
        }
    }

    // clear all filed
    private void clear() {
        nameTxtFld.clear();
        departTxtFld.clear();
        mobileTxtFld.clear();
        designationTxtFld.clear();
        salaryTxtFLd.clear();
        updatePassTxtFld.clear();
    }
}
