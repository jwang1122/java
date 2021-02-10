package com.huaxia.ap2021.quizes;

public class Quiz4 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		int j = 0;
		String s = "map";
		while (j < s.length()) {
			int k = s.length();
			while (k > j) {
				System.out.println(s.substring(j, k));
				k--;
			}
			j++;
		}

	}

	private static void question2() {
		System.out.println(fI(5));
		System.out.println(fII(5));
		System.out.println(f(5));

	}

	private static void question3() {
		Tile t1 = new Tile(785, "grey", "ceramic", 6.95);
		t1.chgMaterial("marble");
		System.out.println(t1.toString());
	}

	private static void question4() {
		Tile t2 = new Tile(101, "blue");
        System.out.print(t2);

	}

	private static void question5() {
//	    (A) public static int inventory; // must be a instance level variable
//	    (B) private static double inventory; // must be a instance level variable
//	    (C) final int inventory; // must be able to be set with different value
//	    (D) private int inventory;
//	    (E) private int [] inventory; // won't be neccessary to use array
	}

	public static int fI(int n) {
		int factorial = 1;
		for (int i = n; i > 0; i--) {
			factorial *= n;
		}
		return factorial;
	}

	public static int fII(int n) {
		int factorial = 1;
		int j = 1;
		while (j <= n) {
			factorial *= j;
			j++;
		}
		return factorial;
	}

	public static int f(int n) {
		if (n == 1)
			return n;
		return n * f(n - 1);
	}
}

class Tile {
	private int styleNumber;
	private String color;
	private double width;
	private double height;
	private String material;
	private double price;
	private int inventory;
	
	Tile(int style, String col) {
		styleNumber = style;
		color = col;
	}

	Tile(int style, String col, double w, double h, String mat, double price) {
		styleNumber = style;
		color = col;
		width = w;
		height = h;
		material = mat;
		price = price;
	}

	Tile(int style, String col, String mat, double price) {
		styleNumber = style;
		color = col;
		material = mat;
		price = price;
	}

	public void chgMaterial(String mat) {
		String material = mat;
	}

	public String toString() {
		return (styleNumber + " " + color + " " + width + " " + height + " " + material + " " + price);
	}
}