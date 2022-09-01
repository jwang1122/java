package languagebasics.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileTest {

	public static void main(String[] args) throws Exception{
		FileTest test = new FileTest();
//		test.readFileTest();
//		test.writeFileTest();
//		test.appendToFileTest();
		test.readCSVFile();
		System.out.println("Done.");
	}

	public ArrayList<String[]> readCSVFile() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("data/students.csv"));
		ArrayList<String[]> students = new ArrayList<String[]>();
		String line = "";
		while((line=br.readLine())!=null) {
			String[] row = line.split(",");
			students.add(row);
			System.out.println(line);
		}
		// add for loop to display certain column data
		br.close();
		return students;
		
	}

	void appendToFileTest() throws Exception{
//		File file = new File("hello.txt");
		FileWriter writer = new FileWriter("hello.txt",true);		
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
