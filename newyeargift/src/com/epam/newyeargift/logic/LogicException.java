package com.epam.newyeargift.logic;

public class LogicException extends Exception {

	public LogicException() {
		
	}

	public LogicException(String message) {
		super(message);

	}

	public LogicException(Throwable error) {
		super(error);

	}

	public LogicException(String message, Throwable error) {
		super(message, error);

	}

	@Override
    public String getMessage(){
        return "Logic error.";
    }

}
