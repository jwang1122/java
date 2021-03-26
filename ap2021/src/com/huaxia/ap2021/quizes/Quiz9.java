package com.huaxia.ap2021.quizes;

public class Quiz9 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		int nums[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[0].length; c++) {
				System.out.print(nums[r][c] + " ");
			}
			System.out.print("\n");
		}
		System.out.println();

		for (int[] row : nums) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.print("");
		}
		System.out.println();

//		for (int r = 0; r < nums[0].length; r++) {
//			for (int c = 0; c < nums.length; c++) {
//				System.out.print(nums[r][c] +" ");
//			}
//			System.out.print("\n") ;
//		}
	}

	private static void question2() {
		Dog d1 = new SportingDog(30, 74, "Black"); // (A)
		Dog d2 = new Retriever("Labrador", "Yellow", 75); // (B)
		SportingDog d3 = new Retriever("Golden", "Red", 70); // (C)
//		SportingDog d4 = new Dog (25, 80, "Bed"); //(D) Dog is NOT SportingDog
		Retriever d5 = new Retriever("Golden", "Blonde", 60); // (E)
	}

	private static void question3() {
		Dog mason = new Retriever("Labrador", "chocolate", 85);
		System.out.println(mason.toString());
	}

	private static void question4() {
		System.out.println(pow(2, 3));

	}

	private static void question5() {
	    System.out.println(f(8765));
	}

	static double pow(double b, int x) {
/* (A) return sum*/
//		if (x == 0)
//			return 0;
//		else
//			return b + pow(b, x - 1);

/* (B) return sum */
		if (x == 0)
			return 1;
		else
			return b * pow(b, x - 1);
		
/* (C) always return 0*/
//		if (x == 0)
//			return 0;
//		else
//			return b * pow(b, x - 1);

//		if (x == 0)
//			return 1;
//		else
//			return b * pow(b, x - 1);

	}
	
    public static int f (int n) {
        if (n==0) // since integer/10 will actually go n==0, terminate recursion call.
            return 0;
        else 
            return f(n/10) + n % 10; // add each digit of input integer up           
    }
}

class Dog {
	private int height;
	private String size;
	private String color;

	Dog(int iheight, int iweight, String icolor) {
		height = iheight;
		color = icolor;
		if (iweight >= 65)
			size = "large";
		else
			size = "medium";
	}

	public int getHeight() {
		return height;
	}

	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public String toString() {
		return "        color is: " + color;
	}
}

class SportingDog extends Dog {
	private String purpose;

	SportingDog(int h, int w, String c) {
		super(h, w, c);
		purpose = "hunting";
	}

	public String getPurpose() {
		return purpose;
	}

}

class Retriever extends SportingDog {
	private String type;

	Retriever(String itype, String icolor, int iweight) {
		super(24, iweight, icolor);
		type = itype;
	}

	public String toString() {
		return "type: " + type + super.toString();
	}
}
