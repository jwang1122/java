package algorithms.chapter3;

import java.util.Arrays;

public class ConvergingPointers1 {

	public static void main(String[] args) {
//		int[] arr = { 0, 24, 16, 0, 36, 42, 23, 21, 0, 27 };
		int[] arr = {2,0,4,1};
		int legit = arr.length;
		int j = arr.length-1;
		for (int i = 0; i < arr.length; i++) {
			if (i < j) {
				if(arr[i]!=0) {
					i++;
				}else {
					legit--;
					arr[i] = arr[j];	
					j--;
				}
			}
			if(arr[i]==0)legit--;
		}

		System.out.println(Arrays.toString(arr));
		System.out.println(legit);
	}

}
