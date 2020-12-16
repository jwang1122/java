package com.huaxia.java2;

//Concrete Class  
public class ConcreteClassExample {
//method of the concreted class  
	static int product(int a, int b) {
		return a * b;
	}

	public static void main(String args[]) {
//method calling      
		int p = product(6, 8);
		System.out.println("Product of a and b is: " + p);
	}
}