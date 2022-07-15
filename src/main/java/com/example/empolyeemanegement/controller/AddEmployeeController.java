
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
public class AddEmployeeController implements Initializable {

    @FXML
    private TextField employenamtextfieldid;
    @FXML
    private TextField empolyeposttextfieldid;
    @FXML
    private TextArea employefulldetailsid;
    @FXML
    private Button saveemployebuttonid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void onActionSaveEmploye(ActionEvent event) {
    }
    
}
