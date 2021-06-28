package com.huaxia.ap2021.quizes;

public class Quiz2 {

	public static void main(String[] args) {
		question1();
//		question2();
//		question3();
//		question4();
//		question5();
	}

	private static void question1() {
		System.out.println("question1()...");
		int[] a1 = { 11, 2, 3, 24, 5, 6 };
		int[] a2 = { 1, 21, 3, 14, 15, 0 };
		swap2(a1, a2);
		System.out.println(a1);
		printArray(a1);
		printArray(a2);
		swap1(a1, a2);
		printArray(a1);
		printArray(a2);
	}

	private static void question2() {
		System.out.println("question2()...");
		String animal1 = "elephant";
		String animal2 = "lion";
		swap(animal1, animal2);
		animal1 = animal1.toUpperCase();
		animal2.toUpperCase();
		System.out.println(animal1 + " " + animal2);

	}

	private static void question3() {
		System.out.println(pow(3,3));

	}

	private static void question4() {
		System.out.println(f(8765));
	}

/**
 * @see Calculus
 */
	private static void question5() {
//		(A) public class Calculus
//		(B) public class apCalculus  
//		(C) public class APCalculus 
//		(D) public class 4Apcalculus 
//		(E) public class APCalculus extends Calculus 
	}

	public static void swap1(int[] a1, int[] a2) {
		for (int i = 0; i < a1.length; i++) {
			int arrhold = a1[i];
			a1[i] = a2[i]; // reassign value on index i
			a2[i] = arrhold;
		}
	}

	public static void swap2(int[] b1, int[] b2) {
		int[] arrhold = b1; // switch pointer
		b1 = b2;
		b2 = arrhold;
	}

	private static void printArray(int[] a1) {
		for (int i : a1) { // for each
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void swap(String s1, String s2) {
		String hold = s1;
		s1 = s2;
		s2 = hold;
	}

	public static double pow(double b, int x) {
		if (x == 0)
			return 1;
		else
			return b * pow(b, x - 1);
	}

	public static int f (int n) {
		if (n==0)
			return 0;
		else 
			return f(n/10) + n % 10; 
			
	}
}
