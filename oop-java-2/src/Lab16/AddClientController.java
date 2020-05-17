package application;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_button;

    @FXML
    private TextField name_field;

    @FXML
    private TextField age_field;

    @FXML
    private TextField hobby_field;

    @FXML
    private TextField req_field;

    @FXML
    private TextField phone_field;

    @FXML
    private CheckBox male_check;

    @FXML
    private CheckBox female_check;

    @FXML
    private Button back_button_add;

    @FXML
    void initialize() {
    	add_button.setOnAction(event -> {
    		Registration registration = Controller.getRegistration();
    		String addName = name_field.getText().trim();
    		String addAge = age_field.getText().trim();
    		String addHobby = hobby_field.getText().trim();
    		String addReq = req_field.getText().trim();
    		String addPhone = phone_field.getText().trim();
    		String gender = "";
    		if(male_check.isSelected()){
    			gender = "male";
    		} else if(female_check.isSelected()) {
    			gender = "female";
    		}
    		registration.register(gender, new Date(), addName, Integer.parseInt(addAge), addHobby, addReq, addPhone, Helper.getProvider(addPhone));
    		Controller.setRegistration(registration);
    		name_field.setText("");
    	});

    	back_button_add.setOnAction(event -> {
    		Stage stage = (Stage) back_button_add.getScene().getWindow();
    	    stage.close();
    	});

    }


}
