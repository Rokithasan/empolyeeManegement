module com.example.empolyeemanegement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.empolyeemanegement to javafx.fxml;
    exports com.example.empolyeemanegement;
}