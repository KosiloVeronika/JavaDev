package com.epam.parcerapp.logic;

public class LogicException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogicException() {
		super();
	}

	public LogicException(String message, Throwable error) {
		super(message, error);
	}

	public LogicException(String message) {
		super(message);
	}

	public LogicException(Throwable error) {
		super(error);
	}

}
