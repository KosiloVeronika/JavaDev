package com.epam.newyeargift.bean;

public class Response {
	
	private Object data;

	public Response() {	}

	public Response(Object data) {
		this.setData(data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
