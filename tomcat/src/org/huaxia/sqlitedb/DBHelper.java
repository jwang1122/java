package org.huaxia.sqlitedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBHelper {
	private String filepath = "/Users/12818/workspace/mydb.db"; // default setting for Database
	public static Connection conn;
	
	public DBHelper(String filepath) {
		if(filepath!=null) {
			this.filepath = filepath; // change default setting
		}
		String url = "jdbc:sqlite:" + this.filepath;
		
		try {
			if(conn==null) {
				conn = DriverManager.getConnection(url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void execute(String sql) {
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			}catch(Exception ex) {
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
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return rs;
	}
	
	public void writeToDB(String sql, HashMap<Integer, Object> values) {
		try {
			PreparedStatement pstmt = DBHelper.conn.prepareStatement(sql);
			for(int i=1; i<=values.size(); i++) {
				pstmt.setObject(i, values.get(i));
			}
			pstmt.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
