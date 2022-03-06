package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	public static Connection connect() {
		
			Connection conn = null;
			
			try {
				
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:ITPM.db");
				System.out.println("Connected");
			}
			catch(Exception e) {
					System.out.println(e);
					System.out.println("Error DATAbase");
					
			}
			
			return conn;
	}
}
