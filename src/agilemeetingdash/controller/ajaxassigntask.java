package agilemeetingdash.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.sendgrid.*;

import agilemeetingdash.emailhandler.emailhandler;
import agilemeetingdash.dto.audittrail;
import agilemeetingdash.dto.databaseconn;
import agilemeetingdash.dto.hikariconn;


@WebServlet("/assigntask")
public class ajaxassigntask extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		String taskid = req.getParameter("noteid");
		String channelname = req.getParameter("channelname");
		String newdate = req.getParameter("newdate");
		String memberemail = req.getParameter("memberemail");
		
//		System.out.println(taskid);
//		System.out.println(channelname);
//		System.out.println(newdate);
//		System.out.println(memberemail);
		PrintWriter out = res.getWriter();
		
		try {
			Connection conn = databaseconn.initializeDatabase();
//			Connection conn  = hikariconn.datasource().getConnection();
			Statement stmt= conn.createStatement();
			
			PreparedStatement st = conn.prepareStatement("insert into assignedtask values(?, ?, ?, ?, ?)"); 
			st.setString(1, channelname );
			st.setString(2, memberemail);
			st.setString(3, taskid);
			st.setString(4, newdate);
			st.setString(5, "pending");
			st.executeUpdate(); 
			
			out.println("assigned to : " + memberemail);
			emailhandler.sendmail(memberemail );
			System.out.println("email sent");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
//		System.out.println(dtf.format(now)); 
		//audittrail aud = new audittrail();
		audittrail.auditfunc(channelname, dtf.format(now) , "New Task is assigned to : " + memberemail);
		

	}
}