package com.epam.newyeargift.command;

import org.apache.log4j.Logger;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.logic.Logic;
import com.epam.newyeargift.logic.LogicException;
import com.epam.newyeargift.view.Reporter;

public class CommandCountWeight implements Command{
	
	private final static Logger LOG = Logger.getLogger(Reporter.class);

	@Override
	public Response processRequest(Request request) {
		Response response = new Response();
		try {
			int weight = Logic.countWeight((GiftBox)request.getValue());
			response.setData(weight);
		} catch (LogicException e) {
			LOG.error(e);
		}
		return response;
	}



}
