package com.reimbursement.model;

public class UserRole {
	private int roleID;
	private String role;

	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", role=" + role + "]";
	}
	
	
}