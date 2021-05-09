/**
 * Sample Skeleton for 'SignUpWindow.fxml' Controller Class
 */

package client.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.text.AbstractDocument.Content;

import client.ViewStarter;
import common.controllers.Message;
import common.controllers.OperationType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

public class PublicController {

    @FXML // fx:id="userNameTxt"
    private TextField userNameTxt; // Value injected by FXMLLoader

    @FXML // fx:id="FirstNameTxt"
    private TextField FirstNameTxt; // Value injected by FXMLLoader

    @FXML // fx:id="LastNameTxt"
    private TextField LastNameTxt; // Value injected by FXMLLoader

    @FXML // fx:id="EmailTxt"
    private TextField EmailTxt; // Value injected by FXMLLoader

    @FXML // fx:id="CellphoneTxt"
    private TextField CellphoneTxt; // Value injected by FXMLLoader

    @FXML // fx:id="PasswordTxt"
    private PasswordField PasswordTxt; // Value injected by FXMLLoader

    @FXML // fx:id="RePasswordTxt"
    private PasswordField RePasswordTxt; // Value injected by FXMLLoader

    @FXML // fx:id="SignBtn"
    private Button SignBtn; // Value injected by FXMLLoader

    @FXML
    void pressSignBtn(ActionEvent event) {

    	String username=userNameTxt.getText();
    	String firstname=FirstNameTxt.getText();
    	String lastname=LastNameTxt.getText();
    	String email=EmailTxt.getText();
    	String cellphone=CellphoneTxt.getText();
    	String password=PasswordTxt.getText();
    	String repassword=RePasswordTxt.getText();
    	String query = null;
    	String[] arr= {username,firstname,lastname,email,cellphone,password};
    	if(username.isEmpty()||firstname.isEmpty()||lastname.isEmpty()||email.isEmpty()||cellphone.isEmpty())
    		ClientMessages.popUp(AlertType.ERROR,"ERROR","You have Empty fields!","Fill all the fields!");
    	else if(!ClientTools.isValidEmail(email))
    		ClientMessages.popUp(AlertType.ERROR, "Email Error", "EMAIL ERROR", "EMAIL IS NOT LEGALE");
    	else if(!password.equals(repassword))
    		ClientMessages.popUp(AlertType.ERROR, "ERROR", "PASSWORD NOT MATCH", "PLEASE ENTER identical PASSWORDS");
    	else if(!ClientTools.validatePhoneNumber(cellphone))
            ClientMessages.popUp(AlertType.ERROR, "Phone number", "PHONE NUMBER ERROR", "PLEASE CHEAK YOUR PHONE NUMBER");
    	else {
            query="INSERT INTO user VALUES('";
    		for(int i=0;i<6;i++)
    			query+=arr[i]+"','";
    		query+="customer');";
    	System.out.println(query);
    	ViewStarter.client.handleMessageFromClientUI(new Message(OperationType.SignUp,query));
    	}

/*    	try {
    		((Node)event.getSource()).getScene().getWindow().hide();
			BorderPane root=FXMLLoader.load(getClass().getResource("/client/boundry/Login.fxml"));
			Scene scene=new Scene(root);
			Stage primaryStage= new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

}
