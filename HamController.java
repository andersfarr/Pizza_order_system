package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HamController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton noHamButton;

    @FXML
    private ToggleGroup HamGroup;

    @FXML
    private RadioButton singleHamButton;

    @FXML
    private Button nextSceneButton;

    @FXML
    private Label hamCostLabel;

    @FXML
    private Label proceedLabel;
    
    public static String ham = "None Selected";
    public static double costAfterHam;
    public void toNextScene(ActionEvent event) throws IOException {
    	if (ham.equals("None")) {
    	GridPane amountPane = (GridPane)FXMLLoader.load(getClass().getResource("amountScreen.fxml"));
    	Scene amountScene = new Scene(amountPane);
    	Stage amountwindow = (Stage)((Node)event.getSource()).getScene().getWindow();
    	amountScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	amountwindow.setScene(amountScene);
    	amountwindow.show();
    	}
    	else if(ham.equals("Single")) {
    		GridPane greenPepperPane = (GridPane)FXMLLoader.load(getClass().getResource("GreenPepperScreen.fxml"));
        	Scene greenPepperScene = new Scene(greenPepperPane);
        	Stage greenPepperwindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        	greenPepperScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        	greenPepperwindow.setScene(greenPepperScene);
        	greenPepperwindow.show();
    	}
    	proceedLabel.setText("Make a Selection");
    	
    }
    @FXML
    void initialize() {
        assert noHamButton != null : "fx:id=\"noHamButton\" was not injected: check your FXML file 'HamScreen.fxml'.";
        assert HamGroup != null : "fx:id=\"Ham\" was not injected: check your FXML file 'HamScreen.fxml'.";
        assert singleHamButton != null : "fx:id=\"singleHamButton\" was not injected: check your FXML file 'HamScreen.fxml'.";
        assert nextSceneButton != null : "fx:id=\"nextSceneButton\" was not injected: check your FXML file 'HamScreen.fxml'.";
        assert hamCostLabel != null : "fx:id=\"hamCostLabel\" was not injected: check your FXML file 'HamScreen.fxml'.";
        assert proceedLabel != null : "fx:id=\"proceedLabel\" was not injected: check your FXML file 'HamScreen.fxml'.";
    	hamCostLabel.setText(hamCostLabel.getText() + String.format("%.2f",CheesesController.costAfterCheese) + "$"); 
        noHamButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	hamCostLabel.setText(hamCostLabel.getText().substring(0,11) + String.format("%.2f",CheesesController.costAfterCheese) + "$"); 
            	ham = "None";
             	costAfterHam =(CheesesController.costAfterCheese);

            	 }
          });
        singleHamButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	hamCostLabel.setText(hamCostLabel.getText().substring(0,11) + String.format("%.2f",CheesesController.costAfterCheese +1.5) + "$"); 
            	ham = "Single";
             	costAfterHam =(CheesesController.costAfterCheese +1.5);

            	 }
          });
    }
}