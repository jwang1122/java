package com.huaxia.test;

import java.io.File;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws Exception{
		ScannerTest test = new ScannerTest();
//		test.consoleInputTest();
		test.stringDelimiter();
//		test.readFromFile();
	}
	
	void consoleInputTest() {
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name: ");
		String name = input.nextLine();
		System.out.printf("Hello, %s!\n", name);
		input.close();		
	}
	
	void stringDelimiter() {
	     String input = "1fish2 fish red fish blue fish";
	     Scanner s = new Scanner(input);
	     s = s.useDelimiter("\\s*fish\\s*"); // use string "fish" as delimiter
	     System.out.println("["+s.nextInt()+"]"); // nextInt()
	     System.out.println("["+s.nextInt()+"]");
	     System.out.println(s.next()); // next()
	     System.out.println(s.next());
	     s.close(); 		
	}
	
	void readFromFile() throws Exception {
		Scanner fileInput = new Scanner(new File("data/students.csv"));
		while(fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			System.out.println(line);
		}
		fileInput.close();
	}
}
