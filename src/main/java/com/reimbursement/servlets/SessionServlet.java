package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		System.out.println("In SessionServlet, doGet");
		
//		///GENERAL JAVA CODE
//		SuperVillain dannyboy = 
//				new SuperVillain("Danny Boy", "Technopath", 250_000);
//		
//		//SESSION CODE
//		//this method will get the current session OR create one if there is no current session
//		HttpSession session = req.getSession();
//		//HttpSession session = req.getSession(false); //returns null if no session exists
//		
//		//let's put information inside of the session
//		session.setAttribute("currentVillain", dannyboy);
//		
//		//GENERAL SERVLET CODE
//		PrintWriter printer = res.getWriter();
//		printer.println("Danny Boy is on the loose..........");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In SessionServlet, doPost");
		
//		String name = req.getParameter("myname");
//		String superpower= req.getParameter("mysuperpower");
//		int bounty = Integer.parseInt(req.getParameter("mybounty"));
//		
//		SuperVillain tempVill=
//				new SuperVillain(name, superpower, bounty);
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("currentVillain", tempVill);
//		
//		PrintWriter printer = resp.getWriter();
//		printer.println("The CUSTOM villain "+name+" is on the loose.......");
	}
}
