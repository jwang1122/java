package sqlitedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private String filepath;
	public static Connection conn;

	public DBHelper(String filepath) {
		super();
		this.filepath = filepath;
		String url = "jdbc:sqlite:" + this.filepath;
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void execute(String sql) { // shared by create table, insert record, delete record
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public ResultSet retrieve(String sql) {
		ResultSet rs = null;
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return rs;
	}

	public void updateBook(String id, Book book) {
		String sql = "UPDATE books SET title=?,author=?,read=?,price=?,rating=? WHERE _id = ?";
		if (conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, book.getTitle());
				stmt.setString(2, book.getAuthor());
				stmt.setBoolean(3, book.isRead());
				stmt.setDouble(4, book.getPrice());
				stmt.setInt(5, book.getRating());
				stmt.setString(6, book.get_id());
				stmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
