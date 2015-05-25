package com.epam.newyeargift.view;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.command.Commands;
import com.epam.newyeargift.controller.Controller;

public class View {
	private final Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
	}
	
	public void countWeight() {
		Response response = controller.processRequest(Commands.COUNT_WEIGHT, new Request());
		Reporter.report(Commands.COUNT_WEIGHT,response); 
	}
	
	public void createGift() {
		Response response = controller.processRequest(Commands.ADD_CANDIES, new Request());
		Reporter.report(Commands.ADD_CANDIES, response);	
	}
	
	public void sort() {
		Response response = controller.processRequest(Commands.SORT_BY_WEIGHT, new Request());
		Reporter.report(Commands.SORT_BY_WEIGHT, response);
	}
}