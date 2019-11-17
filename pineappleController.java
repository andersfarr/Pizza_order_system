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

public class pineappleController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button nextScreenButton;

    @FXML
    private Label pineappleCostLabel;

    @FXML
    private Label ProgressLabel;

    @FXML
    private RadioButton noPineappleButton;

    @FXML
    private ToggleGroup pineapples;

    @FXML
    private RadioButton singlePineappleButton;
    public static String pineapple = "None entered";
    public static double costAfterPineapple;
    public void toNextScene(ActionEvent event) throws IOException {
    	if (!(pineapple.equals("None entered")) ){
    	GridPane amountPane = (GridPane)FXMLLoader.load(getClass().getResource("amountScreen.fxml"));
    	Scene amountScene = new Scene(amountPane);
    	Stage amountwindow = (Stage)((Node)event.getSource()).getScene().getWindow();
    	amountScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	amountwindow.setScene(amountScene);
    	amountwindow.show();
    	}
    	ProgressLabel.setText("Make a Selection");
    }
    	
    @FXML
    void initialize() {
        assert nextScreenButton != null : "fx:id=\"nextScreenButton\" was not injected: check your FXML file 'PineappleScreen.fxml'.";
        assert pineappleCostLabel != null : "fx:id=\"pineappleCostLabel\" was not injected: check your FXML file 'PineappleScreen.fxml'.";
        assert ProgressLabel != null : "fx:id=\"ProgressLabel\" was not injected: check your FXML file 'PineappleScreen.fxml'.";
        assert noPineappleButton != null : "fx:id=\"noPineappleButton\" was not injected: check your FXML file 'PineappleScreen.fxml'.";
        assert pineapples != null : "fx:id=\"pineapples\" was not injected: check your FXML file 'PineappleScreen.fxml'.";
        assert singlePineappleButton != null : "fx:id=\"singlePineappleButton\" was not injected: check your FXML file 'PineappleScreen.fxml'.";
        pineappleCostLabel.setText(pineappleCostLabel.getText() + String.format("%.2f",pepperController.costAfterPepper) + "$"); 
        noPineappleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	pineappleCostLabel.setText(pineappleCostLabel.getText().substring(0,11) + String.format("%.2f",pepperController.costAfterPepper) + "$"); 
            	pineapple = "None";
             	costAfterPineapple =(pepperController.costAfterPepper);

            	 }
          });
        singlePineappleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	pineappleCostLabel.setText(pineappleCostLabel.getText().substring(0,11) + String.format("%.2f",pepperController.costAfterPepper+1.5) + "$"); 
            	pineapple = "Single";
             	costAfterPineapple =(pepperController.costAfterPepper +1.5);

            	 }
          });
    }
}
