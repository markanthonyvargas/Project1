package com.reimbursement.dao;

import java.util.List;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;

public interface ReimbDao {
	//CREATE
	public boolean insertReimbursement(Reimbursement r);
	//READ
	public List<User> selectAllUsers();
	public List<Reimbursement> selectAllReimbs();
	public User selectUser(String u, String p);
	public List<Reimbursement> selectReimbByUser(int userID);
	//UPDATE
	public boolean updateStatus(int reimbID, int statusID, int roleID);
	//H2
	public void h2InitDao();
	public void h2DestroyDao();
}
