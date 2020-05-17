package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemoveController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_remove;

    @FXML
    private Button remove_clients_button;

    @FXML
    private TextField remove_field;

    @FXML
    void initialize() {
    	remove_clients_button.setOnAction(event -> {
    		Registration registration = Controller.getRegistration();
    		registration.clearClients();
    		Controller.setRegistration(registration);
    	});

    	back_remove.setOnAction(event -> {
    		Stage stage = (Stage) back_remove.getScene().getWindow();
    	    stage.close();
    	});
    }
}
