package agilemeetingdash.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import agilemeetingdash.dto.getchannelname;
import agilemeetingdash.dto.hikariconn;

@WebServlet("/changestatus")
public class changestatus extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String taskid = req.getParameter("taskid");
		String status = (String) req.getParameter("status");
		
		HttpSession session = req.getSession();
//		System.out.println(taskid);
//		System.out.println(status);
		
		String sql = "UPDATE assignedtask SET status = '"+  status + "' WHERE task = '" + taskid + "'" ;
	    
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
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now)); 
		//audittrail aud = new audittrail();
		audittrail.auditfunc( getchannelname.getchan(taskid), dtf.format(now) , "Task with id : " +  taskid + " is : " + status);
	    
		PrintWriter out = res.getWriter();
		out.println("done as " + status);
		
	}

}
