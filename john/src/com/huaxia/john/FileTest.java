package com.huaxia.john;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTest {

	public static void main(String[] args) {
		FileTest test = new FileTest();
//		test.readFileTest();
//		test.writeFileTest();
//		test.appendToFileTest();
		test.readCSVFile();
		System.out.println("Done.");
	}

	public ArrayList<String[]> readCSVFile() {
		BufferedReader br;
		ArrayList<String[]> students = new ArrayList<String[]>();
		try {
			br = new BufferedReader(new FileReader("data/students.csv"));

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				students.add(row);
				System.out.println(line);
			}
			// add for loop to display certain column data
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;

	}

	void appendToFileTest() {
//		File file = new File("hello.txt");
		FileWriter writer;
		try {
			writer = new FileWriter("hello.txt", true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("this is fourth line.\n");
			bw.write("this is fifth line.\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void writeFileTest() {
		File file = new File("hello.txt");
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("this is first line I write to hello.txt.\n");
			bw.write("this is second line.\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void readFileTest() {
		File file = new File("hello.txt");
		FileReader reader;
		try {
			reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
