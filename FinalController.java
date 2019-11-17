package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FinalController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea orderDisplay;

    @FXML
    private Button toStartButton;
    private Pizza currentOrder;
    private LineItem currentItem;
    private static ArrayList<LineItem> totalOrder = new ArrayList<>();
    private static double totalCost =0;
    
    @FXML
    public void toStart(ActionEvent event)  throws IOException{
    	GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("SizesScreen.fxml"));
		Scene scene = new Scene(root,640,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage startwindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		startwindow.setScene(scene);
		startwindow.show();
    }
    @FXML
    void initialize() {
        assert orderDisplay != null : "fx:id=\"orderDisplay\" was not injected: check your FXML file 'finalScreen.fxml'.";
        assert toStartButton != null : "fx:id=\"toStartButton\" was not injected: check your FXML file 'finalScreen.fxml'.";
        if (HamController.ham.equals("None")) {
        	try {
        		currentOrder = new Pizza(SizesController.size, CheesesController.cheese, "None", "None", "None");
        	}
        	catch(IllegalPizza e) {
        		e.printStackTrace();
        	}
        }
        else {
        	try {
        		currentOrder = new Pizza(SizesController.size, CheesesController.cheese, pepperController.pepper, pineappleController.pineapple, HamController.ham);
        	}
        	catch(IllegalPizza e) {
        		e.printStackTrace();
        	}
        }
        try {
			currentItem = new LineItem(amountController.amount, currentOrder);
		} catch (IllegalPizza e) {
			e.printStackTrace();
		}
        totalCost += currentItem.getCost();
        totalOrder.add(currentItem);
        orderDisplay.setText(totalOrder.toString() + "\n Total Cost=" + String.format("%.2f", totalCost));
    }
}
