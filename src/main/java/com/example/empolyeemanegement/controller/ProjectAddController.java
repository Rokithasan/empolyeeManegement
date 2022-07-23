package com.example.empolyeemanegement.controller;

import com.example.empolyeemanegement.model.Project;
import com.example.empolyeemanegement.repository.ProjectDAO;
import com.example.empolyeemanegement.utils.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ProjectAddController implements Initializable {

    @FXML
    public TextField projectNameTxtFld;

    @FXML
    public TextField budgetTxtId;

    @FXML
    public DatePicker deadlineDatePickerId;

    private ProjectDAO projectDAO; // db access

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectDAO = new ProjectDAO();
    }

    @FXML
    public void createProjectBtnAction(ActionEvent event) {

        Project project = new Project();
        project.setName(projectNameTxtFld.getText());
        project.setBudget(Double.parseDouble(budgetTxtId.getText()));

        /*
         * Project deadline should be after current date
         */
        if(LocalDate.now().isBefore(deadlineDatePickerId.getValue())){
            project.setDeadline(deadlineDatePickerId.getValue());
            projectDAO.create(project);
            clear();
            FXUtil.showAlert(Alert.AlertType.WARNING, "Project created successfully!");
        }else {
            FXUtil.showAlert(Alert.AlertType.WARNING, "Project deadline " +
                    "should be after current date!");
        }
    }

    private void clear() {
        projectNameTxtFld.clear();
        budgetTxtId.clear();
    }
}
