package com.reimbursement.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.model.User;
import com.reimbursement.service.ReimbServ;
import com.reimbursement.service.ReimbServImpl;

public class UserController {
	public static ReimbServ myServ= new ReimbServImpl();

	public static void allFinder(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */


		List<User> myUserList = myServ.selectAllUsers();
		
		//in project 1 you ALREADY HAVE THE USER'S INFORMATION IN YOUR SESSION....NO NEED TO GO TO THE DATABASE
		//HttpSession session = req.getSession(); //extract the username password....then go to the DB using that username to
		//														get the reimbursmenets

		response.getWriter().write(new ObjectMapper().writeValueAsString(myUserList));
		
	}
}
