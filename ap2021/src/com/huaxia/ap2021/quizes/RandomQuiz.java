package com.huaxia.ap2021.quizes;

import java.util.Random;
import java.util.TreeSet;

public class RandomQuiz {

	public static void main(String[] args) {
		int numberOfQuizes = 2;
		int min = 1;
		int max = 10;
		TreeSet<Integer> set = new TreeSet<>();
		Random rand = new Random();
		while(set.size()<numberOfQuizes) {
			set.add(rand.nextInt(max-min) + min);			
		}
		printSet(set);
	}

	private static void printSet(TreeSet<Integer> set) {
		String s = "";
		for(int i: set) {
			s += i+",";
		}
		s = s.substring(0, s.length()-1);
		System.out.println(s);
	}
}
