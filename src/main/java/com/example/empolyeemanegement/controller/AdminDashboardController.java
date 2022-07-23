package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.empolyeemanegement.utils.FXUtil;
import com.example.empolyeemanegement.utils.Links;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AdminDashboardController implements Initializable {

    @FXML
    public Button backBtnId; // generic back button

    @FXML
    private AnchorPane displayAnchorPane; // sub section view

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtnId.setVisible(false);
    }

    @FXML // logout
    public void adminLogoutBtnAction(ActionEvent actionEvent) throws IOException {
        FXUtil.loadView(getClass(), actionEvent, Links.ADMIN_LOGIN, "Admin Login");
    }

    // load view based on view name
    private void loadAnchorView(String link) {
        try {
            backBtnId.setVisible(true);
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(String.valueOf(link)));
            displayAnchorPane.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(AdminDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void addEmployeeBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.ADD_EMPLOYEE);
    }


    @FXML
    public void updateEmployeeBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.UPDATE_EMPLOYEE);
    }

    @FXML
    public void viewAllEmployeeBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.VIEW_EMPLOYEE);
    }

    @FXML
    public void deleteEmployeeBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.DELETE_EMPLOYEE);
    }

    @FXML // back button for sub view
    public void backBtnAction(ActionEvent actionEvent) throws IOException {
        FXUtil.loadView(getClass(), actionEvent, Links.ADMIN_DASHBOARD, "Admin Dashboard");
    }

    @FXML
    public void adminChatServerOnAction(ActionEvent actionEvent) {
        // todo: open chat server
    }
}
