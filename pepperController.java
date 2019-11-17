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

public class pepperController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton noPepperButton;

    @FXML
    private ToggleGroup pepperGroup;

    @FXML
    private RadioButton singlePepperButton;

    @FXML
    private Button toPineappleButton;

    @FXML
    private Label pepperCostLabel;
    @FXML
    private Label progressLabel;
    public static double costAfterPepper;
    public static String pepper = "None entered";
    
    @FXML
    public void toPineappleScene(ActionEvent event) throws IOException {
    	if (!(pepper.equals("None entered"))) {
    	GridPane pineapplePane = (GridPane)FXMLLoader.load(getClass().getResource("PineappleScreen.fxml"));
    	Scene pineappleScene = new Scene(pineapplePane);
    	Stage pineapplewindow = (Stage)((Node)event.getSource()).getScene().getWindow();
    	pineappleScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	pineapplewindow.setScene(pineappleScene);
    	pineapplewindow.show();
    	}
    	progressLabel.setText("Make a selection");
    }
    @FXML
    void initialize() {
        assert noPepperButton != null : "fx:id=\"noPepperButton\" was not injected: check your FXML file 'GreenPepperScreen.fxml'.";
        assert pepperGroup != null : "fx:id=\"pepperGroup\" was not injected: check your FXML file 'GreenPepperScreen.fxml'.";
        assert singlePepperButton != null : "fx:id=\"singlePepperButton\" was not injected: check your FXML file 'GreenPepperScreen.fxml'.";
        assert toPineappleButton != null : "fx:id=\"toPineappleButton\" was not injected: check your FXML file 'GreenPepperScreen.fxml'.";
        assert pepperCostLabel != null : "fx:id=\"pepperCostLabel\" was not injected: check your FXML file 'GreenPepperScreen.fxml'.";
        pepperCostLabel.setText(pepperCostLabel.getText() + String.format("%.2f",HamController.costAfterHam) + "$"); 
        noPepperButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	pepperCostLabel.setText(pepperCostLabel.getText().substring(0,11) + String.format("%.2f",HamController.costAfterHam) + "$"); 
            	pepper = "None";
             	costAfterPepper =(HamController.costAfterHam);

            	 }
          });
        singlePepperButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	pepperCostLabel.setText(pepperCostLabel.getText().substring(0,11) + String.format("%.2f",HamController.costAfterHam +1.5) + "$"); 
            	pepper = "Single";
             	costAfterPepper =(HamController.costAfterHam +1.5);

            	 }
          });
    }
}
