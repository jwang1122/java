package sqlitedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void createBookTable() {
		String sql = "CREATE TABLE IF NOT EXISTS books (_id text PRIMARY KEY,title text NOT NULL,"
				+ "author text,read boolean,price real,rating integer)"; // sql is a SQL statement
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	// Create data into database
	static void create() {
		String id = "1234";
		String title = "Introduction of Python";
		String author = "Helena";
		boolean read = false;
		double price = 10.99;
		int rating = 5;
		String sql = "INSERT INTO books VALUES('" + id + "','" + title + "','" + author + "'," + read + "," + price
				+ "," + rating + ")";
		System.out.println(sql);
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	// Retrieve book from database
	static void retrieve(String id) {
		String sql = "SELECT * FROM books WHERE _id='" + id + "'";
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString("_id") + "\t" +
							rs.getString("title") + "\t" +
							rs.getDouble("price")
					);					
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	static void retrieve() {
		String sql = "SELECT * FROM books";
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString("_id") + "\t" +
							rs.getString("title") + "\t" +
							rs.getDouble("price")
					);
					
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// update record in database
	static void update() {
		String sql = "UPDATE books SET price=? WHERE _id = ?";
		if (conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setDouble(1, 115.99);
				stmt.setString(2, "1234");
				stmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// delete record in database
	static void delete() {
		String sql = "DELETE FROM books WHERE _id ='1234'";
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		createNewDatabase("mydb.db");
//		System.out.println(conn);
//		createBookTable();
//		create();
//		retrieve("5678");
//		update();
//		delete();
		
//		List<Book> bookList = Book.getAll();
//		System.out.println(bookList);
//		
		Book book = new Book("1234");
		book.deleteBookInDB();
		System.out.println("Done.");
	}

}
