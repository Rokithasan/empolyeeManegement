
package com.example.empolyeemanegement.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.model.Role;
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
public class EmployeeAddController implements Initializable {


    @FXML
    public TextField nameTxtFld;
    @FXML
    public TextField mobileNumTxtFld;
    @FXML
    public TextField departmentTxtId;
    @FXML
    public TextField salaryTxtID;
    @FXML
    public TextField usernameTxtFld;
    @FXML
    public TextField passwordTxtFld;
    @FXML
    public TextField designTxtID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML // create employee
    public void createEmployeeBtnAction(ActionEvent actionEvent) {

        UserDAO userDAO = new UserDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        if(userDAO.getUserByUsername(usernameTxtFld.getText()) == null){
            // create user type of employee
            User user = new User();
            user.setName(nameTxtFld.getText());
            user.setUsername(usernameTxtFld.getText());
            user.setPassword(PasswordManager.getInstance().encode(passwordTxtFld.getText()));
            user.setMobileNum(mobileNumTxtFld.getText());
            user.setRole(Role.EMPLOYEE);
            userDAO.create(user);

            Employee employee = new Employee();
            employee.setDepartment(departmentTxtId.getText());
            employee.setSalary(Double.parseDouble(salaryTxtID.getText()));
            employee.setDesignation(designTxtID.getText());
            employee.setUser(new UserDAO().getUserByUsername(usernameTxtFld.getText()));
            employeeDAO.create(employee);

            // clear field data
            clear();

            // show alert
            FXUtil.showAlert(
                    Alert.AlertType.ERROR,
                    "Employee Created Successfully!"
            );

        }else {
            FXUtil.showAlert(
                    Alert.AlertType.ERROR,
                    "username already exist, please try with another username."
            );
        }
    }

    private void clear() {
        nameTxtFld.clear();
        usernameTxtFld.clear();
        passwordTxtFld.clear();
        mobileNumTxtFld.clear();
        departmentTxtId.clear();
        salaryTxtID.clear();
        designTxtID.clear();
    }
}
