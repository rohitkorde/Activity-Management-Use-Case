package com.hcl.usecase.ActivityService.exception;

import org.springframework.stereotype.Component;


public class NoActivitiesFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String error;
	private String message;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public NoActivitiesFound(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	
	
	
	
}
