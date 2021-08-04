package com.huaxia.java2;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerExample4 {
	static {
//		System.setProperty("java.util.logging.config.file", "/Users/12818/workspace/java/huaxia/conf/logging.properties");		

		String path = LoggerExample4.class.getClassLoader().getResource("logging.properties").getFile();
		System.setProperty("java.util.logging.config.file", path);		

//		InputStream stream = LoggerExample4.class.getClassLoader().getResourceAsStream("logging.properties");
//		try {
//			LogManager manager = LogManager.getLogManager();
//			manager.readConfiguration(stream);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	static Logger logger = Logger.getLogger("WANG");

//	static {
//		InputStream stream = LoggerExample4.class.getClassLoader().getResourceAsStream("logging.properties");
//		try {
//			LogManager manager = LogManager.getLogManager();
//			manager.readConfiguration(stream);
//			logger = Logger.getLogger(LoggerExample4.class.getName());
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		System.out.println("-- main method starts --");
		logger.fine("this is fine message");
		logger.info("this is info message in MyClass");
		logger.warning("a test warning");
		logger.severe("this is a severe message");
	}
}