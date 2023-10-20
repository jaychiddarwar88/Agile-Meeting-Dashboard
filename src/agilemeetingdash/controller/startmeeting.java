package agilemeetingdash.controller;

import java.io.IOException;
import java.sql.Connection;
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

@WebServlet("/startmeeting")
public class startmeeting extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		HttpSession session = req.getSession();
		String channelname = (String) session.getAttribute("channelname");
		System.out.println(channelname);
		String useremail = (String) session.getAttribute("email");
		String isadmin = "false";
		try {
			Connection conn = databaseconn.initializeDatabase();
			Statement stmt= conn.createStatement();
			String sql = "SELECT * from channeldetail where channelname = '"  + channelname + "'";
		    ResultSet rs = stmt.executeQuery(sql);

		    while(rs.next()) {
		    		if(rs.getString(2).equals(useremail)) {
		    			isadmin = "true";
		    		}
		    	}
		}	
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now)); 
		//audittrail aud = new audittrail();
		audittrail.auditfunc(channelname, dtf.format(now) , "Started Meeting in channel : " + channelname);
		
		req.setAttribute("useremail", useremail);
		req.setAttribute("isadmin", isadmin);
		req.setAttribute("channelname", channelname);
		req.getRequestDispatcher("html/meetingpage.jsp").forward(req, res);
			
	}
}
