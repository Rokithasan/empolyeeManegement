/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.empolyeemanegement.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class EmployeeUpdateController implements Initializable {

    @FXML
    private TextField updatenametextfieldId;
    @FXML
    private TextField updateposttextfieldid;
    @FXML
    private TextArea updatedetailstextfieldid;
    @FXML
    private Button updatebuttonid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionUpdateEmploye(ActionEvent event) {
    }
    
}
