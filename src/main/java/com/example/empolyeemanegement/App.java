
package com.example.empolyeemanegement;

import com.example.empolyeemanegement.controller.Links;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// app starter
public class App extends Application {

    public static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        App.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource(Links.EMPLOYELOGIN));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
