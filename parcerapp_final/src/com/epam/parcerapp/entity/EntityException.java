package com.epam.parcerapp.entity;

public class EntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityException() {
	}

	public EntityException(String message) {
		super(message);
	}

	public EntityException(Throwable error) {
		super(error);
	}

	public EntityException(String message, Throwable error) {
		super(message, error);
	}
}
