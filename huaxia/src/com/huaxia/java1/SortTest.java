package com.huaxia.java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortTest {
	public static void main(String[] args) {
		SortTest test = new SortTest();
		test.sortArray();
		test.sortSubArray();
		test.sortArrayInReverseOrder();
		test.sortArrayList();
		test.sortObjectList();
	}

	private void sortObjectList() {
		ArrayList<Student> students = new ArrayList<Student>();
		Student s = new Student(1111, "John", "Wang", 87);
		students.add(s);
		s = new Student(22, "David", "Pang", 95);
		students.add(s);
		s = new Student(3133, "Alen", "Lee", 76);
		students.add(s);
		s = new Student(444, "Charles", "Johnson", 98);
		students.add(s);
		s = new Student(55, "David", "Pang", 88);
		students.add(s);
		Collections.sort(students);
		System.out.println(students);
		
	}

	void sortArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("JavaFx");
		list.add("Java");
		list.add("WebGL");
		list.add("OpenCV");
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
	}

	void sortArray() {
		int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
		System.out.printf("Original arr[] : %s\n", Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.printf("Modified arr[] : %s\n", Arrays.toString(arr));
	}

	void sortArrayInReverseOrder() {
		int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
		System.out.printf("\nOriginal arr[] : %s\n", Arrays.toString(arr));
		Arrays.sort(arr);
		reverse(arr);
		System.out.printf("Modified arr[] : %s\n", Arrays.toString(arr));
	}

	void sortSubArray() {
		int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
		System.out.printf("\nOriginal arr[] : %s\n", Arrays.toString(arr));
		Arrays.sort(arr, 1, 5);
		System.out.printf("Modified arr[] : %s\n", Arrays.toString(arr));
	}

	void reverse(int[] input) {
		int last = input.length - 1;
		int middle = input.length / 2;
		for (int i = 0; i <= middle; i++) {
			int temp = input[i];
			input[i] = input[last - i];
			input[last - i] = temp;
		}
	}

}
