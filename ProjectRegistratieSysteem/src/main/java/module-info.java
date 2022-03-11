module com.example.projectregistratiesysteem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectregistratiesysteem to javafx.fxml;
    exports com.example.projectregistratiesysteem;
}