package server;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import server.controllers.ServerController;

public class StartServer extends Application {
	public static EchoServer echoserver;
	
	
	public static void LunchServerGui(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) {
try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/server/boundry/ServerWindow.fxml"));
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Server");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent t) {
			    	try {
						echoserver.close();
						 Platform.exit();
					        System.exit(0);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
