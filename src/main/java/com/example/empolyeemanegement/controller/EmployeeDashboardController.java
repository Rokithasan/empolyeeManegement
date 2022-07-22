package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.empolyeemanegement.utils.FXUtil;
import com.example.empolyeemanegement.utils.Links;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeeDashboardController implements Initializable {

    @FXML
    public Button backBtnId;

    @FXML
    public AnchorPane displayAnchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtnId.setVisible(false);
    }

    @FXML
    public void exitBtnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void backBtnAction(ActionEvent actionEvent) throws IOException {
        FXUtil.loadView(actionEvent,Links.EMPLOYEE_DASHBOARD,"Employee Dashboard");
    }

    @FXML
    public void addProjectBtnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void updateProjectBtnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void viewAllProjectsBtnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void deleteEmployeeBtnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void employeeChatServerOnAction(ActionEvent actionEvent) {
    }
}
