package com.epam.newyeargift.logic;

public class LogicException extends Exception {

	public LogicException() {
		
	}

	public LogicException(String arg0) {
		super(arg0);

	}

	public LogicException(Throwable arg0) {
		super(arg0);

	}

	public LogicException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public LogicException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);

	}

}
