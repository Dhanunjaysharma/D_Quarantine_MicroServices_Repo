package com.rest.demo.model;

import java.util.Date;

public class User {
	
	private int userId;
	private String uName;
	private Date dob;
	
	
	public User(int userId, String uName, Date dob) {
		super();
		this.userId = userId;
		this.uName = uName;
		this.dob = dob;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", uName=" + uName + ", dob=" + dob + "]";
	}
	

}
