package com.huaxia.java1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

	public static void main(String[] args) throws IOException {
		FileReader fw = new FileReader("card.csv");
		BufferedReader br = new BufferedReader(fw);
		String line=null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}

}
