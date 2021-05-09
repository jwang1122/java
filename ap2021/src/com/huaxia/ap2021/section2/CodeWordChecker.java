package com.huaxia.ap2021.section2;

/**
 * Refer to C:\Users\12818\workspace\apcomputer\exams\sectionII-12.md
 * 
 * @author John
 *
 */
public class CodeWordChecker implements StringChecker {
	private int minLength;
	private int maxLength;
	private String notIn;

	public CodeWordChecker(int minLength, int maxLength, String notIn) {
		this.minLength = minLength;
		this.maxLength = maxLength;
		this.notIn = notIn;
	}

	public CodeWordChecker(String notIn) {
		this.minLength = 6;
		this.maxLength = 20;
		this.notIn = notIn;
	}

	public boolean isValid(String str) {
		return str.length() >= minLength && str.length() <= maxLength && str.indexOf(notIn) == -1;
	}

	public static void main(String[] args) {
		// Example 1
		StringChecker sc1 = new CodeWordChecker(5, 8, "$");
		boolean isValid = sc1.isValid("happy");
		System.out.println(isValid);
		isValid = sc1.isValid("happy$");
		System.out.println(isValid);
		isValid = sc1.isValid("Code");
		System.out.println(isValid);
		isValid = sc1.isValid("happyCode");
		System.out.println(isValid);
		
		System.out.println();
		
		// Example 2
		StringChecker sc2 = new CodeWordChecker("pass");
		isValid = sc2.isValid("MyPass");
		System.out.println(isValid);
		isValid = sc2.isValid("Mypassport$");
		System.out.println(isValid);
		isValid = sc2.isValid("happy");
		System.out.println(isValid);
		isValid = sc2.isValid("1,000,000,000,000,000");
		System.out.println(isValid);
		
	}
}

interface StringChecker {
	/** Returns true if str is valid. */
	boolean isValid(String str);
}
