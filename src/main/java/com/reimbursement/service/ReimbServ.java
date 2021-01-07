package com.reimbursement.service;

import java.util.List;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;

public interface ReimbServ {
	public List<User> selectAllUsers();
	public User verifyLoginCredentials(String u, String p);
	public List<Reimbursement> selectReimbsByUser(int id);
	public boolean insertReimbursement(Reimbursement r);
	public List<Reimbursement> selectAllReimbs();
	public boolean updateStatus(int reimbID, int statusID, int roleID);
}
