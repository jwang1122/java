package com.huaxia.java1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample2 {
	static Logger logger = Logger.getLogger("JWang");

	public static void main(String[] args) {
		try {
			FileHandler fh = new FileHandler("/Users/12818/workspace/java0/john/mylog.log");
			fh.setLevel(Level.FINE);
			logger.addHandler(fh);
			logger.fine("this is a fine message.");
			logger.info("this is a info message."); // default logging level is INFO
			logger.warning("this is a warning message.");
			logger.severe("this is a severe message.");
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
