package com.huaxia.homeworks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpanishToEnglish {
//	private static final String filename = "spanish-english.dat";
	private Map<String, String> spanEnglishMap = new HashMap<String, String>();

	public Map<String, String> getMap() {
		return spanEnglishMap;
	}

	public void loadData(Scanner input) {
		System.out.println("Enter in the number of words in dictionary");
		int count = input.nextInt();
		input.nextLine();
		System.out.println("Enter in the spanish word and english word");		
		for (int i = 0; i < count; i++) {
			String line = input.nextLine();
			String[] words = line.split(" ");
			spanEnglishMap.put(words[0], words[1]);
		}
	}

	public String translate(String spanish) {
		String[] words = spanish.split(" ");
		String english = "";
		for (String s : words) {
			english = english.concat(spanEnglishMap.get(s)).concat(" ");
		}
		return english;
	}
}