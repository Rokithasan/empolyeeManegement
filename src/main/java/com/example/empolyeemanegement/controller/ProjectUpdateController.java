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

public class ProjectUpdateController implements Initializable {

    @FXML
    public TextField projectIdTxtFld;

    @FXML
    public TextField nameTxtFld;

    @FXML
    public TextField budgetTxtFld;

    @FXML
    public DatePicker deadlineDatePickerId;

    private ProjectDAO projectDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectDAO = new ProjectDAO();
    }

    @FXML
    public void loadProjectDataBtnAction(ActionEvent event) {
        Project project = projectDAO.findOne(Long.parseLong(projectIdTxtFld.getText()));
        if (project != null) {
            nameTxtFld.setText(project.getName());
            budgetTxtFld.setText(project.getBudget() + "");
            deadlineDatePickerId.setValue(project.getDeadline());
        } else {
            FXUtil.showAlert(Alert.AlertType.WARNING, "Project not found.");
        }
    }

    @FXML
    public void updateDataBtnAction(ActionEvent event) {
        Project project = projectDAO.findOne(Long.parseLong(projectIdTxtFld.getText()));
        if (project != null) {
            project.setName(nameTxtFld.getText());
            project.setBudget(Double.parseDouble(budgetTxtFld.getText()));

            /*
             * Project deadline should be after current date
             */
            if (LocalDate.now().isBefore(deadlineDatePickerId.getValue())) {
                project.setDeadline(deadlineDatePickerId.getValue());
                projectDAO.create(project);
                clear();
                FXUtil.showAlert(Alert.AlertType.WARNING, "Project updated successfully!");
            } else {
                FXUtil.showAlert(Alert.AlertType.WARNING, "Project deadline " +
                        "should be after current date!");
            }
        } else {
            FXUtil.showAlert(Alert.AlertType.WARNING, "Project not found.");
        }

    }

    private void clear() {
        nameTxtFld.clear();
        budgetTxtFld.clear();
    }
}
