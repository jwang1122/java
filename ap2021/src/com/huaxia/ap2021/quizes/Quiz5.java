package com.huaxia.ap2021.quizes;

public class Quiz5 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	static void question1() {
		PairOfSunGlasses glasses = new PairOfSunGlasses();
		glasses.clean();
	}

	static void question2() {
		int[] nums = { 11, 22, 33, 44, 55, 66 };
		for (int i = 0; i < nums.length; i++) {
			nums[nums[i] / 11] = nums[i];
		}
		int i = 0;
		while (i < nums.length) {
			System.out.print(nums[i++]);
			if (i != 0 && i < nums.length)
				System.out.print(", ");
		}
		System.out.println();
	}

	static void question3() {
		System.out.println(4 + 6 % 12/4);
	}
	
	private static void question4() {
		System.out.println("(A) " + ((1.0 * 2.0) / (1.0 * 10)));
		System.out.println("(B) " + (2.0 / 10));
		System.out.println("(C) " + ((double) 2 / 10));
		System.out.println("(D) " + ((double)(2 / 10)));
		System.out.println("(E) " + (Math.sqrt(4) / Math.sqrt(100)));
		
	}

	private static void question5() {
//		System.out.println(""Friends"");
//		System.out.println("//"Friends//"");
//		System.out.println("/"Friends/"");	
		System.out.println("\"Friends\"");
//		System.out.println("\\"Friends\\"");
	}
}

class PairOfSunGlasses {
	boolean unfolded, cleaned, worn;

	void unfold() {

	}

	void clean() {
		System.out.println("Cleaning the glasses...");
	}

	void wear() {

	}

}
