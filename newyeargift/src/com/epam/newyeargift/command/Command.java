package com.epam.newyeargift.command;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.logic.LogicException;

public interface Command {
  public Response processRequest(Request request) throws LogicException;
}
