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
    		
//    		// postgre from here
//    		String dbDriver = "org.postgresql.Driver"; 
//	        String dbURL = "jdbc:postgresql://ec2-54-246-85-151.eu-west-1.compute.amazonaws.com:5432/d1u6s4u371k8e3"; 
//	          // Database name to access 
//	        String dbName = "agilemeeting?serverTimezone=UTC"; 
//	        String dbUsername = "gkgiokyhmaxznd"; 
//	        String dbPassword = "ff8ff1a1bfbe7b5ed5ec67483250fc66fd0b41cf6e500b545b6b73108ee3d5bc"; 
//	  
//	        Class.forName(dbDriver); 
//	        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword ); 
////	        end here
    		
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