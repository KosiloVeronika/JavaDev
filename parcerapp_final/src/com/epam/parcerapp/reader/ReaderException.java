package com.epam.parcerapp.reader;

public class ReaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReaderException() {
		super();
	}

	public ReaderException(String message, Throwable error) {
		super(message, error);
	}

	public ReaderException(String message) {
		super(message);
	}

	public ReaderException(Throwable error) {
		super(error);
	}

}
