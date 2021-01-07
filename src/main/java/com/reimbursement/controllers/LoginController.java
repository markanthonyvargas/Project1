package com.reimbursement.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.model.User;
import com.reimbursement.service.ReimbServ;
import com.reimbursement.service.ReimbServImpl;

public class LoginController {
	public static User u;
	
	public static String login(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException,
	IOException{
		u = null;
		if(!request.getMethod().contentEquals("POST")) {
			return "/index.html";
		}
		
		//extracting the form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Dao/Service layer variables
		ReimbServ service = new ReimbServImpl();
		u = service.verifyLoginCredentials(username, password);
		
		//check to see if the user has the correct username and password
		if(u == null) {
			return "/api/forwarding/incorrectcredentials";
		} else {
			//you probably will have a user object that you put into the session
			//that contains the username & password...this is just an example
			request.getSession().setAttribute("loggedusername", u.getUsername());
			request.getSession().setAttribute("loggedpassword", u.getPassword());
			request.getSession().setAttribute("user", u);
			request.getSession().setAttribute("userID", u.getUserID());
			request.getSession().setAttribute("userRoleID", u.getRoleID());
			
			return "/api/forwarding/home";
			
		}
	}
}
