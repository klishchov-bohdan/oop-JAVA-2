package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class PrintClientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

    @FXML
    private TextArea print_clients_area;

    @FXML
    private Button update_button;

    @FXML
    void initialize() {
    	update_button.setOnAction(event -> {
    		Registration registration = Controller.getRegistration();
    		String clients = "";
    		for(int i = 0; i < registration.getSize(); i++){
    			clients = clients + registration.clientToStringByIndex(i);
    		}

    		print_clients_area.setText(clients);
    	});

    	back_button.setOnAction(event -> {
    		Stage stage = (Stage) back_button.getScene().getWindow();
    	    stage.close();
    	});
    }
}
