package com.example.empolyeemanegement.controller;

import com.example.empolyeemanegement.repository.ProjectDAO;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectViewController implements Initializable {

    public TextArea viewTxtAreaID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringBuilder sb = new StringBuilder();
        new ProjectDAO()
                .findAll()
                .forEach(project -> sb.append(project.toString()).append("\n"));
        viewTxtAreaID.setText(sb.toString());
    }
}
