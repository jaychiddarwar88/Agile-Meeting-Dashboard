package agilemeetingdash.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import agilemeetingdash.dto.audittrail;
import agilemeetingdash.dto.databaseconn;
import agilemeetingdash.dto.getchannelname;
import agilemeetingdash.dto.hikariconn;

@WebServlet("/editnotes")
public class editnotes extends HttpServlet{
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int noteid = Integer.parseInt(req.getParameter("noteid"));
		String newtitle = (String) req.getParameter("newtitle");
		
		HttpSession session = req.getSession();
		//  to be removed
		System.out.println(noteid);
	    System.out.println(newtitle);
	    
	    String sql = "UPDATE capturednotes SET title = '" + newtitle + "'  WHERE noteid = " + noteid ;
	    
	    try {
			Connection conn = databaseconn.initializeDatabase();
//	    	Connection conn  = hikariconn.datasource().getConnection();
			Statement stmt= conn.createStatement();
			//String sql = "SELECT * from capturednotes where channelname = '" + channelname  +"'" ;
			stmt.executeUpdate(sql);
		    
		    }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = res.getWriter();
		out.println("working" );
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now)); 
		//audittrail aud = new audittrail();
		audittrail.auditfunc(getchannelname.getchan(String.valueOf(noteid)) , dtf.format(now) , "Task with id : " +  noteid + " is : edited");
		
		req.getRequestDispatcher("/adminpage").forward(req, res);
		
	}
	

}
