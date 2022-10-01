package algorithms.chapter2;

public class FindLargest {

	public static void main(String[] args) {
		int[] arr = {19, 41, 12, 63, 22};
		int index = findLargestIndex(arr);
		System.out.printf("The largest value %s is at index=%s\n", arr[index], index);
	}

	public static int findLargestIndex(int[] arr) {
		int largest = -1;
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>largest) {
				largest = arr[i];
				index = i;
			}
		}
		return index;
	}

}
