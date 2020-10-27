package com.huaxia.homeworks;

import java.util.ArrayList;
import java.util.Scanner;

public class SpanRunner {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		SpanishToEnglish translator = new SpanishToEnglish();

		doTranslate(translator);
		System.out.println("Done.");
	}

	private static void doTranslate(SpanishToEnglish translator) {
		translator.loadData(input);
		System.out.println("Enter in the number of phrases to translate: ");		
		int number = input.nextInt();
		input.nextLine();
		System.out.println("Enter in the line to translate: ");
		ArrayList<String> spanishPhrases = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			String span = input.nextLine();
			spanishPhrases.add(span);
		}
		for (String line : spanishPhrases) {
			System.out.println(translator.translate(line));
		}
		input.close();
	}
}
