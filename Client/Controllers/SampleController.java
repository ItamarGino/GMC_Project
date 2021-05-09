package client.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleController {
	
	@FXML
    private ImageView UpdateVersionPlease;

    @FXML
    private Button FinishUpdateButtoN;

    @FXML
    private Label ViewsNumberOfCollection;

    @FXML
    private Label VersionNumber;

    @FXML
    private Button ViewMapsCollection;

    @FXML
    private Button MapSettings;

    @FXML
    private Label VersionNumber1;

    @FXML
    private TextField TextFiledSearch;

    @FXML
    private Button Search;

    @FXML
     void ChangeVersionNumber(MouseEvent event) throws IOException {
    	String a=ViewsNumberOfCollection.getText();
    	Integer b=Integer.parseInt(a);
    	b++;
    	ViewsNumberOfCollection.setText(b.toString());
		Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
		BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("Sample2.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		ChangeVersionStageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("New Window");
		NewWindow.show();
    }
 
    
    void SetNewUpdateVersionNumber(String Setme) {
    	VersionNumber.setText(Setme);
    }

    
    
    
    @FXML
    void BackToCatalog(MouseEvent event) throws IOException {
    	Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
		BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		ChangeVersionStageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("New Window");
		NewWindow.show();
    }
    @FXML
    void SeeCityMaps(MouseEvent event) throws IOException{
		Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
		BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("Sample2.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		ChangeVersionStageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("New Window");
		NewWindow.show();

    }
    
}

    		
 
