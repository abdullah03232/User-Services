package com.learn.micro.exception;

public class ResourseNotFound extends RuntimeException{
	
	public ResourseNotFound() {
		super("Resourse Not Found");
	}
	
	public ResourseNotFound(String message) {
		super(message);
	}
}
