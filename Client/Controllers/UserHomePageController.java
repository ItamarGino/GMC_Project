package client.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserHomePageController {

    @FXML
    private Button CityCatalogButton;

    @FXML
    private Button ClientCardButton;

    @FXML
    void GoToCityCatalogPage(MouseEvent event) throws IOException {
    	Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
		BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("CityCatalog.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		ChangeVersionStageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("City Catalog");
		NewWindow.show();
    }

    @FXML
    void GoToClientCardPage(MouseEvent event) throws IOException {
    	Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
		BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("ClientCardPage.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		ChangeVersionStageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("City Catalog");
		NewWindow.show();
    }

}
