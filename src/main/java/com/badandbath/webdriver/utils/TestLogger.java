package com.badandbath.webdriver.utils;

import org.apache.log4j.Logger;

public class TestLogger {

	private final Logger logger;

	public static TestLogger getLogger(Class clazz) {
		return new TestLogger(clazz);
	}

	public TestLogger(Class clazz) {
		this.logger = Logger.getLogger(clazz);
	}
	
	public void logInfo(String message) {
		logger.info(message);
	}
	
	public void logFatal(String message) {
		logger.fatal(message);
		
	}
	
	public void logDebug(String message) {
		logger.debug(message);
	}
	
	public void logError(String message) {
		logger.error(message);
	}
	
	public void logWarn(String message) {
		logger.warn(message);
	}

}
