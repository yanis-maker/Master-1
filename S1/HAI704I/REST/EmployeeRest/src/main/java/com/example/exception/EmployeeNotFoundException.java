package com.example.exception;

public class EmployeeNotFoundException extends EmployeeException{
	
	public EmployeeNotFoundException() {
		
	}
	
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	
	
}
