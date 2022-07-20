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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class EmployeeDeleteController implements Initializable {

    @FXML
    public TextArea detailsTxtArea;

    @FXML
    public TextField usernameTxtFld;

    private EmployeeDAO employeeDAO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeDAO = new EmployeeDAO();
    }

    @FXML
    public void viewDetailsBtnAction(ActionEvent actionEvent) {
        Employee employee = employeeDAO.getByUsername(usernameTxtFld.getText());
        if(employee != null){
            detailsTxtArea.setText(employee.toString());
        }else {
            detailsTxtArea.setText("Employee not found, try again with correct username.");
        }
    }

    @FXML
    public void deleteBtnAction(ActionEvent actionEvent) {
        Employee employee = employeeDAO.getByUsername(usernameTxtFld.getText()); // get employee
        if(employee != null){

            // delete user and employee from db
            User user = employee.getUser();
            employeeDAO.delete(employee);
            new UserDAO().delete(user);

            detailsTxtArea.setText(employee.toString()+"\nEmployee deleted successfully.");
        }else {
            detailsTxtArea.setText("Employee not found, try again with correct username.");
        }
    }
}
