package com.huaxia.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws Exception{
		ScannerTest test = new ScannerTest();
		test.consoleInputTest();
//		test.stringDelimiter();
//		test.readFromFile();
//		test.fileToClass();
	}
	
	void consoleInputTest() {
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name: ");
		String name = input.nextLine();
		System.out.printf("Hello, %s!\n", name);
		input.close();		
	}
	
	@SuppressWarnings("resource")
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
	
	/**
	 * Read students information from CSV (Comma Separated Values) file.
	 * Display on console.
	 * 
	 * @throws Exception
	 */
	void readFromFile() throws IOException {
		Scanner fileInput = new Scanner(new File("data/students.csv"));
		while(fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			System.out.println(line);
		}
		fileInput.close();
	}

	/**
	 * Read Students information from a csv file
	 * and build Student object based on it.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	void fileToClass() throws IOException {
		Scanner fileInput = new Scanner(new File("data/students.csv"));
		ArrayList<Student> students = new ArrayList<Student>();
		String line = fileInput.nextLine();
		System.out.println(line);
		while(fileInput.hasNextLine()) {
			line = fileInput.nextLine();
			System.out.println(line);
			Scanner split = new Scanner(line).useDelimiter(",");
			int id = split.nextInt();
			String firstName = split.next();
			String lastName = split.next();
			int score = split.nextInt();
			split.close();
			Student student = new Student(id, firstName, lastName, score);
			students.add(student);
		}
		fileInput.close();
		System.out.println("\nUnsorted: ");
		for(Student s : students) {
			System.out.println(s);
		}

		Collections.sort(students);
		
		System.out.println("\nSorted:");
		for(Student s : students) {
			System.out.println(s);
		}
		System.out.println();
		System.out.printf("The average score of %d students is %5.2f.",students.size(), Student.average(students));
	}
}
