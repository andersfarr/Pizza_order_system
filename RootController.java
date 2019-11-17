package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RootController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NextSceneButton;
    
    @FXML
    public void toSizesScene(ActionEvent event) throws IOException {
    	GridPane sizesPane = (GridPane)FXMLLoader.load(getClass().getResource("SizesScreen.fxml"));
    	Scene sizesScene = new Scene(sizesPane);
    	Stage sizeswindow = (Stage)((Node)event.getSource()).getScene().getWindow();
    	sizesScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	sizeswindow.setScene(sizesScene);
    	sizeswindow.show();
    }
    @FXML
    void initialize() {
        assert NextSceneButton != null : "fx:id=\"NextSceneButton\" was not injected: check your FXML file 'RootPane.fxml'.";

    }
}
