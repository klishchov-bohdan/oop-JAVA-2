package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GetPairsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_pairs_button;

    @FXML
    private TextArea get_pairs_area;

    @FXML
    private Button update_pairs_button;

    @FXML
    void initialize() {
    	update_pairs_button.setOnAction(event -> {
    		Registration registration = Controller.getRegistration();
    		String pairs = Helper.searchPairs(registration);
    		get_pairs_area.setText(pairs);
    	});

    	back_pairs_button.setOnAction(event -> {
    		Stage stage = (Stage) back_pairs_button.getScene().getWindow();
    	    stage.close();
    	});
    }
}
