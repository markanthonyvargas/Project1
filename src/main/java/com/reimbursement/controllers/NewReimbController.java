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

public class NewReimbController {
	final static Logger loggy = Logger.getLogger(NewReimbController.class);
	
	public static ReimbServ myServ= new ReimbServImpl();
	
	public static String newReimb(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */
		
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		String  sType = request.getParameter("types");
		int type;
		int authorID = (int)request.getSession().getAttribute("userID");
		
		switch(sType) {
			case "lodging":
				type = 1;
				break;
			case "travel":
				type = 2;
				break;
			case "food":
				type = 3;
				break;
			case "other":
			default:
				type = 4;
				break;
		}
		
		Reimbursement r = new Reimbursement(amount, description, authorID, 1, type);
		myServ.insertReimbursement(r);
		

		List<Reimbursement> myReimbList = myServ.selectReimbsByUser((int)request.getSession().getAttribute("userID"));

		response.getWriter().write(new ObjectMapper().writeValueAsString(myReimbList));
		
		loggy.trace("New reimb created for " + request.getSession().getAttribute("user"));
		
		return "/api/forwarding/home";
	}
}
