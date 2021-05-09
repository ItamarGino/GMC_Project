package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimeZone;

import client.controllers.ClientMessages;
import common.controllers.Message;
import common.controllers.OperationType;
import common.controllers.ReturnMsgType;
import javafx.scene.control.Alert.AlertType;


public class mysqlConnection {

	Connection conn;
	public void openConnection(String Password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        	conn = DriverManager.getConnection("jdbc:mysql://localhost/gcm?serverTimezone=IST","root",Password);
        	ClientMessages.popUp(AlertType.INFORMATION,"SQL CONNECTION", "SQL connection succeeded", ""); 
   	}
	
	
	public ResultSet getQuery (String query) {
	
		ResultSet rs=null;
		try {
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public Message insertOrUpdate (String query) {
		
		try {
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			return new Message(OperationType.SignUp,ReturnMsgType.usernameExist,"USERNAME IS ALREADY EXIST!");
		}
		String[] arr=query.split("'");
		return new Message(OperationType.SignUp,ReturnMsgType.successfully,arr[1]);
	}
		
	
	
}


