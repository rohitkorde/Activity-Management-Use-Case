package com.hcl.usecase.EmployeeService.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.usecase.EmployeeService.exception.ErrorHandler;
import com.hcl.usecase.EmployeeService.exception.EmployeeExistsException;

@ControllerAdvice
public class EmployeeControllerAdvice {
		
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    
		return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	  }
	
	@ExceptionHandler(EmployeeExistsException.class)
	public ResponseEntity<ErrorHandler> handleEmplyeeExistsException(EmployeeExistsException ex){
		return new ResponseEntity<ErrorHandler>(new ErrorHandler(ex.getError(), ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
	}
}
