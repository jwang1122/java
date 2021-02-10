package com.huaxia.ap2021.quizes;

import java.util.ArrayList;

public class Quiz7 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		int[] sales = { 11, 2, 3, 24, 5, 6 };
        double avg = 0;
        int i = 0;
        int sum = 0;
        for (int element: sales) 
        {
            sum += element;
        }
        avg = (double) sum / sales.length;
        System.out.println(avg);
 	}

	private static void question2() {
		int[] a1 = { 11, 2, 3, 24, 5, 6 };
		int[] a2 = { 1, 21, 3, 14, 15, 0 };
		swap2(a1, a2);
		printArray(a1);
		printArray(a2);
		swap1(a1,a2);
		printArray(a1);
		printArray(a2);
		
	}

	private static void question3() {
		ArrayList<String> alist1 = new ArrayList<String>();
		alist1.add("4.5");
		ArrayList<Integer> alist2 = new ArrayList<Integer>();
        alist2.add((int)4.5);
        ArrayList<Double> alist3;
        alist3 = new ArrayList<Double>();
        alist3.add(4.5);
	}

	private static void question4() {
		ArrayList<Integer> alist1 = new ArrayList<Integer>();
        int[] a1 = { 2, 4, 6, 7, 8, 10, 11 };
        for (int a : a1) {
            alist1.add(a);
        }
        for (int i = 0; i < alist1.size(); i++) {
            if (alist1.get(i) % 2 == 0) {
                alist1.remove(i); // dangerous
            }
        }
        System.out.println(alist1);
		
	}

	private static void question5() {
	    int[][] arr2d = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        String s = "";
        for (int a = 0; a < arr2d[0].length; a++) {
            for (int b = 0; b < arr2d.length; b++) {
                s += arr2d[b][a] + " ";
            }
            s += "\n";
        }
        System.out.print(s);		
	}

    public static void swap1(int[] a1, int[] a2) {
        for (int i=0; i< a1.length; i++) {
            int arrhold = a1[i];
            a1[i] = a2[i];
            a2[i] = arrhold;
        }
    }
    
    public static void swap2(int[] a1, int[] a2) {
        int[] arrhold = a1;
        a1 = a2;
        a2 = arrhold;
    }
    
	private static void printArray(int[] a1) {
		for(int i: a1) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}


}
