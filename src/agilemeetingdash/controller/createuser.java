package agilemeetingdash.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agilemeetingdash.dto.checkcreden;
import agilemeetingdash.models.userdetail;

@WebServlet("/createuser")
public class createuser extends HttpServlet {
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		userdetail obj = new userdetail();
		obj.setEmail(req.getParameter("email"));
		obj.setPassword(req.getParameter("password"));
		obj.setName(req.getParameter("name"));
		
		try {
			int id = checkcreden.createuser(obj);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		PrintWriter out =res.getWriter();
//		out.println("hello working");
		
		res.sendRedirect("/agilemeetingdash/");
//		res.sendRedirect("/");
	}
}
