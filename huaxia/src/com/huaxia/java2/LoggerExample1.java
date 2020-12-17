package com.huaxia.java2;
/*
 * Use  C:\Program Files\Java\jdk-14.0.2\conf\logging.properties
 */
import java.util.logging.Logger;

public class LoggerExample1 {
	private static Logger LOGGER = Logger.getLogger(LoggerExample1.class.getName());

	public static void main(String[] args) {
		System.out.println("-- main method starts --");
		LOGGER.fine("a fine msg");
		LOGGER.info("an info msg");
		LOGGER.warning("a warning msg");
		LOGGER.severe("a severe msg");
	}
}
