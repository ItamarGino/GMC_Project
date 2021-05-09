package client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ViewStarter;
import common.controllers.Message;
import common.controllers.OperationType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;


public class LogInController {
	
	@FXML
    private Hyperlink NewAccount;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private PasswordField PasswordText;
    
    @FXML
    private TextField UserNameText;
    
    @FXML
    private Label UserNameLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private URL location;

    @FXML
    private Button LoginButton;

    @FXML
    private Hyperlink ForgotPassword;

    @FXML
    private Button ViewCatalogButton;

    
    @FXML
    void pressLogin(ActionEvent event) {
    	
    	String user=UserNameText.getText();
    	String pass=PasswordText.getText();
    	if(user.isEmpty()||pass.isEmpty())
    		ClientMessages.popUp(AlertType.ERROR,"ERROR","One or more fields Empty!","Fill username and password!");
    	else {
    		String query="SELECT userName FROM user WHERE userName='"+user+"' AND Password='"+pass+"';";
    		ViewStarter.client.handleMessageFromClientUI(new Message(OperationType.Login,query));
    	   	try {
    		((Node)event.getSource()).getScene().getWindow().hide();
			BorderPane root=FXMLLoader.load(getClass().getResource("/client/boundry/UserHomePage.fxml"));
			Scene scene=new Scene(root);
			Stage primaryStage= new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    }
    
    @FXML
    void GoToCityCatalog(MouseEvent event) throws IOException {
    	Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
		BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("/client/boundry/CityCatalog.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("City Catalog");
		NewWindow.show();
    }
    @FXML
    void GoToNewUserAccount(MouseEvent event) throws IOException {
    	Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
		BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("/client/boundry/SignUpWindow.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("New User");
		NewWindow.show();
    }

    @FXML
    void GoToForrgotPassword(MouseEvent event) {

    }

/*    @FXML
    void GoToUserHomePage(MouseEvent event) throws IOException {
    	Stage NewWindow=(Stage) (((Node) event.getSource()).getScene().getWindow());
    	BorderPane ChangeVersionStage = (BorderPane)FXMLLoader.load(getClass().getResource("/client/boundry/UserHomePage.fxml"));
		Scene ChangeVersionStageScene = new Scene(ChangeVersionStage,NewWindow.getWidth(),NewWindow.getHeight());
		NewWindow.setScene(ChangeVersionStageScene);
		NewWindow.setTitle("New User");
		NewWindow.show();
    }*/
    
    @FXML
    void MovePasswordUp(MouseEvent  event) {
    	
        		TranslateTransition transition= new TranslateTransition();
                transition.setDuration(Duration.seconds(0.3));
                transition.setNode(PasswordLabel);
                transition.setToY(-20);
                transition.play();
           
                
    }
    
    @FXML
    void MovePasswordDown(MouseEvent event) { 	
    }

    @FXML
    void MoveUserNameUp(MouseEvent  event) {
    
    		TranslateTransition transition= new TranslateTransition();
            transition.setDuration(Duration.seconds(0.3));
            transition.setNode(UserNameLabel);
            transition.setToY(-20);
            transition.play();
    }
    

    @FXML
    void initialize() {
        assert LoginButton != null : "fx:id=\"LoginButton\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert ForgotPassword != null : "fx:id=\"ForgotPassword\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert ViewCatalogButton != null : "fx:id=\"ViewCatalogButton\" was not injected: check your FXML file 'HomePage.fxml'.";
       
     // LoginButton
    }
}
