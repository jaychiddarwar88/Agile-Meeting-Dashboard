package agilemeetingdash.dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class getchannelname {
	public static String getchan(String taskid) {
		String channelname = "" ;
		
		try {
			Connection conn = databaseconn.initializeDatabase();
			Statement stmt= conn.createStatement();
			String sql = "SELECT * from capturednotes where noteid = " + taskid ;
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next()) {
		    	channelname =  rs.getString(2);
		    	
		    }
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return channelname;
	}

}
