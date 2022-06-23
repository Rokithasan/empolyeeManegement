module com.example.empolyeemanegement {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires com.google.common;

    opens com.example.empolyeemanegement to javafx.fxml;
    exports com.example.empolyeemanegement;
}