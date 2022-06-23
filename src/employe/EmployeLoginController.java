package employe;

import Helper.Links;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Hp
 */
public class EmployeLoginController implements Initializable {
    
    static ObservableList list = FXCollections.observableArrayList();
    
    String username = "rokit";
    String password = "1234";
    
    static String uname = "";
    
    @FXML
    private TextField nametextfield;
    @FXML
    private TextField passwordtextfield;
    @FXML
    private Button andminbutton;
    @FXML
    private Button employeloginbuttonid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {
        
        String name = nametextfield.getText();
        String password = passwordtextfield.getText();
        
        if (name.isEmpty() || password.isEmpty()) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill all requre Information");
            alert.showAndWait();
        } else {
            
            if (name.equals(username) && password.equals(this.password)) {
                
                uname = name;
                
                ((Node) event.getSource()).getScene().getWindow().hide();
                
                employeLoginScene(event);
                
            } else {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter valid Data");
                alert.showAndWait();
                
            }
            
        }
    }
    
    @FXML
    private void handleAdminLoginButtonAction(ActionEvent event) throws IOException {
        
        adminLoginScene(event);
        
    }
    
    public static String getVariable() {
        
        return uname;
    }
    
    public void employeLoginScene(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource(Links.EMPLOYEDASHBORD));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Empolye Dashbord ");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void adminLoginScene(ActionEvent event) throws IOException {
        Parent layout = FXMLLoader.load(getClass().getResource(Links.ADMINLOGIN));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(layout);
        stage.setTitle("Admin Login ");
        stage.setScene(scene);
        stage.show();
        
    }
}
