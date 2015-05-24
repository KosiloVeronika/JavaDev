package com.epam.newyeargift;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import com.epam.newyeargift.controller.Controller;
import com.epam.newyeargift.dao.Creator;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.view.View;

public class Main {
	static {
		new DOMConfigurator().doConfigure("config/log4j.xml",LogManager.getLoggerRepository());
	}

	public static void main(String[] args) throws EntityException {
		View view = new View(new Controller());
		view.createGift();
		view.countWeight();
	}

}
