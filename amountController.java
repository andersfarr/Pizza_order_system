
package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class amountController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

    @FXML
    private ChoiceBox numberBox;
    
    @FXML
    private Label costLabel;
    
    @FXML
    private Button toFinalButton;
    
    @FXML
    private ObservableList<Integer> boxFill = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100);
    private static double costBeforeAmount;
    public static double costAfterAmount;
    public static int amount;
    @FXML
    public void toFinalScene(ActionEvent event) throws IOException{
    	amount = (int)numberBox.getValue();
    	GridPane finalPane = (GridPane)FXMLLoader.load(getClass().getResource("finalScreen.fxml"));
    	Scene finalScene = new Scene(finalPane);
    	Stage finalwindow = (Stage)((Node)event.getSource()).getScene().getWindow();
    	finalScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	finalwindow.setScene(finalScene);
    	finalwindow.show();
    }
    
    @FXML
    void initialize() {
    	assert numberBox != null : "fx:id=\"possibleVals\" was not injected: check your FXML file 'amountScreen.fxml'.";
		numberBox.setItems(boxFill);
		numberBox.setValue(1);
		if(HamController.ham.equals("None")) {
	        costLabel.setText(costLabel.getText() + String.format("%.2f",HamController.costAfterHam) + "$"); 
	        costBeforeAmount = HamController.costAfterHam;
		}
		else {
	        costLabel.setText(costLabel.getText() + String.format("%.2f",pineappleController.costAfterPineapple) + "$"); 
	        costBeforeAmount = pineappleController.costAfterPineapple;
		}
		costAfterAmount = costBeforeAmount;
		numberBox.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if ((int)numberBox.getValue() <10) {
					costLabel.setText(costLabel.getText().substring(0,11) + String.format("%.2f", costBeforeAmount*(int)numberBox.getValue()));
					costAfterAmount = costBeforeAmount*(int)numberBox.getValue();
				}
				else if ((int)numberBox.getValue() < 20) {
					costLabel.setText(costLabel.getText().substring(0,11) + String.format("%.2f", costBeforeAmount*(int)numberBox.getValue()*0.95));
					costAfterAmount = costBeforeAmount*(int)numberBox.getValue()*0.95;
				}
				else {
					costLabel.setText(costLabel.getText().substring(0,11) + String.format("%.2f", costBeforeAmount*(int)numberBox.getValue()*0.90));
					costAfterAmount = costBeforeAmount*(int)numberBox.getValue()*0.90;
				}
			}
			
		});
	}
}


