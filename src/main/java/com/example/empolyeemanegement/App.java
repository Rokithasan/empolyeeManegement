
package com.example.empolyeemanegement;

import com.example.empolyeemanegement.repository.UserDAO;
import com.example.empolyeemanegement.utils.Links;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// app starter
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        UserDAO dao = new UserDAO();
        dao.findAll();

        Parent root = FXMLLoader.load(getClass().getResource(Links.EMPLOYEE_LOGIN));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
