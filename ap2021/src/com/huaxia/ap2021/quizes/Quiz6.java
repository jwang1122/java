package com.huaxia.ap2021.quizes;

public class Quiz6 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		Constellation c1 = new Constellation("Hercules", "July");
		Constellation c2 = new Constellation("Pisces", "Nov", 90, 65);
//		Constellation c3 = new Constellation("Aquarius", "Oct", 65.0, 9.0);
		Constellation c4 = new Constellation("Leo", "4", 0, 0);
		Constellation c5 = new Constellation("Phoenix", "Nov", 32, 90);
	}

	private static void question2() {
		// all tree methods are compiled

	}

	private static void question3() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = arr1;
		int last = arr1.length - 1;

		for (int i = 0; i < arr1.length; i++)
			arr2[i] = arr1[last - i];

		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ");

		System.out.println(" ");

		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i] + " ");
		System.out.println();
	}

	private static void question4() {
		int[] arr3 = { 1, 2, 3, 4, 5, 6 };

		for (int element : arr3) {
			element *= 2;
			System.out.print(element + " ");
		}
		System.out.println("");

		for (int element : arr3)
			System.out.print(element + " ");
		System.out.println();
	}

	private static void question5() {
		int[] numbers = { -11, -2, -3, -24, -5, -6 };
		int holdSmallest = Integer.MAX_VALUE;
		int holdLargest = 0;
		int a = 0;
		int b = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] <= holdSmallest) {
				holdSmallest = numbers[i];
				a = i;
			}
			if (numbers[i] >= holdLargest) {
				holdLargest = numbers[i];
				b = i;
			}
		}
		System.out.println(a + " " + b);
	}

}

class Constellation {
	private String name;
	private String month;
	private int northernLatitude;
	private int southernLatitude;

	public Constellation(String name, String month) {
		super();
		this.name = name;
		this.month = month;
		northernLatitude = 0;
		southernLatitude = 0;
	}

	public Constellation(String name, String month, int northernLatitude, int southernLatitude) {
		super();
		this.name = name;
		this.month = month;
		this.northernLatitude = northernLatitude;
		this.southernLatitude = southernLatitude;
	}

	public void chgMonth(String m) {
		String month = m;
	}

	public void chgLatitude(String direction, int latitude) {
		if (direction.toUpperCase().equals("N")) {
			this.northernLatitude = latitude;
		} else if (direction.toUpperCase().equals("S")) {
			this.southernLatitude = latitude;
		}
	}

	public void chgLatitude(int northLatitude, int southLatitude) {
		this.northernLatitude = northLatitude;
		this.southernLatitude = southLatitude;
	}

	public void chgLatitude(double northLatitude, double southLatitude) {
		this.northernLatitude = (int) northLatitude;
		this.southernLatitude = (int) southLatitude;
	}
}
