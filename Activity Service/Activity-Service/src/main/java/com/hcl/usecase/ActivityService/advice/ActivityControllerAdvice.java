package com.hcl.usecase.ActivityService.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.usecase.ActivityService.exception.ErrorHandler;
import com.hcl.usecase.ActivityService.exception.NoActivitiesFound;
import com.hcl.usecase.EmployeeService.exception.EmployeeExistsException;

@ControllerAdvice
public class ActivityControllerAdvice {
	
	
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
	
	@ExceptionHandler(NoActivitiesFound.class)
	public ResponseEntity<ErrorHandler> handleNoActivities(NoActivitiesFound ex){
		return new ResponseEntity<ErrorHandler>( new ErrorHandler(ex.getError(), ex.getMessage()), HttpStatus.NOT_FOUND);
	}
			
}
