package com.huaxia.java1;

import java.util.logging.Logger;

public class LoggerExample3 {

	static {
		System.setProperty("java.util.logging.config.file", "/Users/12818/workspace/java/huaxia/conf/logging.properties");
	}
	public static Logger logger = Logger.getLogger("JOHN");
	public static void main(String[] args) {
		logger.fine("this is a fine message.");
		logger.info("this is a info message."); // default logging level is INFO
		logger.warning("this is a warning message.");
		logger.severe("this is a severe message.");
	}

}
