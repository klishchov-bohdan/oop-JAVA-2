package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

	private static Registration registration = new Registration();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_menu;

    @FXML
    private Button print_menu;

    @FXML
    private Button sort_by_name_menu;

    @FXML
    private Button sort_by_date_menu;

    @FXML
    private Button pairs_menu;

    @FXML
    private Button write_menu;

    @FXML
    private Button remove_menu;

    @FXML
    private Button auto_menu;

    @FXML
    void initialize() {
    	add_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("AddClient.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});

    	print_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("PrintClients.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});

    	sort_by_name_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("SortByName.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});

    	sort_by_date_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("SortByDate.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});

    	pairs_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("GetPairs.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});

    	auto_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("AutoAdding.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});

    	remove_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Remove.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});

    	write_menu.setOnAction(event -> {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("WriteToFile.fxml"));

			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch
				e.printStackTrace();
			}

			Parent root = loader.getRoot();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.showAndWait();
    	});
    }


    public static Registration getRegistration(){
		return registration;
    }
    public static void setRegistration(Registration registration){
    	Controller.registration = registration;
    }
}
