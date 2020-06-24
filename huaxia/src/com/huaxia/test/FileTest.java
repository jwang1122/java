package com.huaxia.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileTest {

	public static void main(String[] args) throws Exception{
		FileTest test = new FileTest();
//		test.readFileTest();
//		test.writeFileTest();
//		test.appendToFileTest();
		test.readCSVFile();
		System.out.println("Done.");
	}

	private void readCSVFile() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("data/students.csv"));
		String line = "";
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
		
	}

	void appendToFileTest() throws Exception{
		File file = new File("hello.txt");
		FileWriter writer = new FileWriter(file, true);		
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write("this is fourth line.\n");
		bw.write("this is fifth line.\n");
		bw.close();
		

	}

	void writeFileTest() throws Exception {
		File file = new File("hello.txt");
		FileWriter writer = new FileWriter(file);		
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write("this is first line.\n");
		bw.write("this is second line.\n");
		bw.close();
	}

	void readFileTest() throws Exception {
		File file = new File("hello.txt");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String line = "";
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}
}
