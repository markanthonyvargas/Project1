package com.reimbursement.service;

import java.util.List;

import com.reimbursement.dao.ReimbDao;
import com.reimbursement.dao.ReimbDaoImpl;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;

public class ReimbServImpl implements ReimbServ{

	private ReimbDao dao = new ReimbDaoImpl();
	
	@Override
	public List<User> selectAllUsers() {
		return dao.selectAllUsers();
	}
	
	@Override
	public User verifyLoginCredentials(String u, String p) {
		return dao.selectUser(u, p);
	}
	
	@Override
	public List<Reimbursement> selectReimbsByUser(int id) {
		return dao.selectReimbByUser(id);
	}
	
	@Override
	public boolean insertReimbursement(Reimbursement r) {
		return dao.insertReimbursement(r);
	}
	
	@Override
	public List<Reimbursement> selectAllReimbs() {
		return dao.selectAllReimbs();
	}
	
	@Override
	public boolean updateStatus(int reimbID, int statusID, int roleID) {
		return dao.updateStatus(reimbID, statusID, roleID);
	}
	
}
