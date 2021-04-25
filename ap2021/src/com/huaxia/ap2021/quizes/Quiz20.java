package com.huaxia.ap2021.quizes;

import java.util.Scanner;

public class Quiz20 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		int[] arr = { 4, 7, 19, 25, 36, 37, 50, 100, 101, 205, 220, 271, 306, 321 };
		Searcher s = new Searcher(arr);
		int index = s.search(0, 13, 321);
		System.out.println(index);
	}

	private static void question2() {
		System.out.println("question 2...");
		int[] arr = { 4, 7, 19, 25, 36, 37, 50, 100, 101, 205, 220, 271, 306, 321 };
		Searcher s = new Searcher(arr);
		int index = s.search(0, 13, 205);
		System.out.println(index);
	}

	private static void question3() {
		System.out.println("question 3...");
		RandomList list = new RandomList();
		list.printList();
	}

	private static void question4() {
		System.out.println("question 4...");
		String str1 = "xy";
		String str2 = "cat";
		System.out.println(insert(str1, str2, 0));
		System.out.println(insert(str1, str2, 1));
		System.out.println(insert(str1, str2, 2));

	}

	private static void question5() {
		System.out.println("question 5...");
		int[][] mat = new int[2][3]; 
		mat[0][0] = -1;
		mat[0][1] = -2;
		mat[0][2] = -6;
		mat[1][0] = -2;
		mat[1][1] = -4;
		mat[1][2] = 5;
		changeMatrix(mat);
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(mat[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	static String insert1(String str1, String str2, int pos) {
		StringBuilder sb = new StringBuilder(str1);
		sb.insert(pos, str2);
		return sb.toString();
	}
	
	public static String insert (String str1, String str2, int pos) 
	{
	    String first, last; 
	    first = str1.substring(0,pos);
	    last = str1.substring(pos);
	    return first + str2 + last;  
	}

	public static void changeMatrix(int[][]  mat )
	{
	    for (int r = 0; r< mat.length; r++)
	        for (int c = 0; c< mat[r].length; c++)
	            if (r == c) 
	                mat[r][c] = Math.abs(mat[r][c]);
	}
}

class Searcher {
	private int[] arr;

	// Constructor. Initializes arr with integers.
	public Searcher(int[] arr) { /* implementation not shown*/
		this.arr = arr;
	}

	/* precondition: arr[first].. .arr[last] sorted in ascending order. 
	 * postcondition: Returns index of key in arr. If key not in arr, 
	 * returns -1 */
	public int search(int first, int last, int key) {
		int mid;
		int count = 0;
		while (first <= last) {
			count++;
			mid = (first + last) / 2;
			if (arr[mid] == key) { // found keY’ exit search
				System.out.println(count);
				return mid;
			}

			else if (arr[mid] < key) // key to right of arr[mid]
				first = mid + 1;
			else // key to left of an [mid]
				last = mid - 1;
		}
		return -1; // key not in list
	}
}

class RandomList {
	private int[] myList;

	// constructor
	public RandomList() {
		myList = getList();
	}

	/* Read random Integers from 0 to 100 inclusive into array list. */
	public int[] getList() 
    {
        System.out.println("How many integers? (enter number in next line)");
        Scanner io = new Scanner(System.in);
        int listLength = io.nextInt();  //read user input 
        int[] list = new int[listLength]; 
        for (int i=0; i<listLength; i++)
        {
            /* code to add integer to list */ 
        	list[i] = (int) (Math.random() * 101); 
        }
        io.close();
        return list; 
    }

	/* Print all elements of this list.*/
	public void printList()
    {
		for(int i: myList) {
			System.out.println(i);
		}
    }
}
