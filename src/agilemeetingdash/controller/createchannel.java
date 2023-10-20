package agilemeetingdash.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import agilemeetingdash.dto.audittrail;
import agilemeetingdash.dto.channelcreate;

@WebServlet("/createchannel")
public class createchannel extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String channelname = req.getParameter("channelname");
		boolean exists = true;
		HttpSession session = req.getSession();
		try {
			exists = channelcreate.checkchan(channelname);
		    
		    if(exists) {
		    	
		    	session.setAttribute("exists", "true");
		    	
		    	req.getRequestDispatcher("/").forward(req, res);
		    	
		    }else {
		    	exists = channelcreate.chandetail(channelname, (String)session.getAttribute("email"));
				
				session.setAttribute("exists", "false");
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
//				System.out.println(dtf.format(now)); 
				//audittrail aud = new audittrail();
				audittrail.auditfunc(channelname, dtf.format(now) , "New Channel is created : " + channelname);
				
				
				req.getRequestDispatcher("/").forward(req, res);
		    }
		    
		    
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
