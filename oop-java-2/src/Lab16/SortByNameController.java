package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SortByNameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button_sort_by_name;

    @FXML
    private Button sort_by_name_button;

    @FXML
    private TextField sort_by_name_field;

    @FXML
    void initialize() {
    	sort_by_name_button.setOnAction(event -> {
    		Registration registration = Controller.getRegistration();
    		registration.sortByName();
    		sort_by_name_field.setText("Complete!!!");
    		Controller.setRegistration(registration);
    	});

    	back_button_sort_by_name.setOnAction(event -> {
    		Stage stage = (Stage) back_button_sort_by_name.getScene().getWindow();
    	    stage.close();
    	});
    }
}
