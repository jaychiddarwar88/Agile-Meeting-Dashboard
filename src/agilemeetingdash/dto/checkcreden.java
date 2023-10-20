package agilemeetingdash.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import agilemeetingdash.models.userdetail;

public class checkcreden {
	public static int createuser(userdetail obj) throws ClassNotFoundException, SQLException {
		userdetail uobj = obj;
		int id = 0;
		Connection conn = databaseconn.initializeDatabase();
		Statement stmt= conn.createStatement();
		String sql = "SELECT MAX(id) from userdetail";
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	id = rs.getInt(1);
	    }
	    
		PreparedStatement st = conn.prepareStatement("insert into userdetail values(?, ?, ?, ?)"); 
		st.setInt(1, id+1);
		st.setString(2,  uobj.getName());
		st.setString(3,  uobj.getEmail());
		st.setString(4,  uobj.getPassword());
		st.executeUpdate(); 
		
		
		return id;
	}
	
	public static boolean checkcredential(String email, String password) throws ClassNotFoundException, SQLException {
		
		boolean loginres = false;
		String username = "" ;
		Connection conn = databaseconn.initializeDatabase();
		Statement stmt= conn.createStatement();
		String sql = "SELECT * from userdetail " ;
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    while(rs.next()) {
	    	if( rs.getString(3).equals(email) && rs.getString(4).equals(password )) {
	    		username = rs.getString(2);
	    		loginres = true;
	    	}
	    	}
	    return loginres;
	}

	public static ArrayList<String> getchannellist( String email) {
		
		ArrayList<String> channellist = new ArrayList<String>();
		try {
			Connection conn = databaseconn.initializeDatabase();
			Statement stmt= conn.createStatement();
			String sql = "SELECT * from channelmember where memberemail = '"  + email + "'";
		    ResultSet rs = stmt.executeQuery(sql);

		    while(rs.next()) {
		    		channellist.add(rs.getString(1));
		    		//haschannel = "yes" ;
		    	}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return channellist;
		
	}
}
