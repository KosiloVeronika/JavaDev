package com.epam.newyeargift.view;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.command.Commands;
import com.epam.newyeargift.controller.Controller;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.logic.LogicException;

public class View {
	private GiftBox gift;
	private final Controller CONTROLLER;
    private final static String FILE_PATH="xml\\GiftXml.xml";
	
	public View(Controller controller) {
		this.CONTROLLER = controller;
	}
	
	public void countWeight() throws EntityException, LogicException {
		Response response = CONTROLLER.processRequest(Commands.COUNT_WEIGHT, 
							new Request(Commands.COUNT_WEIGHT, gift));
		Reporter.report(Commands.COUNT_WEIGHT,response); 
	}
	
	public void createGift() throws EntityException, LogicException {
		Response response = CONTROLLER.processRequest(Commands.CREATE_GIFT, 
													  new Request());
		gift = (GiftBox)response.getData();
		Reporter.report(Commands.CREATE_GIFT, response);	
	}
	
	public void sort() throws EntityException, LogicException {
		Response response = CONTROLLER.processRequest(Commands.SORT_BY_WEIGHT, 
							new Request(Commands.SORT_BY_WEIGHT, gift));
		Reporter.report(Commands.SORT_BY_WEIGHT, response);
	}
	
	public void showAll() throws EntityException, LogicException {
		Response response = CONTROLLER.processRequest(Commands.SHOW_ALL, 
							new Request(Commands.SHOW_ALL, gift));
		Reporter.report(Commands.SHOW_ALL, response);
	}
	public void domParsing() throws EntityException, LogicException {
        Response response = CONTROLLER.processRequest(Commands.DOM, 
        					new Request(Commands.DOM, FILE_PATH));
        gift = (GiftBox)response.getData();
        
        Reporter.report(Commands.DOM, response);
    }
    
    public void saxParsing() throws EntityException, LogicException {
    	Response response = CONTROLLER.processRequest(Commands.SAX, 
				new Request(Commands.SAX, FILE_PATH));
    	gift = (GiftBox)response.getData();

        Reporter.report(Commands.SAX, response);
    }
    
    public void staxParsing() throws EntityException, LogicException {
    	Response response = CONTROLLER.processRequest(Commands.STAX, 
				new Request(Commands.STAX, FILE_PATH));
    	gift = (GiftBox)response.getData();

        Reporter.report(Commands.STAX, response);
    }

	public GiftBox getGift() {
		return gift;
	}

	public void setGift(GiftBox gift) {
		this.gift = gift;
	}
}
