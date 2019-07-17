package com.example.projectv1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.projectv1.entity.Response;



@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler	
	ResponseEntity<Response > handleException (UserNotFoundException exception) {
		Response response = new Response();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(exception.getMessage());
		response.setTime(System.currentTimeMillis());
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
	}
}

