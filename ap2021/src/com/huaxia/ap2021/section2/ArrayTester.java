package com.huaxia.ap2021.section2;

/**
 * Refer to C:\Users\12818\workspace\apcomputer\exams\sectionII-13.md
 * 
 * @author John
 *
 */
public class ArrayTester {

	public static int[] getColumn(int[][] arr2D, int c) {
		int[] column = new int[arr2D.length];

		for (int i = 0; i < column.length; i++)
			column[i] = arr2D[i][c];

		return column;
	}

	public static boolean isLatin(int[][] square) {
		for (int i = 0; i < square.length; i++) {
			int[] col = getColumn(square, i);
			if (containsDuplicates(square[0]) || !hasAllValues(square[0], square[i]) || !hasAllValues(square[0], col)) {
				return false;
			}
		}

		return true;
	}

	public static boolean hasAllValues(int[] arr1, int[] arr2) {
		for (int arr1Index = 0; arr1Index < arr1.length; arr1Index++) {
			boolean contains = false;
			for (int arr2Index = 0; arr2Index < arr2.length; arr2Index++) {
				if (arr1[arr1Index] == arr2[arr2Index])
					contains = true;
			}

			if (!contains)
				return false;
		}

		return true;
	}

	public static boolean containsDuplicates(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[i] == arr[j])
					return true;

		return false;
	}

	public static void main(String[] args) {
		// question (a)
		int[][] arr2D = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 9, 5, 3 } };
		int[] result = ArrayTester.getColumn(arr2D, 1);
		System.out.print("{");
		for(int i=0; i<result.length;i++) {
			System.out.print(result[i]);
			if(i<result.length-1)
				System.out.print(", ");
			
		}
		System.out.println("}");

		// question (b)
		int[][] latin1 = {{1,2,3},{2,3,1},{3,1,2}};
		boolean isLatin = ArrayTester.isLatin(latin1);
		System.out.println(isLatin);
		
		int[][] latin2 = {{10,30,20,0},{0,20,30,10},{30,0,10,20},{20,10,0,30}};
		isLatin = ArrayTester.isLatin(latin2);
		System.out.println(isLatin);
		
		int[][] latin3 = {{1,2,1},{2,1,1},{1,1,2}};
		isLatin = ArrayTester.isLatin(latin3);
		System.out.println(isLatin);

		int[][] latin4 = {{1,2,3},{3,1,2},{7,8,9}};
		isLatin = ArrayTester.isLatin(latin4);
		System.out.println(isLatin);
	
		int[][] latin5 = {{1,2},{1,2}};
		isLatin = ArrayTester.isLatin(latin5);
		System.out.println(isLatin);
		
	}

}
