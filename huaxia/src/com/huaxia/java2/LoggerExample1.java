package com.huaxia.java2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample1 {
    private static Logger log = Logger.getLogger("MyLogger");
    
    public static Book createBook(String id, String title, Double price) {
   	 
   	 log.log(Level.INFO, "Creating a Book");
   	 
   	 try {
   		 Book book = new Book(id, title, price);

   		 log.log(Level.INFO, "{}"+ book);
   		 
   		 return book;
   		 
   	 } catch (Exception e) {
   		 log.log(Level.SEVERE, e.getMessage());
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
