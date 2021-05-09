package com.huaxia.ap2021.section2;

import java.util.ArrayList;

/**
 * Refer to C:\Users\12818\workspace\apcomputer\exams\sectionII-11.md
 * 
 * @author John
 *
 */
public class WordPairList {
	/** The list of word pairs, initialized by the constructor. */
	private ArrayList<WordPair> allPairs;

	/** Constructs a WordPairList object as described in part (a). 
	 * Precondition: words.length >= 2 
	 */
	public WordPairList(String[] words) {
		/* to be implemented in part (a) */
		allPairs = new ArrayList<WordPair>();

		for (int i = 0; i < words.length; i++)
			for (int j = i + 1; j < words.length; j++)
				allPairs.add(new WordPair(words[i], words[j]));
	}

	/** Returns the number of matches as described in part (b). 
	 */
	public int numMatches() { /* to be implemented in part (b) */
		int matches = 0;

		for (WordPair wp : allPairs)
			if (wp.getFirst().equals(wp.getSecond()))
				matches++;

		return matches;
	}
	
	public String toString() {
		String s = "";
		for(WordPair wp:allPairs) {
			s += wp;
		}
		return s;
	}
	
	public static void main(String[] args) {
		// Example 1
		String[] wordNums = {"one", "two", "three"}; 
		WordPairList exampleOne = new WordPairList(wordNums);
		System.out.println(exampleOne.allPairs);
		
		// Example 2
		String[] phrase = {"the", "more", "the", "merrier"}; 
		WordPairList exampleTwo = new WordPairList(phrase);
		System.out.println(exampleTwo.allPairs);
		
		String[] moreWords = {"the", "red", "fox", "the", "red"}; 
		WordPairList exampleThree = new WordPairList(moreWords);
		System.out.println(exampleThree.allPairs);
		
		int matches = exampleThree.numMatches();
		System.out.printf("There are %d pairs matches.\n",matches);
	}
}

class WordPair {
	private String first;
	private String second;
	
	/** Constructs a WordPair object. */
	public WordPair(String first, String second) 
	{
		/* implementation not shown */ 
		this.first = first;
		this.second = second;
	}

	/** Returns the first string of this WordPair object. */
	public String getFirst() { 
		/* implementation not shown */
		return first;
	}

	/** Returns the second string of this WordPair object. */
	public String getSecond() { 
		/* implementation not shown */
		return second;
	}
	
	public String toString() {
		return "(\"" + first + "\", \"" + second + "\")";
	}
}