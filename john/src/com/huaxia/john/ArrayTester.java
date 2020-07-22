package com.huaxia.john;

/**
 * To declare an array, define the variable type with square brackets:
 * 
 * Pencil[] pencils; int[] integers; String[] liquids;
 * 
 * @author wangqianjiang
 *
 */
public class ArrayTester {
	static int[] a = { 10, 12, 15, 16, 43, 23 };
	static final String[] type = { "No.2", "HB", "2B", "6B" };
	static final double[] price = { .25, 1.0, .1, .15 };
	static final String[] liquids = { "Water", "Coco", "Sprit", "Hot Water" };
	static String[] weekdays = { "No such day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
			"Sunday" };
	static String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };

	public static void main(String[] args) {
		ArrayTester test = new ArrayTester();
//		test.intArrayTest();
//		test.elementTest();
//		test.forEachTest();
//		test.changeIndividualElement();
//		test.arraycopyTest();  //create new array based on existing
//		test.objectArrayTest();
		test.multidimensionalArrayTest();
	}

	// Single responsibility
	void elementTest() {
		System.out.println(weekdays.length);
		System.out.println(weekdays[4]);
	}

	void changeIndividualElement() {
		listCars();
		cars[1] = "Opel";
		listCars();
	}

	static void listCars() {
		for (String car : ArrayTester.cars) {
			System.out.println(car);
		}
		System.out.println();
	}

	void intArrayTest() {
		for (int i = 0; i < a.length; i++) {
			String str = String.format("the array value at index %d is %d", i, a[i]);
			System.out.println(str);
		}
	}

	void forEachTest() {
		for (int b : a) {
			System.out.println(String.format("the element of the array value is %d", b));
		}
	}

	void arraycopyTest() {
		int[] b = new int[4]; // new int array default value is 0
		for (int i : b)
			System.out.println(i);
		System.arraycopy(a, 0, b, 0, 4);
		for (int i : b) {
			System.out.println(i);
		}
	}

	void objectArrayTest() {
		Pencil[] pencils = new Pencil[4];
		for (int i = 0; i < 4; i++) {
			pencils[i] = new Pencil(type[i], price[i]);
		}
		for (Pencil c : pencils) {
			System.out.println(c);
		}
	}

	void multidimensionalArrayTest() {
		// keep in mind, array index always start from 0.
		int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
		int x = myNumbers[1][2];
		System.out.println(x); // Outputs 7
		System.out.println();
		System.out.println(myNumbers.length);
		System.out.println(myNumbers[0].length);
		System.out.println(myNumbers[1].length);
		System.out.println();
		for (int i = 0; i < myNumbers.length; ++i) {
			for (int j = 0; j < myNumbers[i].length; ++j) {
				System.out.println(myNumbers[i][j]);
			}
		}
	}

}
