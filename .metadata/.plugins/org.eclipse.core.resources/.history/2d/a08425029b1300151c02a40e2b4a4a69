package com.epam.newyeargift.command;

import org.apache.log4j.Logger;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.dao.Creator;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.view.Reporter;

public class CommandCreator implements Command {
	
	private final static Logger LOG = Logger.getLogger(Reporter.class);
	
	@Override
	public Response processRequest(Request request) {
		Response response = new Response();
		try {
			GiftBox gift = Creator.createGift();
			response.setData(gift);
		} catch (EntityException e) {
			LOG.error(e);
		}
		return response;
	}

}
