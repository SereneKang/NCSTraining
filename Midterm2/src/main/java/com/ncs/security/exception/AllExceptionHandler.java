package com.ncs.security.exception;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class AllExceptionHandler 
{
	
	
	public AllExceptionHandler() {
		System.out.println("--->> Inside Controller Advice ");
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleNoSuchElementExceptionTemplateData(java.util.NoSuchElementException e)
	{
		System.err.println("--->> Inside Exeption Handler : NoSuchElement ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput("");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleNullPointerExceptionTemplateData(NullPointerException e)
	{
		System.err.println("--->> Inside Exeption Handler : Null Value Entering ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleUserDuplicatedExceptionTemplateData(UserDuplicatedException e)
	{
		System.err.println("--->> Inside Exeption Handler : Duplicated User Data Entering ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleAgeExceptionTemplateData(AgeException e)
	{
		System.err.println("--->> Inside Exeption Handler : Age < then 18 ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handlePinCodeExceptionTemplateData(PincodeException e)
	{
		System.err.println("--->> Inside Exeption Handler : Pin must less than 8 digits ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handlePinCodeNumbericExceptionTemplateData(NumberFormatException e)
	{
		System.err.println("--->> Inside Exeption Handler : Pin must be numeric values");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("");
		template.setUserInput("Pin must be numeric values");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handlePinNumbericExceptionTemplateData(InvalidFormatException e)
	{
		System.err.println("--->> Inside Exeption Handler : Pin must be numeric values");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("");
		template.setUserInput("Pin must be numeric values");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handlePinNumbericLengthExceptionTemplateData(ConstraintViolationException e)
	{
		System.err.println("--->> Inside Exeption Handler : Pin must less than 8 digits ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("");
		template.setUserInput("Pin must less than 8 digits ");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	

}