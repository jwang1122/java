package com.huaxia.java1;

/*
 * The logging.properties file is located at
 * C:\Program Files\Java\jdk-14.0.2\conf\logging.properties
 * 
 */
import java.util.logging.*;

public class LoggingTest {

	public static void main(String[] args) {
		LoggingTest test = new LoggingTest();
		test.logErrorTest();

	}

	private void logErrorTest() {
		Logger logger = Logger.getLogger("WANG");
//		logger.setLevel(Level.WARNING);
//		Handler consoleHandler = new ConsoleHandler(); // duplicated Console handler
//		consoleHandler.setLevel(Level.FINE);
//		logger.addHandler(consoleHandler);
//		logger.setLevel(Level.FINE); // no effects
		logger.info("logErrorTest()... logger.info()");
		logger.warning("logErrorTest()... logger.warning()");
		logger.log(Level.FINE, "logErrorTest()... logger.fine()");
		logger.severe("logErrorTest()... logger.severe()");
	}

}
