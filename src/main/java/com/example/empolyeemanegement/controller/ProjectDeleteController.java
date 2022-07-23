package com.example.empolyeemanegement.controller;

import com.example.empolyeemanegement.model.Project;
import com.example.empolyeemanegement.repository.ProjectDAO;
import com.example.empolyeemanegement.utils.FXUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProjectDeleteController implements Initializable {


    @FXML
    public TextField projectTxtFld;

    @FXML
    public TextArea detailsTxtArea;

    private ProjectDAO projectDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectDAO = new ProjectDAO();
    }

    @FXML
    public void selectAndViewDetailsBtnAction(ActionEvent event) {
        Project project = projectDAO.findOne(Long.parseLong(projectTxtFld.getText()));
        if (project != null) {
            detailsTxtArea.setText(project.toString());
        } else {
            FXUtil.showAlert(Alert.AlertType.WARNING, "Project not found.");
        }
    }

    @FXML
    public void viewAllBtnAction(ActionEvent event) {
        StringBuilder sb = new StringBuilder();
        projectDAO.findAll().forEach(project -> sb.append(project.toString()).append("\n"));
        detailsTxtArea.setText(sb.toString());
    }

    @FXML
    public void deleteBtnAction(ActionEvent event) {
        Project project = projectDAO.findOne(Long.parseLong(projectTxtFld.getText()));
        if (project != null) {
            projectDAO.delete(project);
            FXUtil.showAlert(Alert.AlertType.WARNING,
                    project.getName() + " deleted successfully.");
        } else {
            FXUtil.showAlert(Alert.AlertType.WARNING, "Project not found.");
        }
    }
}
