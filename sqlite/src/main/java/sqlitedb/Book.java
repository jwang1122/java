package sqlitedb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Homework for 8/29:
 * 
 * build Book class include
 * fields: _id, title, author, read, price and rating
 * getters/setters
 * toString()
 * constructor()
 * 
 * @author John
 *
 */
public class Book extends DBSetting {
	private String _id;
	private String title;
	private String author;
	private boolean read = false;
	private double price;
	private int rating = 0;

	public Book(String title, String author, double price) {
		super();
		_id = UUID.randomUUID().toString();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book() {
	}

	public Book(String id2) {
		this._id = id2;
	}
	
	public void create() {
		String sqlFormat = "INSERT INTO books values('%s','%s','%s',%s,%f,%s)";
		String sql = String.format(sqlFormat, _id, title, author, read?1:0, price, rating);
		db.execute(sql);
	}

	public void update() {

	}

	public void delete() {

	}

	public static Book retrive(String id) {
		Book book = new Book();
		book.set_id(id);
		String sql = "SELECT * FROM books WHERE _id='" + id + "'";
		try {
			ResultSet rs = db.retrieve(sql);
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setRead(rs.getBoolean("read"));
			book.setPrice(rs.getDouble("price"));
			book.setRating(rs.getInt("rating"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return book;
	}
	
	public static List<Book> getAll(){
		String sql = "SELECT * FROM books";
		ResultSet rs = db.retrieve(sql);
		ArrayList<Book> bookList = new ArrayList<>();
		try {
			while(rs.next()) {
				Book book = new Book(rs.getString("_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setRead(rs.getBoolean("read"));
				book.setRating(rs.getInt("rating"));
				bookList.add(book);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return bookList;
	}
	


	// convert a database data record to Java Object
	public void loadBookFromDB() {
		String sql = "SELECT * FROM books WHERE _id='" + this._id + "'"; // database retrieve
		ResultSet rs = db.retrieve(sql);
		try {
			this.setTitle(rs.getString("title"));
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
		String sql = "UPDATE books SET title=?, author=?, read=?, price=?, rating=? WHERE _id='" + this._id + "'"; // database retrieve
		HashMap<Integer, Object> values = new HashMap<>();
		values.put(1, this.title);
		values.put(2, this.author);
		values.put(3, this.read);
		values.put(4, this.price);
		values.put(5, this.rating);
		db.writeToDB(sql, values);
		
	}
	
	public void deleteBookInDB() {
		String sql = "DELETE FROM books WHERE _id = '" + this._id + "'"; // database retrieve
		db.execute(sql);
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
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
