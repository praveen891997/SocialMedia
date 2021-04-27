package com.cg.socialmedia.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cg.socialmedia.exception.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(ResourceNotFoundException ex){
		
		String error = "No record found";
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),error);
		return  new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), errorMessage.getStatus());
	}
	
	@ExceptionHandler(value = {FriendException.class})
	public ResponseEntity<Object> handleFriendException(FriendException ex, WebRequest webRequest){
		
		ExceptionResponse1 exceptionResponse = new ExceptionResponse1();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(ex.getMessage());

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex){
		
		ExceptionResponse er = new ExceptionResponse();
		er.setErroeCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(er,HttpStatus.OK);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
		
		ExceptionResponse er = new ExceptionResponse();
		er.setErroeCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(er,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
