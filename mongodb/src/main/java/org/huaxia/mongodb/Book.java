package org.huaxia.mongodb;

import java.sql.ResultSet;
import java.util.UUID;

import org.bson.Document;

public class Book {
	private String _id;
	private String title;
	private String author;
	private boolean read;
	private double price;
	private int rating;
	
	public Book() {
		
	}

	public Book(String title, String author, double price, boolean read, int rating) {
		UUID uuid = UUID.randomUUID();
		this._id = uuid.toString();
		this.title = title;
		this.author = author;
		this.price = price;
		this.read = read;
		this.rating = rating;
	}
	
	public static Book getBook(Document doc) {
		Book book = new Book();
		book.set_id(doc.getString("_id"));
		book.setTitle(doc.getString("title"));
		book.setAuthor(doc.getString("author"));
		book.setPrice(doc.getDouble("price"));
		book.setRead(doc.getBoolean("read", false));
		book.setRating(doc.getInteger("rating", 0));
		return book;
	}
	
	public static Document getDocument(String title, String author, double price, boolean read, int rating) {
		UUID uuid = UUID.randomUUID();
		Document doc = new Document();
		doc.append("_id", uuid.toString());
		doc.append("title", title);
		doc.append("author", author);
		doc.append("price", price);
		doc.append("read", read);
		doc.append("rating", rating);
		return doc;
	}
	
	public static Book getBook(ResultSet rs) {
		Book book = new Book();
		try {
			book.set_id(rs.getString("_id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setRead(rs.getBoolean("read"));
			book.setRating(rs.getInt("rating"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + "; price=" + price + "]";
	}
}
