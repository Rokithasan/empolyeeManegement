package com.example.empolyeemanegement.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminloginController implements Initializable {

    String username = "admin";
    String password = "admin";

    @FXML
    private TextField nameadmintextfield;
    @FXML
    private TextField passwordtextfieldid;
    @FXML
    private Button adminloginbutton;
    @FXML
    private AnchorPane displayAnchorepane;

    private AnchorPane anchorPane;
    @FXML
    private Button backtoimployeloginId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onActionAdminLogin(ActionEvent event) throws IOException {

        String name = nameadmintextfield.getText();
        String password = passwordtextfieldid.getText();

        if (name.isEmpty() || password.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill all requre Information");
            alert.showAndWait();
        } else {

            if (name.equals(username) && password.equals(this.password)) {

                ((Node) event.getSource()).getScene().getWindow().hide();

                adminDashbordScene(event);

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid Data");
                alert.showAndWait();

            }

        }

    }

    @FXML
    private void onActionAdminLogin(MouseEvent event) {
    }

    @FXML
    private void onActionBack(ActionEvent event) throws IOException {

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

    public void adminDashbordScene(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource(Links.ADMINDASHBORD));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Admin Dashbord ");
        stage.setScene(scene);
        stage.show();

    }
}
