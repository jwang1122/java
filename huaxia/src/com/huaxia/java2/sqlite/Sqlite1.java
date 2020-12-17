package com.huaxia.java2.sqlite;

/*
 * create sqlite database connection
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite1 {
	public static void main(String args[]) {
		Connection c = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Opened database successfully");
	}

}
