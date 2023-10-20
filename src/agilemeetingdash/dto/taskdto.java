package agilemeetingdash.dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import agilemeetingdash.models.taskobj;

public class taskdto {
	public static taskobj gettasklist(String email) throws SQLException, JSONException, ClassNotFoundException {
		
		taskobj obj1 = new taskobj();
		JSONObject json = new JSONObject();
		Set<String> uniqtaskid  = new HashSet<String>(); 
		ArrayList<String> tasklist = new ArrayList<String>();
		
		Connection conn = databaseconn.initializeDatabase();
	    Statement stmt1= conn.createStatement();
		String sql1 = "SELECT * from assignedtask where memberemail = '"  + email+ "'";
	    ResultSet rs1 = stmt1.executeQuery(sql1);

	    while(rs1.next()) {
	    		json.put("taskid", rs1.getString(3));
	    		json.put("channelname", rs1.getString(1));
	    		json.put("duedate", rs1.getString(4));
	    		json.put("status", rs1.getString(5));
	    		uniqtaskid.add(rs1.getString(3));
	    		tasklist.add(json.toString());
	    	}
	    String sqlnote = "";
	    boolean havenotes = false;
	    Iterator<String> itr= uniqtaskid.iterator();  
	    if(itr.hasNext()) {
	    	sqlnote = itr.next();
	    	havenotes = true;
	    }
	    while(itr.hasNext()){  
	    	sqlnote =sqlnote + " OR noteid = " + itr.next();
	    }  
	    obj1.setTasklist(tasklist);
	    obj1.setHasnotes(havenotes);
	    obj1.setSqlnote(sqlnote);
	    
	    return obj1;
	}
	
	public static ArrayList<String> getnotelist(String sqlnote) throws SQLException, JSONException, ClassNotFoundException  {
		JSONObject jsonnotes = new JSONObject();
		ArrayList<String> noteslist = new ArrayList<String>();
		
		Connection conn = databaseconn.initializeDatabase();
		Statement stmt2= conn.createStatement();
		String sql2 =  "SELECT * from capturednotes where noteid = " + sqlnote ;
		System.out.println(sql2);
	    ResultSet rs2 = stmt2.executeQuery(sql2);

	    while(rs2.next()) {
	    	jsonnotes.put("noteid", rs2.getString(1));
	    	jsonnotes.put("channelname", rs2.getString(2));
	    	jsonnotes.put("title", rs2.getString(3));
	    	jsonnotes.put("adminemail", rs2.getString(4));
	    	jsonnotes.put("datetime", rs2.getString(5));
	    	jsonnotes.put("msgvalue", rs2.getString(6));
	    	
	    	
	    	noteslist.add((String)jsonnotes.toString());
	    	}
		
		
		
		return noteslist;
		
	}
	
}
