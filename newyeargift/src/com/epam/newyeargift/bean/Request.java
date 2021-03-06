package com.epam.newyeargift.bean;

import com.epam.newyeargift.command.Commands;

public class Request {
	
    private Commands command;
    private Object value;
    private int minValue;
    private int maxValue;
    
	public Request() { }
	
	public Request(Commands command, Object value, int minValue, int maxValue) {
		this.command = command;
		this.value = value;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public Request(Commands command, Object value) {
		this.command = command;
		this.value = value;
	}

	public Commands getCommand() {
		return command;
	}

	public void setCommand(Commands command) {
		this.command = command;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
}
