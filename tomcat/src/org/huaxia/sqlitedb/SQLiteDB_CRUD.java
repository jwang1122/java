package org.huaxia.sqlitedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * CRUD: Create, Retrieve, Update, Delete (4 basic operations for all kind of database)
 * 
 * @author John
 *
 */
public class SQLiteDB_CRUD {

	private static Connection conn;
	public static void createNewDatabase(String filename) {
		String url = "jdbc:sqlite:/Users/12818/workspace/" + filename;
		try {
			conn = DriverManager.getConnection(url);
		}catch(SQLException ex) {
			ex.printStackTrace();;
		}
	}
	
	static void createBookTable() {
		String sql = "CREATE TABLE IF NOT EXISTS books (" + 
				"_id text PRIMARY KEY," + 
				"title text NOT NULL," + 
				"author text," + 
				"read boolean," + 
				"price real," + 
				"rating integer" + ");"; // sql is a SQL statement
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	// Create data into database
	static void insertBookByValues() {
		String id = "1115";
		String title = "Introduction of US History";
		String author = "Hone Kai";
		boolean read = false;
		double price = 10.99;
		int rating = 5;
		String sql = "INSERT INTO books VALUES('"+
		 id + "','" +
		 title + "','" +
		 author + "'," +
		 read + "," +
		 price + "," +
		 rating +
		 ")";
		System.out.println(sql);
//		if (conn != null) {
//			try {
//				Statement stmt = conn.createStatement();
//				stmt.execute(sql);
//			}catch(Exception ex) {
//				ex.printStackTrace();
//			}
//		}
		DBHelper db = new DBHelper("/Users/12818/workspace/mydb.db");
		db.execute(sql);
	}
	
	// Create data into database
	static void insertBookByColumn() {
		String id = "1114";
		String title = "Introduction of Java";
		String author = "Helena";
		double price = 12.99;
		String sql = "INSERT INTO books (_id, title, author, price) VALUES('"+
		 id + "','" +
		 title + "','" +
		 author + "'," +
		 price +
		 ")";
		System.out.println(sql);
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}		
	}
	
	static void insertBook(Book book) {
		String sql = "INSERT INTO books VALUES('"+
				 book.getId() + "','" +
				 book.getTitle() + "','" +
				 book.getAuthor() + "'," +
				 book.isRead() + "," +
				 book.getPrice() + "," +
				 book.getRating() +
				 ")";
				System.out.println(sql);
				if (conn != null) {
					try {
						Statement stmt = conn.createStatement();
						stmt.execute(sql);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
	}
	
	static void retrieveBook(String id) { // retrive individual book by id
		String sql = "SELECT title, author, price from books WHERE _id = '" + id + "'";
		System.out.println(sql);
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				String title = rs.getString("title");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
//				System.out.println(title);
//				System.out.println(author);
//				System.out.println(price);
//				System.out.println(rs.getString(4));
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));
				Book book = new Book(title, author, price);
				System.out.println(book);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}		
	}
	
	static void getBookFromDB(String id) {
		String sql = "SELECT title, author, price from books WHERE _id = '" + id + "'";
		System.out.println(sql);
		DBHelper db = new DBHelper("/Users/12818/workspace/mydb.db");
		ResultSet rs = db.retrieve(sql);
		if(rs != null) {
			try {
				String title = rs.getString("title");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				Book book = new Book(title, author, price);
				System.out.println(book);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void delete(String id) {
		String sql = "DELETE FROM books WHERE _id = '" + id + "'";
		DBHelper db = new DBHelper("/Users/12818/workspace/mydb.db");
		db.execute(sql);
	}
	
	public static void main(String[] args) throws Exception {
//		createNewDatabase("mydb.db");
//		System.out.println(conn);
//		createBookTable();
//		insertBookByValues();
//		insertBookByColumn();
//		retrieveBook("fb6ed3e6-501c-4f7c-9a5c-3fc854a55f0d");
//		Book book = new Book("Successful Aging","Daniel J. Levitin",38.50, false, 5);
//		insertBook(book);
//		conn.close();
//		getBookFromDB("1114");
//		Book book = new Book("fb6ed3e6-501c-4f7c-9a5c-3fc854a55f0d");
//		book.loadBookFromDB();
//		System.out.println(book);
	
//		Book book = new Book("Ancient Rome: The Rise and Fall of An Empire", "Simon Baker", 14.95);
//
//		book.writeBookToDB();

//		Book book = new Book("1234");
//		book.loadBookFromDB();
//		book.setPrice(15.11);
//		book.updateBookInDB();
		
//		delete("1234"); // pass id, delete from outside method
//		Book book = new Book("1111");
//		book.deleteBookFromDB(); // delete by book object itself. OOP
		
//		List<Book> list = Book.loaddAllBooksFromDB(); // class level method
//		System.out.println(list);
//		System.out.println(list.size());
//		
//		Book book = new Book("fb6ed3e6-501c-4f7c-9a5c-3fc854a55f0d");
//		book.deleteBookFromDB();
		
//		Student.createStudentTable();
//		Student s = new Student();
//		s.setId("1111");
//		s.setName("John Wang");
//		s.setCourse("CS4231");
//		s.writeStudentToDB();
		List<Book> list = Book.searchBooksFromDB("Helena");
		System.out.println(list);
		
		Book book = list.get(1);
		book.setPrice(10.99);
		book.updateBookInDB();
		System.out.println("Done.");
		

	}

}
