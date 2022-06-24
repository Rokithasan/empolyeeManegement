package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdmindshbordController implements Initializable {

    @FXML
    private Button addemployebuttonid;
    @FXML
    private Button updateemployebuttonid;
    @FXML
    private Button viewallemployeid;
    @FXML
    private Button deletebuttonid;
    @FXML
    private AnchorPane displayanchorePane;

    private AnchorPane anchorPane;
    @FXML
    private Button backButtonid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionAddEmployeButton(MouseEvent event) {

        try {
            anchorPane = FXMLLoader.load(getClass().getResource(Links.ADDEMPLOYE));
            displayanchorePane.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(AdmindshbordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onActionUpdateEmployeButton(MouseEvent event) {

        try {
            anchorPane = FXMLLoader.load(getClass().getResource(Links.UPDATEEMPLOYE));
            displayanchorePane.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(AdmindshbordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onActionViewAllEmployeButton(MouseEvent event) {

        try {
            anchorPane = FXMLLoader.load(getClass().getResource(Links.VIEWALLEMPLOYE));
            displayanchorePane.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(AdmindshbordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onActionDeleteButton(MouseEvent event) {
        try {
            anchorPane = FXMLLoader.load(getClass().getResource(Links.DELETEEMPLOYE));
            displayanchorePane.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(AdmindshbordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onActionBackToHome(ActionEvent event) throws IOException {

        employeLoginScene(event);

    }

    public void employeLoginScene(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource(Links.EMPLOYELOGIN));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Empolye Dashbord ");
        stage.setScene(scene);
        stage.show();

    }

}
