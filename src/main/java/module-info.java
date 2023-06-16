module com.example.gymmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.gymmanagement to javafx.fxml;
    exports com.example.gymmanagement;
}