package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TestConnection {
	
	static Connection connection;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		connection = DBConnection.connect();
		

		

	}

}
