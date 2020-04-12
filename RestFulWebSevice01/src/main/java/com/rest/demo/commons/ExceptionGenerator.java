package com.rest.demo.commons;

import java.util.Date;

public class ExceptionGenerator {
	
	private String message;
	private String details;
	private Date timeStamp;
	public ExceptionGenerator(String message, String details, Date timeStamp) {
		this.message = message;
		this.details = details;
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "ExceptionGenerator [message=" + message + ", details=" + details + ", timeStamp=" + timeStamp + "]";
	}
	

}
