package com.epam.newyeargift.command;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.dao.Creator;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.entity.GiftBox;

public class CommandCreator implements Command {

	@Override
	public Response processRequest(Request request) {
		Response response = new Response();
		try {
			GiftBox gift = Creator.createGift();
			response.setData(gift);
		} catch (EntityException e) {
			//
		}
		return response;
	}

}
