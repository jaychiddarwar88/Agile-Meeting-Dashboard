package agilemeetingdash.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import agilemeetingdash.dto.audittrail;
import agilemeetingdash.dto.databaseconn;
import agilemeetingdash.dto.hikariconn;

@WebServlet("/addmember")
//@WebServlet("/agilemeetingdash/addmember")
public class addmember extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		HttpSession session = req.getSession();
		String email = req.getParameter("memberemail");
		String channelname = (String) session.getAttribute("channelname");
		System.out.println(channelname);
		
		try {
			Connection conn = databaseconn.initializeDatabase();
//			Connection conn  = hikariconn.datasource().getConnection();
			Statement stmt= conn.createStatement();
		    
			PreparedStatement st = conn.prepareStatement("insert into channelmember values(?, ?)"); 
			st.setString(1, channelname);
			st.setString(2,  email);
			st.executeUpdate(); 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now)); 
		//audittrail aud = new audittrail();
		audittrail.auditfunc(channelname, dtf.format(now) , "New Member is added : " + email);
		
		req.getRequestDispatcher("adminpage").forward(req, res);
		
	}

}
