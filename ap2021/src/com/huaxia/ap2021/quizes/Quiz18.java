package com.huaxia.ap2021.quizes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz18 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		int i = 0xFF;
		System.out.println(i);

	}

	private static void question2() {
		System.out.println("question 2...");
		List<SomeType> list = new ArrayList<>();
		SomeType st = new SomeType(1);
		list.add(st);
		st = new SomeType(2);
		list.add(st);
		st = new SomeType(3);
		list.add(st);
		st = new SomeType(4);
		list.add(st);
		doSomething(list, 1, 3);
		for (SomeType s : list) {
			System.out.println(s);
		}

	}

	private static void question3() {
		System.out.println("question 3...");
		NegativeReal neg = new NegativeReal(-3.5);
		System.out.println(neg.getRounded());
		neg = new NegativeReal(-8.97);
		System.out.println(neg.getRounded());
		neg = new NegativeReal(-5.0);
		System.out.println(neg.getRounded());
		neg = new NegativeReal(-2.487);
		System.out.println(neg.getRounded());
		neg = new NegativeReal(-0.2);
		System.out.println(neg.getRounded());
	}

	private static void question4() {
		System.out.println("question 4...");
		whatsIt(347);
		System.out.println();
	}

	private static void question5() {
		System.out.println("question 5...");
		int[] arr1 = { 9, 14, 3, 2, 43, 11, 58, 22 };
//		int[] arr1 = { 2, 3, 9, 11, 14, 22, 43, 58 };
//		int[] arr1 = { 58, 43, 22, 14, 11, 9, 3, 2 };
		System.out.println("Before Insertion Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

		insertionSort(arr1);// sorting array using insertion sort

		System.out.println("After Insertion Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

		Integer[] arr2 = { 9, 14, 3, 2, 43, 11, 58, 22 };
//		Integer[] arr2 = { 2, 3, 9, 11, 14, 22, 43, 58 };
		List<Integer> num_sort = Arrays.asList(arr2);

		System.out.println("Before Insertion Sort");
		for (int i : arr2) {
			System.out.print(i + ", ");
		}
		System.out.println();

		selectionSort(num_sort);
		System.out.println("After Selection Sort");
		for (int x : num_sort) {
			System.out.print(x + ", ");
		}

	}

	public static void whatsIt(int n) {
		if (n > 10)
			whatsIt(n / 10);
		System.out.print(n % 10);
	}

	public static void doSomething(List<SomeType> list, int i, int j) {
		SomeType temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public static void insertionSort(int array[]) {
		int n = array.length;
		int count = 0;
		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				count++;
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
		System.out.println(count);
	}

	public static void selectionSort(List<Integer> num_sort) {
		int count = 0;
		// outer for loop to pick one element at a time
		// e.g if list is 20,12,3,4,5,6,98----this loop will first pick 20
		for (int i = 0; i < num_sort.size(); i++) {
			// assign that element as minimum
			// in our e.g 20 will be assigned min in first iteration
			int min = num_sort.get(i);
			int min_index = i;
			// go over the rest of the list and compare minimum by rest of list. if number smaller than min is found,
			// then it is assigned as new min
			// so go over list starting from 12 and comparing 20 with each of them and finding the new min, in this case
			// it will be 3
			for (int j = i + 1; j < num_sort.size(); j++) {
				count++;
				if (num_sort.get(j) < min) {
					min = num_sort.get(j);
					min_index = j;

				}
			}
			if (i != min_index) {
				exchange(num_sort, i, min_index);
			}
		}
		System.out.println(count);
	}

	// exchange the element at ith position with min
	public static void exchange(List<Integer> num_sort, int current_elem, int new_min) {
		int temp = num_sort.get(current_elem);
		num_sort.set(current_elem, num_sort.get(new_min));
		num_sort.set(new_min, temp);

	}
}

class SomeType {
	int i;

	SomeType(int x) {
		this.i = x;
	}

	public String toString() {
		return "" + i;
	}
}

class NegativeReal {
	private Double myNegReal;

	// constructor. Creates a NegativeReal object whose value is num.
	// Precondition: num < 0.
	public NegativeReal(double num) { /* implementation not shown*/
		myNegReal = num;
	}

	// Postcondition: Returns the value of this NegativeReal.
	public double getValue() { /* implementation not shown */
		return this.myNegReal;
	}

	// postcondition: Returns this NegativeReal rounded to the nearest integer.
	public int getRounded() {/* implementation */
		return (int) (getValue() - 0.5);
	}
}