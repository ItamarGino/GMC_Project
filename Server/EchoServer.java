// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package server;
import java.awt.HeadlessException;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;

import common.controllers.*;
import common.ocsf.server.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
	
	public static mysqlConnection mysql=new mysqlConnection();
	public static ArrayList<String> connectedUsers=new ArrayList<>();
	 
  //Class variables *************************************************
	
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }
  

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient (Object msg, ConnectionToClient client)
  {
	  switch(((Message)msg).getOperationtype()) {
	  case Login:
		  ResultSet rs=mysql.getQuery(((Message)msg).getObject().toString());
		  try {
			if(rs.next()) {
				  if(connectedUsers.contains(rs.getString(1))) {
					  sendToClient(new Message(OperationType.Login,ReturnMsgType.userConnected,rs.getString(1)),client); }
				  else {
				  connectedUsers.add(rs.getString(1));
				  System.out.println("loged in!");
				  sendToClient(new Message(OperationType.Login,ReturnMsgType.successfully,rs.getString(1)),client);

				  }
			}
			else {
				String[] str=((Message)msg).getObject().toString().split("'");
				sendToClient(new Message(OperationType.Login,ReturnMsgType.userNotExist,str[1]),client); 
				System.out.println("Not exists");
			break;}
			break;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  case SignUp:
		Message message = mysql.insertOrUpdate(((Message)msg).getObject().toString());
		sendToClient(message, client);
		  break;
	  }
  }

    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
    
    StartServer.echoserver=sv;
    StartServer.LunchServerGui(args);
    
  }
  
  public static void StopServer() {
  }
 
  
}
//End of EchoServer class
