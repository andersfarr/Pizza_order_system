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

public class SizesController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label costLabel;
    @FXML
    private Button cheeseSceneButton;
    @FXML
    private RadioButton smallButton;
    @FXML
    private RadioButton mediumButton;
    @FXML
    private RadioButton largeButton;
    @FXML
    private ToggleGroup Sizes;
    @FXML
    private Label proceedLabel;
    
    public static String size;
    public static int afterSizesCost = 0;
    public void changeCost() {
   
    }
    @FXML
    public void toCheesesScene(ActionEvent event) throws IOException {
    	if (costLabel.getText().length()  > 12) {
    	GridPane cheesesPane = (GridPane)FXMLLoader.load(getClass().getResource("CheesesScreen.fxml"));
    	Scene cheesesScene = new Scene(cheesesPane);
    	Stage cheeseswindow = (Stage)((Node)event.getSource()).getScene().getWindow();
    	cheesesScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	cheeseswindow.setScene(cheesesScene);
    	cheeseswindow.show();
    	}
    	proceedLabel.setText("Make a Selection");
    	
    }
    @FXML
    void initialize() {
        assert Sizes != null : "fx:id=\"Sizes\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        assert smallButton != null : "fx:id=\"smallButton\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        assert Sizes != null : "fx:id=\"Sizes\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        assert mediumButton != null : "fx:id=\"mediumButton\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        assert largeButton != null : "fx:id=\"largeButton\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        assert cheeseSceneButton != null : "fx:id=\"cheeseSceneButton\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        assert costLabel != null : "fx:id=\"costLabel\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        assert proceedLabel != null : "fx:id=\"proceedLabel\" was not injected: check your FXML file 'SizesScreen.fxml'.";
        smallButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	costLabel.setText(costLabel.getText().substring(0,11) + "7.00$");;; 
            	size = "Small";
            	afterSizesCost = 7;}
          });
        mediumButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	costLabel.setText(costLabel.getText().substring(0,11) + "9.00$");;;
            	size = "Medium";
            	afterSizesCost = 9;
            }
          });
        largeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	costLabel.setText(costLabel.getText().substring(0,11) + "11.00$");;;           
            	 size = "Large";
            	 afterSizesCost = 11;}
          });
        
    }
}
