package org.huaxia.mongodb;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

/**
 * Connect to MongoDB database
 * 
 * implements CRUD: Create, Retrieve, Update, Delete operations.
 *
 * @see Book
 */
public class MongoDB_CRUD 
{
	static MongoClient mongoClient = new MongoClient("localhost", 27017);

	/**
	 * Create a book document in MongoDB
	 * 
	 * @param books
	 */
	static void createDocument(MongoCollection<Document> books) {
    	// Create document
    	Document doc = Book.getDocument("Python level I", "Laura Liang", 10.99, true, 5);
    	books.insertOne(doc);
	}
	
	/**
	 * Retrieve a book document from MongoDB
	 * 
	 * @param books
	 * @param id
	 */
	static void retrieveDocument(MongoCollection<Document> books, String id) {
    	// Retrieve document
    	Document doc = new Document("_id", id);
    	Iterator<Document> it = books.find(doc).iterator();
    	if(it.hasNext()) {
    		doc = it.next();
    		Book book = Book.getBook(doc);
    		System.out.println(book);
    	}
	}
	
	/**
	 * Update a book document by _id, and price in MongoDB.
	 * 
	 * @param books
	 * @param id
	 * @param price
	 */
	static void updatePrice(MongoCollection<Document> books, String id, double price) {
    	// Update document
    	books.updateOne(Filters.eq("_id", id), Updates.set("price", price));		
	}
	
	static void deleteDocument(MongoCollection<Document> books, String id) {
    	// Delete document
//    	DeleteResult result = books.deleteMany(Filters.eq("title", "Python level I"));
    	DeleteResult result = books.deleteOne(Filters.eq("_id", id));
    	System.out.println(result);		
	}
	
	static void retrieveAllBook(MongoCollection<Document> books) {
    	// Retrieve all documents
		Iterator<Document> it = books.find().iterator();
    	while(it.hasNext()) {
//    		System.out.println(it.next());
    		Document doc = it.next();
    		Book book = Book.getBook(doc);
    		System.out.println(book);
    	}
    	System.out.println();
	}
	
	static Book doc2book(Document doc) {
		Book book = new Book();
		book.set_id(doc.getString("_id"));
		book.setTitle(doc.getString("title"));
		book.setAuthor(doc.getString("author"));
		book.setPrice(doc.getDouble("price"));
		book.setRead(doc.getBoolean("read", false));
		book.setRating(doc.getInteger("rating", 0));
		return book;
	}
	
    public static void main( String[] args )
    {
    	MongoDatabase db = mongoClient.getDatabase("mydb");
    	MongoCollection<Document> books = db.getCollection("books");
    	
//    	createDocument(books);
//    	retrieveAllBook(books);
//    	deleteDocument(books, "afb744a9-292e-4934-a09f-0a94782be97b");
//    	retrieveDocument(books, "e50be011-370b-4df6-930f-c364c315848f");
    	retrieveAllBook(books);
    	
    }
}
