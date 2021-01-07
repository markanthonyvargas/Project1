package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reimbursement.controllers.AlterReimbController;
import com.reimbursement.controllers.HomeController;
import com.reimbursement.controllers.LoginController;
import com.reimbursement.controllers.NewReimbController;

public class RequestHelper {
	public static String process(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException,
	IOException{
		System.out.println("\t\tIn RequestHelper");
		System.out.println(request.getRequestURI());
		
		switch(request.getRequestURI()) {
		case "/Project1/api/forwarding/login":
			System.out.println("checkpoint1");
			return LoginController.login(request, response);
		case "/Project1/api/forwarding/home":
			System.out.println("checkpoint 2");
			return HomeController.home(request);
		case "/Project1/api/forwarding/newReimb":
			System.out.println("checkpoint 3");
			return NewReimbController.newReimb(request, response);
		case "/Project1/api/forwarding/alterReimb":
			System.out.println("checkpoint 4");
			return AlterReimbController.alterReimb(request, response);
		case "/Project1/logout":
			System.out.println("checkpoint 5");
			return "/resources/html/logout.html";
		default:
			System.out.println("bad checkpoint");
			return "/resources/html/badlogin.html";
		}
	}
}
