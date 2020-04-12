package com.rest.demo.commons;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.demo.exception.UserNotFoundException;
@ControllerAdvice
@RestController
public class CustomExceptionEntityHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionGenerator e=new ExceptionGenerator(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), new Date());
				return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionGenerator e=new ExceptionGenerator(ex.getMessage(), HttpStatus.NOT_FOUND.toString(), new Date());
				return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
