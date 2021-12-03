package org.huaxia.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.Document;
import org.json.JSONArray;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Student {
	static MongoClient mongoClient = new MongoClient("localhost", 27017);
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	private int grade;
	private List<Book> borrowedBooks = new ArrayList();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	static void testStudentHoldsBookIds() {
		MongoDatabase db = mongoClient.getDatabase("mydb");
		MongoCollection<Document> students = db.getCollection("students");
		JSONArray books = new JSONArray();
		books.put("3f3dbfaf1c3f4fd5a2ae43e989144e4d");
		books.put("3d209655264244459b94cd06c88c661c");
		books.put("214aa7a4acda40ffb500d0f4aad39e0b");

		UUID uuid = UUID.randomUUID();
		Document student = new Document();
		student.append("_id", uuid.toString());
		student.append("firstName", "John");
		student.append("lastName", "Wang");
		student.append("books", books);
		students.insertOne(student);
		
	}
	
	
	public static void main(String[] params) {
		MongoDatabase db = mongoClient.getDatabase("mydb");
		MongoCollection<Document> students = db.getCollection("students");
		UUID uuid = UUID.randomUUID();
		Document student = new Document();
		student.append("_id", "s2222");
		student.append("firstName", "John");
		student.append("lastName", "Wang");
		students.insertOne(student);
		List<String> bookIds = new ArrayList<String>();
		bookIds.add("3f3dbfaf1c3f4fd5a2ae43e989144e4d");
		bookIds.add("214aa7a4acda40ffb500d0f4aad39e0b");
		students.updateOne(Filters.eq("_id","s2222"), Updates.pushEach("bookId", bookIds));
		System.out.println("Done.");
	}
}
