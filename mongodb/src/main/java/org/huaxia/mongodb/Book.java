package org.huaxia.mongodb;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Book {
	static MongoClient mongoClient = new MongoClient("localhost", 27017);
	private String _id;
	private String title;
	private String author;
	private boolean read;
	private double price;
	private int rating;
	
	public Book() {
		
	}
	public static void main(String[] params) {
//		lendBook2Student("3d209655264244459b94cd06c88c661c","4e46d1b2-ceaf-4c81-8bff-d18e5fb271a9");
		List<Book> list = getAllBooksByStudent("4e46d1b2-ceaf-4c81-8bff-d18e5fb271a9");
		System.out.println(list);
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
	
	public static void lendBook2Student(String bookId, String studentId) {
    	MongoDatabase db = mongoClient.getDatabase("mydb");
    	MongoCollection<Document> books = db.getCollection("books");
		books.updateOne(Filters.eq("_id", bookId), Updates.set("studentId", studentId));
		System.out.println("Done.");
	}
	
	public static List<Book> getAllBooksByStudent(String studentId){
		List<Book> list = new ArrayList<>();
    	MongoDatabase db = mongoClient.getDatabase("mydb");
    	MongoCollection<Document> books = db.getCollection("books");
    	Iterator<Document> it = books.find(Filters.eq("studentId", studentId)).iterator();
    	while(it.hasNext()) {
    		Book book = Book.getBook(it.next());
    		list.add(book);
    	}
		return list;
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
	
	public static Book retrieve(String id) {
    	MongoDatabase db = mongoClient.getDatabase("mydb");
    	MongoCollection<Document> books = db.getCollection("books");
    	Document doc = new Document("_id", id);
    	Iterator<Document> it = books.find(doc).iterator();
    	if(it.hasNext()) {
    		return Book.getBook(doc);
    	}
    	return null;
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
