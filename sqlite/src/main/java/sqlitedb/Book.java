package sqlitedb;

import java.sql.ResultSet;
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
