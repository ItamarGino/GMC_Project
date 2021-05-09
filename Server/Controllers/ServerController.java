package server.controllers;

import java.awt.TextField;
import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import server.EchoServer;
import server.StartServer;
import server.mysqlConnection;

public class ServerController {

	mysqlConnection mysql=new mysqlConnection();
	 
    @FXML
    private JFXPasswordField DBPasswordTextField;// Text field for the user to enter the password

    @FXML
    private Label NoPasswordWarnnig; //Warning Label that the user didn't enter password

    @FXML
    private JFXRadioButton BraudeDefaultPassword; // insert the default password of braude -> "Aa123456"
    
    @FXML
    private JFXToggleButton SendPasswordButton;
    
    @FXML
    private Label ServerState;  //Label For server state: ON/OFF
    
    
    @FXML
    void SetServerState(ActionEvent event) {
    	
    	if(DBPasswordTextField.getText().isEmpty()) {
    		NoPasswordWarnnig.setVisible(true);
    		SendPasswordButton.setSelected(false);
    		return;
    		}//if the password field is empty 
    	
    		if(SendPasswordButton.isSelected()) 
    		{
    			try {
    				NoPasswordWarnnig.setVisible(false);
					StartServer.echoserver.listen();
					mysql.openConnection(DBPasswordTextField.getText()); //opening a connection to the database with the given password 
	    			ServerState.setText("ON");		//Set the server button "ON" 
	    	    	ServerState.setTextFill(Color.web("#5fed3f"));
    			}//End try
				catch (Exception e) {
					Platform.runLater(new Runnable() {  //in case the connection failed we show a pop up message that the connection faild 
		     			@Override
		 				public void run() {
		     				Alert alert = new Alert(AlertType.ERROR);
		     	     		alert.setTitle("Error");
		     	     		alert.setHeaderText("Error: Faild to connect to the DB");
		     	     		alert.setContentText("Incorrect password!");
		     	     		alert.showAndWait();
		     	     		SendPasswordButton.setSelected(false);
		 				}//End run
		 			});
		          }//End Catch 
				}//End if
    		else 
    		{
    			try {
    				NoPasswordWarnnig.setVisible(false);
					StartServer.echoserver.close();//closing the server 
					ServerState.setText("OFF");//Set the server button "OFF" 
	    			ServerState.setTextFill(Color.web("LIGHTGRAY"));
				} catch (IOException e) {
					e.printStackTrace();
				}
    	    	
    		}
    }
    
    @FXML
    void setDefaultPassword(ActionEvent event) {
    	if(BraudeDefaultPassword.isSelected()){   //if the user chose the defaulr password of braude 
    		DBPasswordTextField.setText("Aa123456");
    		NoPasswordWarnnig.setVisible(false);   //no "empty password" warning 
        	SendPasswordButton.setDisable(false);  //enable the server status button to work
    	}
    	else {
    		if(DBPasswordTextField.getText().equals("Aa123456")) { //if the user dosen't want the braude default password we set the text field to be empty 
    			DBPasswordTextField.setText("");
    		SendPasswordButton.setDisable(true);}//setting the status button of 
    	}
    }
    
    @FXML
    void EnableServerStatus(ActionEvent event) {
    		if(DBPasswordTextField.getText().isEmpty()) {
    			SendPasswordButton.setDisable(true);
    			NoPasswordWarnnig.setVisible(true);}
    		else {
    			SendPasswordButton.setDisable(false);
    			NoPasswordWarnnig.setVisible(false);
    		}
    		
    }
   

}
