package com.reimbursement.model;

public class ReimbursementStatus {
	private int statusID;
	private String status;
	
	public ReimbursementStatus() {
		
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [statusID=" + statusID + ", status=" + status + "]";
	}
	
	
}
