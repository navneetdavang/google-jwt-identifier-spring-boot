package com.gti.app.security.exception;

public class InvalidTokenException extends Throwable{
	
	private static final long serialVersionUID = 8355809390943629313L;

	public InvalidTokenException(String message) {
		super(message);
	}

}
