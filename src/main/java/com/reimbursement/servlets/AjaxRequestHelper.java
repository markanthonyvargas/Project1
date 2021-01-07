package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimbursement.controllers.ReimbursementController;
import com.reimbursement.controllers.UserController;

public class AjaxRequestHelper {
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getRequestURI());

		switch (request.getRequestURI()) {
		case "/Project1/api/ajax/allUsers":
			UserController.allFinder(request, response);
			break;
		case "/Project1/api/ajax/reimb":
			ReimbursementController.allFinder(request, response);
			break;
		default:

			response.getWriter().println("null");
		}
	}
}
