package com.hcl.usecase.EmployeeService.exception;

import org.springframework.stereotype.Component;


public class EmployeeExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String error;
	private String message;
	
	
	public EmployeeExistsException(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	
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
	
	
}
