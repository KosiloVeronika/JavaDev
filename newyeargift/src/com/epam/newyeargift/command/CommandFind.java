package com.epam.newyeargift.command;

import java.util.List;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.entity.Candy;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.logic.Logic;

public class CommandFind implements Command {

	@Override
	public Response processRequest(Request request)  {
		Response response = new Response();
		List<Candy> list = Logic.findCandy((GiftBox)request.getValue(), request.getMinValue(),
												request.getMaxValue());
		response.setData(list);
		return response;
	}

}
