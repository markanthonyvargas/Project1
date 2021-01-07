package com.reimbursement;

import java.util.List;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;
//import com.reimbursement.model.User;
import com.reimbursement.service.ReimbServ;
import com.reimbursement.service.ReimbServImpl;

public class TestDriver {
	
	public static ReimbServ service = new ReimbServImpl();

	public static void main(String[] args) {
		
		List<User> newU = service.selectAllUsers();
		System.out.println(newU);
	}

}
