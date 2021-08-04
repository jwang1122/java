package com.huaxia.java2;
/*
 * Create your own FileHandler may cause two log files.
 * Change log level, has to make code change.
 */
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggerExample2 {
	static Logger logger = Logger.getLogger("MyLogger");

	public static Book createBook(String id, String title, Double price) {

		logger.fine("Creating a Book...");

		try {
			Book book = new Book(id, title, price);

			logger.info("{}" + book);

			return book;

		} catch (Exception e) {
			logger.severe(e.toString());
		}

		return null;
	}

	public static void main(String[] args) {
		FileHandler fh;
		// the following block code will add another file handler(it may cause two file handler without your notice.)
		try {
			
			// This block configure the logger with handler and formatter
			fh = new FileHandler("C:/Users/12818/workspace/java/MyLogFile.log");
			LoggerExample2.logger.addHandler(fh);
			XMLFormatter formatter = new XMLFormatter();
			fh.setFormatter(formatter);
			fh.setLevel(Level.INFO);  // I don't like this idea
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Book book = createBook("12345", "Introduction to Python", 12.99);
		System.out.println(book);
		book = createBook("12345", "Introduction to Python", null);
		System.out.println(book);
	}

}
