package agilemeetingdash.dto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONObject;

public class surveyinsertor {	
	public static boolean hasrecord(String email) {
		boolean record = false;
		try {
			Connection conn = databaseconn.initializeDatabase();
			Statement stmt= conn.createStatement();
		    String sqlst = "select * from survey_table where useremail = '"  + email + "'" ;
		    ResultSet rs = stmt.executeQuery(sqlst);
		    if(rs.next()) {
		    	record = true;	    	
		    }
		    else {
		    	record = false;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			status = "error, check in log";
		}
		return record;
	}
	public static boolean hastaken(String email) {
		boolean taken = false;
		try {
			String ans = "no";
			Connection conn = databaseconn.initializeDatabase();
			Statement stmt= conn.createStatement();
		    String sqlst = "select * from survey_table where useremail = '"  + email + "'" ;
		    ResultSet rs = stmt.executeQuery(sqlst);
		    if(rs.next()) {
		    	ans = rs.getString(2);
		    }
		    if(ans.equals("yes")) {
		    	taken = true;
		    }
		    else {
		    	taken = false;
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			status = "error, check in log";
		}
		return taken;
	}
	public static void insertemailbegin(String email) {
		try {
			Connection conn = databaseconn.initializeDatabase();
		    String sqlst = "insert into survey_table values(?, ?)" ;	
		    PreparedStatement st = conn.prepareStatement(sqlst); 
			st.setString(1, email);
			st.setString(2,  "no");
			st.executeUpdate(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			status = "error, check in log";
		}
	}
}