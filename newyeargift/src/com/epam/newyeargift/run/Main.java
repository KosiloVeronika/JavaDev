package com.epam.newyeargift.run;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

import com.epam.newyeargift.controller.Controller;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.logic.LogicException;
import com.epam.newyeargift.view.View;

public class Main {
	
    static {
		new DOMConfigurator().doConfigure("config/log4j.xml",LogManager.getLoggerRepository());
	}

	public static void main(String[] args) throws EntityException, LogicException {
		View view = new View(new Controller());
		//view.domParsing(); 
		view.staxParsing();
		//view.saxParsing();
		view.countWeight();
		view.sort();
		view.showAll();
		
	}

}
 