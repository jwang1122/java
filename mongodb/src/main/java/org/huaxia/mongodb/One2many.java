package org.huaxia.mongodb;

import java.util.UUID;

import org.bson.Document;
import org.json.JSONArray;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class One2many {
	static MongoClient mongoClient = new MongoClient("localhost", 27017);

	public static void main(String[] args) {
    	MongoDatabase db = mongoClient.getDatabase("mydb");
    	MongoCollection<Document> publishers = db.getCollection("publishers");
    	JSONArray books = new JSONArray();
    	books.put("title:CouchDB: The Definitive Guide");
    	books.put("title:RESTful Web Services");
    	books.put("title:DocBook: The definitive Guide");
    	books.put("title:Building iPhone Apps with HTML, CSS, and JavaScript");
    	
		UUID uuid = UUID.randomUUID();
		Document doc = new Document();
		doc.append("_id", "oreilly1");
		doc.append("collection", "publisher");
		doc.append("name", "O'Reilly Media");
		doc.append("books", books.toString());
		publishers.insertOne(doc);
		
		System.out.println("Done.");

	}

}
