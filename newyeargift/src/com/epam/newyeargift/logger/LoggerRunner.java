package com.epam.newyeargift.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerRunner {
	static {
		new DOMConfigurator().doConfigure("config/log4j.xml",LogManager.getLoggerRepository());
	}
}
