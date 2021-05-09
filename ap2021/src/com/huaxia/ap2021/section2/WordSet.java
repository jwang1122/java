package com.huaxia.ap2021.section2;

import java.util.TreeSet;

/**
 * Soluction for ~/workspace/apcomputer/exams/sectionII-02.md
 * 
 * @author John
 *
 */
public class WordSet {
	private TreeSet<String> words = new TreeSet<String>();

	public WordSet() {

	}

	/**
	* Constructor initializes set to empty
	*/
	public WordSet(String[] words) {
		/* implementation not shown */
		for (String word : words)
			this.words.add(word);
	}

	/**
	* ©return the number of words in set 
	*/
	public int size() {
		/* implementation not shown*/
		return words.size();
	}

	/**
	* Adds word to set (no duplicates) 
	* @param word the word to be added 
	*/
	public void insert(String word) {
		/* implementation not shown*/
		words.add(word);
	}

	/**
	* Removes word from set if present, else does nothing 
	* @param word the word to be removed
	*/
	public void remove(String word) {
		/* implementation not shown*/
		words.remove(word);
	}

	/**
	* Returns kth word in alphabetical order, where 1 <=k<=size(),
	* @param k position of word to be returned
	* @return the kth word 
	*/
	public String findkth(int k) {
		/* implementation not shown*/
		int index = 1;
		for (String word : words) {
			if (index == k)
				return word;
			index++;
		}
		return null;
	}

	/**
	* @returntrue if set contains word, false otherwise 
	*/
	public boolean contains(String word) {
		/* implementation not shown*/
		return words.contains(word);
	}

	// There may be instance variables, constructors, and methods
	// that are not shown.

	public TreeSet<String> getWords() {
		return words;
	}

	public String toString() {
		int index = 1;
		String result = "";
		for (String word : words) {
			result += index + " " + word + "\n";
			index++;
		}
		return result;
	}

	public static int countA(WordSet s) {
		int count = 0;
		while (count < s.size() && s.findkth(count + 1).substring(0, 1).equals("A"))
			count++;
		return count;
	}

	public static void removeA(WordSet s) {
		int numA = countA(s);
		for (int i = 1; i <= numA; i++)
			s.remove(s.findkth(1));
	}

	public static WordSet commonElements(WordSet s1, WordSet s2) {
		WordSet temp = new WordSet();
		for (int i = 1; i <= s1.size(); i++) {
			String nextWord = s1.findkth(i);
			if (s2.contains(nextWord))
				temp.insert(nextWord);
		}
		return temp;
	}

	public static void main(String[] args) {
		String[] words = { "GRAPE", "PEAR", "FIG", "APPLE" };
		WordSet wordSet = new WordSet(words);
		System.out.println(wordSet);
		System.out.println(wordSet.findkth(3));

		System.out.println(WordSet.countA(wordSet));
		WordSet.removeA(wordSet);
		System.out.println(wordSet);
		
		String[] s1Array = {"BE","NOT","AFRAID"};
		WordSet s1 = new WordSet(s1Array);
		String[] s2Array = {"TO","BE","OR","NOT"};
		WordSet s2 = new WordSet(s2Array);
		WordSet ws = WordSet.commonElements(s1, s2);
		System.out.println(ws);		
	}
}
