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
        FXUtil.loadView(getClass(), actionEvent, Links.EMPLOYEE_DASHBOARD, "Employee Dashboard");
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
    public void addProjectBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.ADD_PROJECT);
    }

    @FXML
    public void updateProjectBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.UPDATE_PROJECT);
    }

    @FXML
    public void viewAllProjectsBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.VIEW_PROJECT);
    }

    @FXML
    public void deleteEmployeeBtnAction(ActionEvent actionEvent) {
        loadAnchorView(Links.DELETE_PROJECT);
    }

    @FXML
    public void employeeChatServerOnAction(ActionEvent actionEvent) {
        // todo:
    }

    public void wikiWorkNewsOnAction(ActionEvent event) {
        loadAnchorView(Links.WIKI_NEWS);
    }
}
