package algorithms.chapter2;

public class Problem2 {

	public static void main(String[] args) {
		int[] arr = { 22, 18, 23, 17, 25, 30, 2 };
		int index = FindLargest.findLargestIndex(arr);
		System.out.printf("The largest value %s is at index=%s\n", arr[index], index);
	}

}
