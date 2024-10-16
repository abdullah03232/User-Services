package com.learn.micro.entities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learn.micro.entities.apiresponse.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourseNotFound.class)
	ResponseEntity<APIResponse> resourseNotFound(ResourseNotFound exception){
	String message = exception.getMessage();
	System.out.println("message-------  "+message);
	APIResponse response = APIResponse.builder().message(message).success(false).httpStatus(HttpStatus.NOT_FOUND).build();
	System.out.println(response.toString());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		
	}
	
}
