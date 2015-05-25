package com.epam.newyeargift.command;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.logic.Logic;

public class CommandSortByWeight implements Command {

	@Override
	public Response processRequest(Request request) {
		Response response = new Response();
		boolean sorted = Logic.sortByWeight((GiftBox)request.getValue());
		response.setData(sorted);
		return response;
	}

}
