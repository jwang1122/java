package algorithms;

import java.util.Arrays;

/**
 * page 146: Shuffle-Left Algorithm
 * 
 * @author John
 *
 */
public class ShuffleLeft {

	public static void main(String[] args) {
		int[] arr = {0,24,16,0,36,42,23,21,0,27};
//		int[] arr = {2,0,4,1};
		int count = arr.length;
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {
				count--;
				for(int j=i; j<count; j++) {
					arr[j] = arr[j+1];
				}
				System.out.println(Arrays.toString(arr));
			}else {
				sum += arr[i];
			}
		}
		System.out.println(count);
		System.out.printf("Average: %.2f\n",(double)sum/count);
	}

}
