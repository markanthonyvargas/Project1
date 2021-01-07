package com.reimbursement.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.service.ReimbServ;
import com.reimbursement.service.ReimbServImpl;

public class ReimbursementController {
	final static Logger loggy = Logger.getLogger(ReimbursementController.class);
	
	
	public static void allFinder(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */
		ReimbServ myServ = new ReimbServImpl();
		List<Reimbursement> myReimbList = null;
		
		if(request.getSession().getAttribute("userRoleID").equals(1)) {
			myReimbList = myServ.selectAllReimbs();
		}
		if(request.getSession().getAttribute("userRoleID").equals(2)) {
			myReimbList = myServ.selectReimbsByUser((int)request.getSession().getAttribute("userID"));
		}
		
		

		
		
		//in project 1 you ALREADY HAVE THE USER'S INFORMATION IN YOUR SESSION....NO NEED TO GO TO THE DATABASE
		//HttpSession session = req.getSession(); //extract the username password....then go to the DB using that username to
		//														get the reimbursmenets

		response.getWriter().write(new ObjectMapper().writeValueAsString(myReimbList));
		
		loggy.trace("Appropriate reimbursements selected");
		
		
	}
}
