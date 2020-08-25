package com.huaxia.java2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTest {
	public static final String URL = "jdbc:sqlite:db/huaxia.db";

	public static void main(String[] args) throws ClassNotFoundException {
//		createNewDatabase("/sqlite/db/huaxia.db");
//		createNewDatabase();
//		createTable();
//		insertData();
		selectData();
	}

	public static void createNewDatabase() throws ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		try (Connection conn = DriverManager.getConnection(URL)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(URL);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return conn;
	}

	public static void createTable() {
		Connection conn = getConnection();

		Statement stmt;
		try {
			stmt = conn.createStatement();
			String sql = "CREATE TABLE STUDENT " + "(ID INT PRIMARY KEY NOT NULL," + " NAME TEXT NOT NULL, "
					+ " AGE INT, " + " GENDER CHAR(5), " + " Grade INT)";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Table created successfully...");
	}

	public static void insertData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "INSERT INTO STUDENT (ID,NAME,AGE,GENDER,GRADE) " + "VALUES (1, 'Paul', 12, 'Male', 5 );";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO STUDENT (ID,NAME,AGE,GENDER,GRADE) " + "VALUES (2, 'Helen', 13, 'Female', 6 );";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.commit();
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Insert data successfully...");
	}

	public static void selectData() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT;");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("gender");
				float salary = rs.getFloat("grade");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);
				System.out.println("AGE = " + age);
				System.out.println("Gender = " + address);
				System.out.println("Grade = " + salary);
				System.out.println();
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
	}

}
