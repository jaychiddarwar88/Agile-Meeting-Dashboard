package agilemeetingdash.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

public class channelcreate {
	public static boolean checkchan(String channelname) throws ClassNotFoundException, SQLException {
		boolean exists = true;
		
		Connection conn = databaseconn.initializeDatabase();
		Statement stmt= conn.createStatement();
		String sql = "SELECT * from channeldetail where channelname = '" + channelname + "'" ;
	    ResultSet rs = stmt.executeQuery(sql);
	    exists = rs.next();
	    
	    return exists;
	    
	}
	
	public static boolean chandetail(String channelname, String email) throws SQLException, ClassNotFoundException {
		Connection conn = databaseconn.initializeDatabase();
		PreparedStatement st = conn.prepareStatement("insert into channeldetail values(?, ?)"); 
		st.setString(1, channelname);
		st.setString(2,  email);
		st.executeUpdate(); 
		
		PreparedStatement st2 = conn.prepareStatement("insert into channelmember values(?, ? ) " ) ;
		st2.setString(1, channelname);
		st2.setString(2,  email);
		st2.executeUpdate();
	
		return false;
	}
	
	
}
