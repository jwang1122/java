package languagebasics.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {

	public static void main(String[] args) {
		readFromRootFolder();
		System.out.println();
		readFromClasspath();
		System.out.println();
		System.out.println(readFromClasspath("card.csv"));
		System.out.println("Done.");
	}

	/**
	 * Read csv file from project root folder by using BufferedReader class.
	 */
	static void readFromRootFolder() {
		FileReader fw;
		try {
			fw = new FileReader("data/dominos.csv");
			BufferedReader br = new BufferedReader(fw);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read csv file from classpath.
	 */
	static void readFromClasspath() {
		InputStream is = ReadCSV.class.getResourceAsStream("card.csv");
		Scanner input = new Scanner(is);
		input.nextLine(); // get rid of header line
		while (input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
		}
		input.close();
	}

	/**
	 * Build Card object list from csv file which located in classpath.
	 * 
	 * @param filename
	 * @return a array list contains Card objects.
	 */
	static ArrayList<Card> readFromClasspath(String filename) {
		ArrayList<Card> list = new ArrayList<>();
		InputStream is = ReadCSV.class.getResourceAsStream(filename);
		Scanner input = new Scanner(is);
		input.nextLine(); // get rid of header line
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] values = line.split(",");
			Card card = new Card(values[0], values[1]);
			list.add(card);
		}
		input.close();
		return list;
	}

}
