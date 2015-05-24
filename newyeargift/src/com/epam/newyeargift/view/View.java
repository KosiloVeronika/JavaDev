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
		Response response = controller.processRequest(Commands.COUNT_WEIGHT, null);
		Reporter.report(Commands.COUNT_WEIGHT,response); 
	}
	
	public void createGift() {
		Response response = controller.processRequest(Commands.CREATE_GIFT, new Request(Commands.CREATE_GIFT,null));
		Reporter.report(Commands.CREATE_GIFT, response);	
	}
	
	public void sort() {
		Response response = controller.processRequest(Commands.SORT_BY_WEIGHT, null);
		Reporter.report(Commands.SORT_BY_WEIGHT, response);
	}
}
