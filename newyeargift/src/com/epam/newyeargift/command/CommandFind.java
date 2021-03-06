package com.epam.newyeargift.command;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.entity.Candy;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.logic.Logic;
import com.epam.newyeargift.logic.LogicException;
import com.epam.newyeargift.view.Reporter;

public class CommandFind implements Command {

	private final static Logger LOG = Logger.getLogger(Reporter.class);
	
	@Override
	public Response processRequest(Request request) {
		Response response = new Response();
		try {
			List<Candy> list = Logic.findCandy((GiftBox)request.getValue(), request.getMinValue(),
													request.getMaxValue());
			response.setData(list);
		} catch (LogicException e) {
			LOG.error(e);
		}
		return response;
	}

}
