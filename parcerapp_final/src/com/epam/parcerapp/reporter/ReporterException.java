package com.epam.parcerapp.reporter;

public class ReporterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReporterException() {
		super();
	}

	public ReporterException(String message, Throwable error) {
		super(message, error);
	}

	public ReporterException(String message) {
		super(message);
	}

	public ReporterException(Throwable error) {
		super(error);
	}

}
