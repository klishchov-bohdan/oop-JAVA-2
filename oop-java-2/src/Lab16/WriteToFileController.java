package application;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class WriteToFileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_write_button;

    @FXML
    private TextArea file_area;

    @FXML
    private Button write_to_file_button;

    @FXML
    private Button clear_file_button;

    @FXML
    void initialize() {
    	write_to_file_button.setOnAction(event -> {
    		Registration registration = Controller.getRegistration();
    		try(FileWriter writer = new FileWriter("clients.txt", false))
	        {
				for(int i = 0; i < registration.getSize(); i++) {
					writer.write(registration.clientToStringByIndex(i));
				}
	            writer.flush();
	        }
	        catch(IOException ex){

	            System.out.println(ex.getMessage());
	        }

    		try(FileReader reader = new FileReader("clients.txt"))
	        {
	            int c;
	            String res = "";
	            while((c=reader.read())!=-1){
	                res = res + (char)c;
	            }
	            file_area.setText(res);
	        }
	        catch(IOException ex){

	            System.out.println(ex.getMessage());
	        }
    	});

    	clear_file_button.setOnAction(event -> {
    		try(FileWriter writer = new FileWriter("clients.txt", false))
	        {
				writer.write("");
	            writer.flush();
	        }
	        catch(IOException ex){

	            System.out.println(ex.getMessage());
	        }
    		try(FileReader reader = new FileReader("clients.txt"))
	        {
	            int c;
	            String res = "";
	            while((c=reader.read())!=-1){
	                res = res + (char)c;
	            }
	            file_area.setText(res);
	        }
	        catch(IOException ex){

	            System.out.println(ex.getMessage());
	        }
    	});

    	back_write_button.setOnAction(event -> {
    		Stage stage = (Stage) back_write_button.getScene().getWindow();
    	    stage.close();
    	});
    }
}
