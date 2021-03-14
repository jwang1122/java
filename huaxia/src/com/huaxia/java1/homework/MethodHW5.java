package com.huaxia.java1.homework;

/**
 * @author John
 *
 */
public class MethodHW5 {

	public static int count_Words(String str) {
		int count = 0;
		if (!(" ".equals(str.substring(0, 1))) || !(" ".equals(str.substring(str.length() - 1)))) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					count++;
				}
			}
			count = count + 1;
		}
		return count; // returns 0 if string starts or ends with space " ".
	}

	static int countWords(String s) {
		String[] arr = s.split(" ");
		return arr.length;
	}
	public static void main(String[] args) {
		String s = "The quick brown fox jumps over the lazy dog.";
		System.out.println(count_Words(s));
		System.out.println(countWords(s));

	}

}
