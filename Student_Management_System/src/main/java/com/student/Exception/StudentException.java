package com.student.Exception;

public class StudentException extends RuntimeException {

	public StudentException(String msg) {
		super(msg);
	}

	public StudentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StudentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
