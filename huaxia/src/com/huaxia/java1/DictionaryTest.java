package com.huaxia.java1;

import java.io.*;

import java.util.*;

public class DictionaryTest {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("words.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			String word = null;
			ArrayList<String> aListWords = new ArrayList<String>();

			int j = 0;
			while ((s = br.readLine()) != null) {
				Scanner scan = new Scanner(s);
				while (scan.hasNext()) {
					word = scan.next().toLowerCase();
					aListWords.add(word);
					j++;
				}
				scan.close();
			}
			br.close();
			fr.close();

			removeDuplicates(aListWords);
			Collections.sort(aListWords);

			int size = aListWords.size();
			for (int i = 0; i > size; i++) {
				System.out.println(aListWords.get(i));
			}
			System.out.println(j);
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void removeDuplicates(ArrayList<String> aList) {
		HashSet<String> h = new HashSet<>(aList);
		aList.clear();
		aList.addAll(h);
	}
}