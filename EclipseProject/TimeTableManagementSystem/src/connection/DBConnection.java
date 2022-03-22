package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	//creating database connectionS
	public static Connection connect() {
		
			Connection conn = null;
			
			try {
				 String url = "jdbc:sqlite:C:\\Users\\ASUS\\Desktop\\Timetable.db";  
				 
				 String urls = "jdbc:sqlite:C:\\Users\\ASUS\\git\\WD_B04_ITP_16\\TimeTableManagementSystem\\Timetable.db";  
				

//				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection(urls);
				System.out.println("Connected");
			}
			catch(Exception e) {
					System.out.println(e);
					System.out.println("Error DATAbase");
					
			}
			
			return conn;
	}
	
	  
}
