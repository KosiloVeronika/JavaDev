package com.epam.newyeargift.dao;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable exeption) {
		super(message, exeption);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable exception) {
		super(exception);
	}

}
