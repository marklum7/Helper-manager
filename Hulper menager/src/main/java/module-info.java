module com.example.kursach {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.kursach to javafx.fxml;
    exports com.example.kursach;
}