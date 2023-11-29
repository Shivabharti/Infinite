package com.java.employ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionHelper {

	

		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			ResourceBundle rb= ResourceBundle.getBundle("db");
			String driver= rb.getString("driver");
			String url= rb.getString("url");
			String user= rb.getString("user");
			String pwd= rb.getString("password");
			
			Connection connection= null;
			Class.forName(driver);
			connection= DriverManager.getConnection(url, user, pwd);
			return connection;
			
		}
}
