
package com.example.empolyeemanegement.controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.example.empolyeemanegement.model.Employee;
import com.example.empolyeemanegement.repository.EmployeeDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class EmployeeViewController implements Initializable {

    @FXML
    public TextArea viewTxtAreaID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EmployeeDAO dao = new EmployeeDAO();
        StringBuilder sb = new StringBuilder();
        for (Employee employee:dao.findAll()){
            sb.append(employee.toString()).append("\n");
        }
        viewTxtAreaID.setText(sb.toString());
    }
}
