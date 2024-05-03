package com.exception;

public class CourseFoundNotException extends Exception{
	private String message;
	private static final long serialVersionUID = -1512778098554305833L;

	public CourseFoundNotException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
