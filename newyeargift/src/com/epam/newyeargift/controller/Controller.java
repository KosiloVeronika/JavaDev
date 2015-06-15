package com.epam.newyeargift.controller;

import com.epam.newyeargift.bean.*;
import com.epam.newyeargift.command.CommandFactory;
import com.epam.newyeargift.command.Commands;
import com.epam.newyeargift.logic.LogicException;

public class Controller {
	
	public Response processRequest(Commands requestType, Request request) throws LogicException {
        return  CommandFactory.getCommand(requestType).processRequest(request);
    }

}
