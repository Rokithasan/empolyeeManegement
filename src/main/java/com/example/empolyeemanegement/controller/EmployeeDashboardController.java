package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.empolyeemanegement.utils.Links;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeDashboardController implements Initializable {

    @FXML
    private TextArea detailstextarea;
    @FXML
    private TextField nametextfield;
    @FXML
    private Button cahtwithadminbutton;
    @FXML
    private Button updatedetailsbuttonid;
    @FXML
    private TextField posttextfield;
    @FXML
    private Button backbutton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionchatwithAdmin(ActionEvent event) {
        
    }

    @FXML
    private void onActionupdateDetails(ActionEvent event) throws IOException {
        
        switchSceneUpdateDetails(event);
        
        
    }

    @FXML
    private void onActionBackButton(ActionEvent event) throws IOException {
        
        switchSceneback(event);
        
        
    }

    public void switchSceneback(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource(Links.ADMIN_LOGIN));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }
    
        public void switchSceneUpdateDetails(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource(Links.UPDATE_EMPLOYEE));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

}
