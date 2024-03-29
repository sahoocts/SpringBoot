package com.saroj.webservice.restwebservice.exception;

import java.sql.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.saroj.webservice.restwebservice.user.UserNotFoundException;


@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> 
	handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse=
				new ExceptionResponse(new Date(0), ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(0), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(0), "VALIDATION FAILED",
				ex.getBindingResult().toString());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		
		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	

}
