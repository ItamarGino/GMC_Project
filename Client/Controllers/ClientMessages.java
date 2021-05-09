package client.controllers;

import common.controllers.Message;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ClientMessages {

	
	public static void popUp(AlertType type,String title,String head,String content)
	{
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				Alert alert=new Alert(type);
				alert.setTitle(title);
				alert.setHeaderText(head);
				alert.setContentText(content); 
				alert.showAndWait();
			}
		});
	}

	
	public static void messageFromServer(Object msg) {
		String username=((Message)msg).getObject().toString();
		
		switch(((Message)msg).getOperationtype()) {
		case Login:
			switch(((Message)msg).getReturnmsg()) {
			case successfully:
				popUp(AlertType.CONFIRMATION, "LOGIN", "Loged In","\""+ username +"\" is login now");
				break;
			case userConnected:
				popUp(AlertType.ERROR, "User already connected!", "user is connected!","\""+username+"\" is already connected to the system!");
				break;
			case userNotExist:
				popUp(AlertType.ERROR, "Log in error", " The username : "+ " \"" + username+ "\" or the password are incorrect", "The username or the password incorrect");
				break;
			}
			break;
		case SignUp:
			switch(((Message)msg).getReturnmsg()) {
			case successfully:
				popUp(AlertType.INFORMATION, username+" is sign now !", "THANK YOU !", username+" is sign now !");
				break;
			case usernameExist:
				popUp(AlertType.ERROR, username+ /*"is already in use!"*/ "username", "PAY ATTENTION !", username+ "is already in use!");
				break;
			}
			break;
		}
	}
}
