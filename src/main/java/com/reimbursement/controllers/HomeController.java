package com.reimbursement.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class HomeController {
	public static String home(HttpServletRequest request) {
		//request.getSession().setAttribute("userRoleID", u.getRoleID());
		int roleID = (int)request.getSession().getAttribute("userRoleID");
		
		
		//if(LoginController.u.getRoleID() == 2) 
		if(roleID == 2)
			return "/resources/html/employeeHome.html";
		else if(roleID == 1)
			return "/resources/html/adminHome.html";
		else
			return "/resources/html/badlogin.html";
	}
}
