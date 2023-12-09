module com.example.nuvote {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires activation;


    opens com.example.nuvote to javafx.fxml;
    exports com.example.nuvote;
}