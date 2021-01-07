package com.reimbursement.model;

public class Reimbursement {
	private int reimbID;
	private double amount;
	private String submitDate;
	private String resolveDate;
	private String description;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public Reimbursement(int reimbID, double amount, String submitDate, String resolveDate, String description, 
			int author, int resolver, int statusID, int typeID) 
	{
		this.reimbID = reimbID;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}
	
	public Reimbursement(double amount, String description, 
			int author, int statusID, int typeID) 
	{
		this.amount = amount;
		this.description = description;
		this.author = author;
		this.statusID = statusID;
		this.typeID = typeID;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", amount=" + amount + ", submitDate=" + submitDate
				+ ", resolveDate=" + resolveDate + ", description=" + description + ", author=" + author + ", resolver="
				+ resolver + ", statusID=" + statusID + ", typeID=" + typeID + "]";
	}

}
