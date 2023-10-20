package agilemeetingdash.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agilemeetingdash.dto.audittrail;

@WebServlet("/audittrail")
public class getaudittrail extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String channelname = req.getParameter("channelname");
		
		ArrayList<String> auditlist = audittrail.getAudit(channelname);
		
		req.setAttribute("auditlist", auditlist);
		req.getRequestDispatcher("html/audittrail.jsp").forward(req, res);
	}
}
