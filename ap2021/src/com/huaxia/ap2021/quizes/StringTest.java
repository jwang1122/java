package com.huaxia.ap2021.quizes;

public class StringTest {
	int a = 5;
	String name = "John";
	
	int add(int a, int b) { // signature of method, finger print
		return a + b;
	}
	
	double add(double a, double b) { // method overloading
		return a + b;
	}
	
	double add(double a, double b, int x) { // method overloading
		return a + b;
	}

	void printName(StringTest st) {
		st.name = "Wang";
	}
	
	public static void main(String[] args) {
		StringTest st = new StringTest();
		st.printName(st);

	}

}
