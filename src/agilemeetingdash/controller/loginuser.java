package agilemeetingdash.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import agilemeetingdash.dto.*;
import agilemeetingdash.models.*;
@WebServlet("/login")
public class loginuser extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		boolean loginres = false;
		String username = "" ;
		HttpSession session = req.getSession();
		ArrayList<String> channellist = new ArrayList<String>();
		try {
			loginres = checkcreden.checkcredential(req.getParameter("email"), req.getParameter("password") );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(loginres) {
			session.setAttribute("email", req.getParameter("email"));
			session.setAttribute("username", username);
			session.setAttribute("exists", "f");
			res.sendRedirect("/agilemeetingdash/");
//			res.sendRedirect("/");
			
		}
		else {
			req.getRequestDispatcher("html/index.jsp").forward(req, res);
		}
		
	}

}
