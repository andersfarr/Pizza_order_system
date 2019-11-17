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

public class CheesesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton singleButton;

    @FXML
    private ToggleGroup Cheeses;

    @FXML
    private RadioButton doubleButton;

    @FXML
    private RadioButton tripleButton;

    @FXML
    private Label costLabel;

    @FXML
    private Button hamSceneButton;

    @FXML
    private Label proceedLabel;

    public static String cheese = "None selected";
    public static double costAfterCheese = (double)SizesController.afterSizesCost;
    
    public void toHamScene(ActionEvent event) throws IOException {
    	if (!(cheese.equals("None selected"))) {
    	GridPane hamPane = (GridPane)FXMLLoader.load(getClass().getResource("HamScreen.fxml"));
    	Scene hamScene = new Scene(hamPane);
    	Stage hamwindow = (Stage)((Node)event.getSource()).getScene().getWindow();
    	hamScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	hamwindow.setScene(hamScene);
    	hamwindow.show();
    	}
    	proceedLabel.setText("Make a Selection");
    	
    }
    
    @FXML
    void initialize() {
        assert singleButton != null : "fx:id=\"singleButton\" was not injected: check your FXML file 'CheesesScreen.fxml'.";
        assert Cheeses != null : "fx:id=\"Cheeses\" was not injected: check your FXML file 'CheesesScreen.fxml'.";
        assert doubleButton != null : "fx:id=\"doubleButton\" was not injected: check your FXML file 'CheesesScreen.fxml'.";
        assert tripleButton != null : "fx:id=\"tripleButton\" was not injected: check your FXML file 'CheesesScreen.fxml'.";
        assert costLabel != null : "fx:id=\"costLabel\" was not injected: check your FXML file 'CheesesScreen.fxml'.";
        assert hamSceneButton != null : "fx:id=\"hamSceneButton\" was not injected: check your FXML file 'CheesesScreen.fxml'.";
        assert proceedLabel != null : "fx:id=\"proceedLabel\" was not injected: check your FXML file 'CheesesScreen.fxml'.";
    	costLabel.setText(costLabel.getText() + SizesController.afterSizesCost + ".00$");;; 

        singleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
            	cheese = "Single";
            	costLabel.setText(costLabel.getText().substring(0,11) + SizesController.afterSizesCost + ".00$");}
          });
        doubleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	costLabel.setText(costLabel.getText().substring(0,11) + ((SizesController.afterSizesCost+1.5) + "0$"));;;
            	cheese = "Double";
            	costAfterCheese =(SizesController.afterSizesCost+1.5);
;
            }
          });
        tripleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	costLabel.setText(costLabel.getText().substring(0,11) + ((SizesController.afterSizesCost+3) + ".00$"));;;           
            	 cheese = "Triple";
             	costAfterCheese =(SizesController.afterSizesCost+3);

            	 }
          });
        
    }
}
