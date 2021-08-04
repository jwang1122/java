package org.huaxia.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.huaxia.mongodb.Book;

/**
 *
 * @author sqlitetutorial.net
 */
public class SQLiteDB_CRUD {
	static Connection conn;

	/**
	 * Connect to a sample database
	 *
	 * @param fileName the database file name
	 */
	public static void createNewDatabase(String fileName) {
		String url = "jdbc:sqlite:C:/Users/12818/workspace/sqlite/db/" + fileName;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	static void createBookTable() {
		String sql = "CREATE TABLE IF NOT EXISTS books (" + "_id text PRIMARY KEY," + "title text NOT NULL,"
				+ "author text," + "read boolean," + "price real," + "rating integer" + ");";
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * Create a book record
	 * 
	 * @param book
	 */
	static void insertBook(Book book) {
		int read = 0;
		if(book.isRead())
			read = 1;
		String sql = "insert into books (_id, title, author, price, read, rating) values('" + book.get_id() + "','"
				+ book.getTitle() + "','" + book.getAuthor() + "'," + book.getPrice() + "," + read + ","
				+ book.getRating() + ")";
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	static ArrayList<Book> retrieveBooks() {
		String sql = "select * from books";
		ArrayList<Book> books = new ArrayList<Book>();
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Book book = Book.getBook(rs);
					books.add(book);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return books;
	}

	/**
	 * retrieve book by id
	 * 
	 * @param id
	 * @return
	 */
	static Book retrieveBook(String id) {
		String sql = "select * from books where _id='" + id + "'";
		Book book = null;
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					book = Book.getBook(rs);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return book;
	}

	/**
	 * Update book by id
	 * @param id
	 * @param book
	 */
	static void updateBook(String id, Book book) {
		String sql = "update books set title=?, author=?,price=?, read=?, rating=? where _id=?";
		if (conn != null) {
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getTitle());
				pstmt.setString(2, book.getAuthor());
				pstmt.setDouble(3, book.getPrice());
				pstmt.setBoolean(4, book.isRead());
				pstmt.setInt(5, book.getRating());				
				pstmt.setString(6, book.get_id());
				pstmt.execute();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * delete book by id
	 * 
	 * @param id
	 */
	static void deleteBook(String id) {
		String sql = "delete from books where _id = '" + id + "'";
		if(conn!=null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		createNewDatabase("test.db");
//		createBookTable();
		Book book = new Book("Java level II", "David", 12.99, false, 5);
		insertBook(book);

//		Book book = retrieveBook("94238ed6-c480-456a-9f65-01d1b019f1a3");
//		System.out.println(book);
//		book.setPrice(10.99);
//		updateBook("94238ed6-c480-456a-9f65-01d1b019f1a3", book);
		System.out.println(retrieveBooks());
//		deleteBook("72b3ecea-b483-4fac-84f3-20eedcd8eefe");
//		System.out.println(retrieveBooks());
	
	}
}