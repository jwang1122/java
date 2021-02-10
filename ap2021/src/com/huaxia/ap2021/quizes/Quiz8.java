package com.huaxia.ap2021.quizes;

import java.util.ArrayList;

public class Quiz8 {

	public static void main(String[] args) {
		question1_2();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1_2() {
		int count = 0;
		ArrayList<Integer> alist5 = new ArrayList<Integer>();
		int[] a1 = { 21, 6, 2, 8, 1 };
		for (int a : a1) {
			alist5.add(a);
		}
		for (int k = 0; k < alist5.size() - 1; k++) {
			for (int i = 0; i < alist5.size() - 2; i++) {
				count++;
				if (alist5.get(i) > alist5.get(i + 1)) {
					int hold = alist5.remove(i);
					alist5.add(i + 1, hold);
				}
			}
		}
		System.out.println(count);
		System.out.println(alist5);
	}

	private static void question2() {
		// TODO Auto-generated method stub

	}

	private static void question3() {
		Xylophone phone = new Xylophone("iPhone6", 0.54, 11);
		System.out.println(phone.getName());
		System.out.println(phone.getWeight());
		System.out.println(phone.getNumKeys());

	}

	private static void question4() {
		Xylophone[] xylophones = new Xylophone[5]; // (A)
		Percussion[] xylophones1 = new Xylophone[5]; // (B)
		Xylophone x1 = new Xylophone("xylophone", 65, 32); // (C)
		System.out.println(x1.getNumKeys());

//		Xylophone x2 = new Xylophone ("xylophone", 65, 32);  // (D)
//		System.out.println(x2.numberOfKeys);

		Drums[] drums;
	}

	private static void question5() {
		Xylophone x2 = new Xylophone("xylophone", 80, 32);
		Xylophone x3 = new Xylophone("xylophone", 65, 32);

//		if (x2.weight==x3.weight) // (A)
//            System.out.println ("equally heavy") ; 
//        else
//            System.out.println ("not equally heavy");

//		if (x2.weight()==x3.weight()) // (B)
//            System.out.println ("equally heavy") ; 
//        else
//            System.out.println ("not equally heavy");

		if (x2.getWeight() == x3.getWeight()) // (C)
			System.out.println("equally heavy");
		else
			System.out.println("not equally heavy");

//		if (x2.weight.equals(x3.weight)) // (D)
//			System.out.println("equally heavy");
//		else
//			System.out.println("not equally heavy");
		
	}
}

class Percussion {
	private String name;
	private double weight;

	Percussion() {

	}

	Percussion(String n, double w) {
		name = n;
		weight = w;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}
}

class Drums extends Percussion {

}

class Xylophone extends Percussion {
	private int numberOfKeys;

	Xylophone(String name, double weight, int numberOfKeys) {
		// <missing code>
//		this.numberOfKeys = numberOfKeys; // (A)
//		super (name, weight);

		super(name, weight); // (B)
		this.numberOfKeys = numberOfKeys;

//		super (name, weight);  // (C)
//		numberOfKeys = this.numberOfKeys;

//		this.numberOfKeys = numberOfKeys; // (D)

//		numberOfKeys = this.numberOfKeys; // (E)
	}

	public int getNumKeys() {
		return numberOfKeys;
	}
}
