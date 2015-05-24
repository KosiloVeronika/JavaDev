package com.epam.newyeargift.controller;

import com.epam.newyeargift.bean.*;
import com.epam.newyeargift.command.CommandFactory;
import com.epam.newyeargift.command.Commands;

public class Controller {
	
	public Response processRequest(Commands requestType, Request request) {
        return  CommandFactory.getCommand(requestType).processRequest(request);
    }

}
