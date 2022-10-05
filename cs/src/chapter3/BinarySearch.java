package chapter3;

public class BinarySearch {

	/**
	 * Binary Search
	 * 
	 * @param n is the target number we try to find
	 * @param arr is the array we will search on
	 * @return an index of the number if found, or -1 if the number does NOT exist.
	 */
	public static int search(long n, long[] arr) {
		int first = 0;
		int last = arr.length-1;
		int mid = (first+last)/2;
		int count = 0;
		while(first<=last) {
			if(arr[mid]<n) {
				count++;
				first = mid + 1;
			}else if(arr[mid]==n) {
				count++;
				System.out.println("total comparison: " + count);
				return mid;
			}else {
				last = mid -1;
			}
			mid = (first+last)/2;
		}
		return -1;
	}
	
	public static int search1(long arr[], int first, int last, long n) {
		if(last>=first) {
			int mid = first + (last-first)/2;
			if(arr[mid] == n) {
				return mid;
			}
			if(arr[mid]>n) {
				return search1(arr, first, mid+1, n);
			}else {
				return search1(arr, first, mid-1, n);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		long[] arr = {2478346543L, 3563278900L, 3597211488L, 5656170224L, 6485551285L, 7719215281L, 8796562127L};
		long key = 3597211488L;
		int index = search(key, arr);
		System.out.println(index);
		key = 3597211488L;
		index = search1(arr, 0, arr.length-1, key);
		System.out.println(index);
		
	}

}
