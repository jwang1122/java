package com.huaxia.ap2021.section1;

public class Question40 {
	public int search(int[] a, int first, int last, int sought) {
		int mid = (first + last) / 2;
		if (a[mid] > sought) {
			last = mid - 1;
			return search(a, first, last, sought);
		} else if (a[mid] < sought) {
			first = mid + 1;
			return search(a, first, last, sought);
		}
//
//		if (a[mid] + 1 > sought) {
//			last = mid - 1;
//			return search(a, first,last, sought) ;
//		}
//		else if(a[mid] < sought){
//			first = mid + 1;
//			return search (a, first, last, sought); 
//		}

//		if (a[mid] > sought) {
//			last = mid - 1;
//			return search(a, first,last, sought) ;
//		}
//		else if(a[mid] < sought){
//			first = mid + 1;
//			return search (a, first, last, sought); 
//		}

//		if (a[mid] +1 > sought) {
//			last = mid - 1;
//			return search(a, first,last, sought) ;
//		}
//		else if(a[mid]-1 < sought){
//			first = mid + 1;
//			return search (a, first, last, sought); 
//		}

//		if (a[mid] = sought) {
//			last = mid - 1;
//			return search(a, first,last, sought) ;
//		}
//		else if(a[mid] = sought){
//			first = mid + 1;
//			return search (a, first, last, sought); 
//		}
		return mid;
	}

	public static void main(String[] args) {
		int number = 6;
		int[] arr = { 1, 3, 5, 6, 8, 10 };
		Question40 test = new Question40();
		System.out.println(test.search(arr, 0, arr.length - 1, number));
	}

}
