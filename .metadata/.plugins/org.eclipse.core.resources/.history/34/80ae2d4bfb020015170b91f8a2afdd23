package com.epam.newyeargift.command;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.logic.Logic;

public class CommandCountWeight implements Command{

	@Override
	public Response processRequest(Request request) {
		Response response = new Response();
		int weight = Logic.countWeight((GiftBox)request.getValue());
		response.setData(weight);
		return response;
	}



}
