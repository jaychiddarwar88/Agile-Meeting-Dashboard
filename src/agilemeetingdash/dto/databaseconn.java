package agilemeetingdash.dto;

import java.sql.Connection; 

import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class databaseconn { 
	public static int counter = 0;
	public static int created = 0;
	public static Connection conn;
    public static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
    	

    	
    	if(created == 0 ) {
    		
	        // mysql from here
    		String dbDriver = "com.mysql.jdbc.Driver"; 
            String dbURL = "jdbc:mysql://localhost:3306/"; 
            // Database name to access 
            String dbName = "agilemeeting?serverTimezone=UTC"; 
            String dbUsername = "root"; 
            String dbPassword = "root"; 

            Class.forName(dbDriver); 
            Connection con = DriverManager.getConnection(dbURL + dbName, 
                                                         dbUsername,  
                                                         dbPassword); 
            // mysql end here
            
            
            System.out.println("total connection request" + ++counter);
            conn = con;
            created += 1;
            return con; 
    	}
    	else {
    		return conn;
    	}
		//return conn;
        
    } 
} 