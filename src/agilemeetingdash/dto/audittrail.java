package agilemeetingdash.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

//import javax.servlet.annotation.WebServlet;
//
//@WebServlet
public class audittrail {
	
	public static String auditfunc(String channelname, String time, String task) {
		String status = "done";
		try {
			Connection conn = databaseconn.initializeDatabase();
			Statement stmt= conn.createStatement();
		    
			PreparedStatement st = conn.prepareStatement("insert into auditfunc values(?, ?, ?)"); 
			st.setString(1, channelname);
			st.setString(2,  time);
			st.setString(3,  task);
			st.executeUpdate(); 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "error, check in log";
		}
		
		
		return status ;
	}
	
	public static ArrayList<String> getAudit(String channelname) {
		
		JSONObject json = new JSONObject();
		ArrayList<String> auditlist = new ArrayList<String>();
		
		try {
			Connection conn = databaseconn.initializeDatabase();

		    Statement stmt1= conn.createStatement();
			String sql1 = "SELECT * from auditfunc where channelname = '"  +channelname + "'";
		    ResultSet rs1 = stmt1.executeQuery(sql1);

		    while(rs1.next()) {
		    		json.put("channelname", rs1.getString(1));
		    		json.put("time", rs1.getString(2));
		    		json.put("remark", rs1.getString(3));
		    		
		    		auditlist.add(json.toString());
		    	}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return auditlist;
	}
}
