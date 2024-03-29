package com.huaxia.java2.sqlite;
/*
 * CRUD: Create, Retrieve, Update, Delete
 * 
 * Create ==> INSERT INTO
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Sqlite3 {
	public static void main(String[] args) {
    Connection c = null;
    Statement stmt = null;
    
    try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:test.db");
       c.setAutoCommit(false);
       System.out.println("Opened database successfully");
       
       stmt = c.createStatement();
       String sql = "INSERT INTO EMPLOYEE (ID,NAME,AGE,ADDRESS,SALARY) " +
                      "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
       stmt.executeUpdate(sql);

       sql = "INSERT INTO EMPLOYEE (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
       stmt.executeUpdate(sql);

       sql = "INSERT INTO EMPLOYEE (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
       stmt.executeUpdate(sql);

       sql = "INSERT INTO EMPLOYEE (ID,NAME,AGE,ADDRESS,SALARY) " +
                "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
       stmt.executeUpdate(sql);

       stmt.close();
       c.commit();
       c.close();
    } catch ( Exception e ) {
       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
       System.exit(0);
    }
    System.out.println("Records created successfully");
 }
}
