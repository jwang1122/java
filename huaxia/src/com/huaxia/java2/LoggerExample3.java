package com.huaxia.java2;

/*
 * Use project level logging.properties 1. create logging.properties in ./conf folder 2. set the conf folder in the
 * classpath
 */
import java.util.logging.Logger;

public class LoggerExample3 {
	static {
// 
// use absolute file path
		System.setProperty("java.util.logging.config.file", "C:\\Users\\12818\\workspace\\java\\huaxia\\conf\\logging.properties");

// use classpath (set conf to classpath folder)
//		String path = LoggerExample1.class.getClassLoader().getResource("logging.properties").getFile();
//		System.setProperty("java.util.logging.config.file",path);

//-Djava.util.logging.config.file=C:\Users\12818\workspace\java\huaxia\conf\logging.properties		
	}
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
		Book book = createBook("12345", "Introduction to Python", 12.99);
		System.out.println(book);
		book = createBook("12345", "Introduction to Python", null);
		System.out.println(book);
	}

}
