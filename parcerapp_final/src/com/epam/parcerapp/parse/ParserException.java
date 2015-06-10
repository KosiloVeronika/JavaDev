package com.epam.parcerapp.parse;

public class ParserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParserException() {
		super();
	}

	public ParserException(String message, Throwable error) {
		super(message, error);
	}

	public ParserException(String message) {
		super(message);
	}

	public ParserException(Throwable error) {
		super(error);
	}

}
