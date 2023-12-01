module com.example.atm_machine {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atm_machine to javafx.fxml;
    exports com.example.atm_machine;
}