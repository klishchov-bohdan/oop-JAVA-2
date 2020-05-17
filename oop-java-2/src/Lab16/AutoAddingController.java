package application;

import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AutoAddingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_auto;

    @FXML
    private Button add_random_clients_button;

    @FXML
    private TextField auto_adding_field;

    @FXML
    void initialize() {
    	add_random_clients_button.setOnAction(event -> {
    		Registration registration = Controller.getRegistration();
    		Random random = new Random ();
    		String[] gender = {"male", "female"};
    		String[] name = {"John", "Victor", "James", "Lila", "Kate", "Lisa"};
    		String[] hobby = {"fishing", "football", "chess"};
    		String[] requirements = {"honestly", "kindness", "sense of humor"};
    		String[] phoneNums = {"+38(067)-106-46-38", "+38(066)-697-32-99", "+38(093)-782-39-50"};
    		String phoneNumber;

    		for(int i = 0; i < 5; i++) {
    			phoneNumber =  Helper.getRandomString(phoneNums);
    			registration.register(
    					Helper.getRandomString(gender),
    					new Date(),
    					Helper.getRandomString(name),
    					random.nextInt(29) + 16,
    					Helper.getRandomString(hobby),
    					Helper.getRandomString(requirements),
    					phoneNumber,
    					Helper.getProvider(phoneNumber));
    		}
    		auto_adding_field.setText("Complete!!!");
    		Controller.setRegistration(registration);
    	});

    	back_auto.setOnAction(event -> {
    		Stage stage = (Stage) back_auto.getScene().getWindow();
    	    stage.close();
    	});
    }
}
