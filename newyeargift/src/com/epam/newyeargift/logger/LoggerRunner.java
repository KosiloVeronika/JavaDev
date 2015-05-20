package com.epam.newyeargift.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerRunner {
	private static final Logger LOG = Logger.getLogger(LoggerRunner.class);
	static {
		new DOMConfigurator().doConfigure("config/log4j.xml",LogManager.getLoggerRepository());
	}

	private static void writeLog(String message) {
		LOG.error(message);
	}
}
