package com.huaxia.ap2021.quizes;

public class Quiz10 {

	public static void main(String[] args) {
		question1();
//		question2();
//		question3();
//		question4();
		question5();
	}

	static void question1() {
		int number = 3; // the number must be in the array
		int[] arr = { 1, 3, 5, 6, 8, 10 }; // the numbers in the array must be in order
		System.out.println(search(arr, 0, arr.length - 1, number));
	}

	static void question2() {
		int[] arr = { 23, 56, 12, 8, 12, 6, 9 };
		int number = 12;
		int index = search(number, arr);
		System.out.println(index);
	}
	
	static void question3() {
//		System.out.println(whatIsIt(3,3)); // x==y
//		System.out.println(whatIsIt(2,3)); // x<y
		System.out.println(whatIsIt(6,3)); // x>y
	}
	
	static void question4() {
		int[] a = { 23, 56, 12, 8, 12, 6, 9 };
		int max = 56;
		System.out.println(a[1]==max || !(max != a[1])); // || when first true ignore second
		System.out.println(a[2]==max || !(max != a[2]));
	}
	
	static void question5() {
		System.out.println(15*16+15);
	}
	
    public static int whatIsIt(int x, int y){
        if(x>y) //termination of recursion call
            return x* y;
        else
            return whatIsIt(x-1, y);
    }

	static int search(int[] a, int first, int last, int sought) {
		int mid = (first + last) / 2;
		if (a[mid] > sought) {
			last = mid - 1;
			return search(a, first, last, sought);
		} else if (a[mid] < sought) {
			first = mid + 1;
			return search(a, first, last, sought);
		}
		return mid;
	}

	static int search(int number, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (number == arr[i]) {
				return i;
			}
		}
		return -1;
	}

}
