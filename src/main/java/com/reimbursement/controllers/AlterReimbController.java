package com.reimbursement.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.dao.ReimbDaoImpl;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.service.ReimbServ;
import com.reimbursement.service.ReimbServImpl;

public class AlterReimbController {
	
	final static Logger loggy = Logger.getLogger(AlterReimbController.class);
	
	public static String alterReimb(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		/*
		 * THIS IS WHERE YOU'D GO TO THE DATABASE TO GET THE OBJECTS TO SEND TO THE CLIENT
		 */
		
		
		ReimbServ myServ = new ReimbServImpl();
		
		int id = Integer.parseInt(request.getParameter("ID"));
		String  sStatus = request.getParameter("status");
		int roleID = (int)request.getSession().getAttribute("userRoleID");
		int status;
		
		switch(sStatus) {
			case "approve":
				status = 2;
				break;
			case "deny":
				status = 3;
				break;
			default:
				status = 1;
				break;
		}
		
		myServ.updateStatus(id, status, roleID);
		

		List<Reimbursement> myReimbList = myServ.selectReimbsByUser((int)request.getSession().getAttribute("userID"));

		response.getWriter().write(new ObjectMapper().writeValueAsString(myReimbList));
		
		loggy.trace("Reimbursement " + id + " was updated successfully");
		
		return "/api/forwarding/home";
	}
}
