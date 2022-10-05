package chapter3;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = { 3, 60, 35, 2, 45, 320, 5 };

		System.out.println("Array Before Bubble Sort");
		System.out.println(Arrays.toString(arr));

		bubbleSort(arr);// sorting array elements using bubble sort

		System.out.println("Array After Bubble Sort");
		System.out.println(Arrays.toString(arr));
	}

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}

	}
}