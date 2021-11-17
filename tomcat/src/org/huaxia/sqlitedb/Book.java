package org.huaxia.sqlitedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Homework for 8/29:
 * 
 * build Book class include fields: _id, title, author, read, price and rating
 * getters/setters toString() constructor()
 * 
 * @author John
 *
 */
public class Book extends DBSetting{
	private String title;
	private String author;
	private double price;
	private boolean read = false;
	private int rating = 0;
	private String id;

	public Book(String title, String author, double price) {
		super();
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book(String id2) {
		this.id = id2;
	}

	public void writeBookToDB() {
//		DBHelper db = new DBHelper(null);
		String sql = "INSERT INTO books VALUES (?,?,?,?,?,?)";
		HashMap<Integer, Object> values = new HashMap<>();
		values.put(1, this.id);
		values.put(2, this.title);
		values.put(3, this.author);
		values.put(4, this.read);
		values.put(5, this.price);
		values.put(6, this.rating);
		db.writeToDB(sql, values);
//		try {
//			PreparedStatement pstmt = DBHelper.conn.prepareStatement(sql);
//			pstmt.setString(1, this.id);
//			pstmt.setString(2, this.title);
//			pstmt.setString(3, this.author);
//			pstmt.setBoolean(4, this.read);
//			pstmt.setDouble(5, this.price);
//			pstmt.setInt(6, this.rating);
//			pstmt.execute();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static List<Book> searchBooksFromDB(String author){
		List<Book> list = new ArrayList<>();
		String sql = "SELECT * FROM books WHERE author LIKE'%" + author + "'"; 
		ResultSet rs = db.retrieve(sql);
		try {
			while (rs.next()) {
				Book book = new Book(rs.getString("_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setRead(rs.getBoolean("read"));
				book.setRating(rs.getInt("rating"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// homework try to test these code make sure it works
	public static List<Book> searchByTitle(String title){
		List<Book> list = new ArrayList<>();
		String sql = "SELECT * FROM books WHERE title LIKE'%" + title + "%'"; 
		ResultSet rs = db.retrieve(sql);
		try {
			while (rs.next()) {
				Book book = new Book(rs.getString("_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setRead(rs.getBoolean("read"));
				book.setRating(rs.getInt("rating"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// load every records from Database
	public static List<Book> loaddAllBooksFromDB() {
		List<Book> list = new ArrayList<>();
//		DBHelper db = new DBHelper(null);
		String sql = "SELECT * FROM books"; // database retrieve all records
		ResultSet rs = db.retrieve(sql);
		try {
			while (rs.next()) {
				Book book = new Book(rs.getString("_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setRead(rs.getBoolean("read"));
				book.setRating(rs.getInt("rating"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// convert a database data record to Java Object
	public void loadBookFromDB() {
//		DBHelper db = new DBHelper(null);
		String sql = "SELECT * FROM books WHERE _id='" + this.id + "'"; // database retrieve
		ResultSet rs = db.retrieve(sql);
		try {
			setTitle(rs.getString("title"));
			setAuthor(rs.getString("author"));
			setPrice(rs.getDouble("price"));
			setRead(rs.getBoolean("read"));
			setRating(rs.getInt("rating"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// update book record in the database
	public void updateBookInDB() {
//		DBHelper db = new DBHelper(null);
		String sql = "UPDATE books SET title=?, author=?, read=?, price=?, rating=? WHERE _id='" + this.id + "'"; // database
																													// retrieve
		HashMap<Integer, Object> values = new HashMap<>();
		values.put(1, this.title);
		values.put(2, this.author);
		values.put(3, this.read);
		values.put(4, this.price);
		values.put(5, this.rating);
		db.writeToDB(sql, values);

	}

	public void deleteBookFromDB() {
		String sql = "DELETE FROM books WHERE _id = '" + id + "'";
		db.execute(sql);
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() { // return a string to represent this object
		return "Book [title=" + title + ", price=$" + price + ", id="+id+"]";
	}

}
