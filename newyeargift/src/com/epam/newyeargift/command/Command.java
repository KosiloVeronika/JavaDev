package com.epam.newyeargift.command;

import com.epam.newyeargift.bean.Request;
import com.epam.newyeargift.bean.Response;

public interface Command {
  public Response processRequest(Request request);
}
