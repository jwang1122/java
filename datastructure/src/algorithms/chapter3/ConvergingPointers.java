package algorithms;

import java.util.Arrays;

public class ConvergingPointers {

	public static void main(String[] args) {
		int[] arr = { 0, 24, 16, 0, 36, 42, 23, 21, 0, 27 };
		int legit = arr.length;
		int j = arr.length-1;
		for (int i = 0; i < arr.length; i++) {
			if(i==j) break;
			if (arr[i] == 0) {
				while(arr[j]==0) {
					j--;
					legit--;
				}
				arr[i] = arr[j];	
				j--;
				legit--;
			}
		}

		System.out.println(Arrays.toString(arr));
		System.out.println(legit);
	}

}
