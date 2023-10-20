package agilemeetingdash.controller;

import agilemeetingdash.dto.*;
import agilemeetingdash.models.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;




@WebServlet("/")
public class loginpage extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)  throws IOException, ServletException{
		
//		res.sendRedirect("index.html");
		HttpSession session = req.getSession();
		ArrayList<String> channellist = new ArrayList<String>();
		String haschannel = "no" ;
		ArrayList<String> noteslist = new ArrayList<String>();
		ArrayList<String> tasklist = new ArrayList<String>();
		Boolean hasrecord = false;
		if(session.getAttribute("email") == null) {
			req.getRequestDispatcher("html/index.jsp").forward(req, res);
		}
		else {
			long startTime = System.nanoTime();
			
			try {
				channellist = checkcreden.getchannellist( (String)session.getAttribute("email") );
				if(channellist.size() > 0) {
					haschannel = "yes" ;
				}
				hasrecord = surveyinsertor.hasrecord( (String)session.getAttribute("email") );
				if(!hasrecord) {
					surveyinsertor.insertemailbegin((String)session.getAttribute("email"));
				}
				
				
				req.setAttribute("takensurvey", surveyinsertor.hastaken( (String)session.getAttribute("email") ));
				
				req.setAttribute("haschannel", haschannel);
			    req.setAttribute("channellist", channellist);
			    
			    taskobj obj = taskdto.gettasklist((String)session.getAttribute("email") );
			    tasklist = obj.getTasklist();
			    String sqlnote = obj.getSqlnote();
			    boolean havenotes = obj.isHasnotes();
			    if(havenotes) {
			    	noteslist = taskdto.getnotelist(sqlnote);
			    }

			    }
			catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("tasklist", tasklist);
				req.setAttribute("noteslist", noteslist);
				session.setAttribute("exists", "true");
				long elapsedTime = System.nanoTime() - startTime;
			     
		        System.out.println("Total time to execute above code is (in millis) : "+ elapsedTime/1000000);
				req.getRequestDispatcher("html/dash.jsp").forward(req, res);
		}
		
	}
}
