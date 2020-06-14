package com.huaxia.test;

public class SuperClass1 {

	String name ="";

	// default constructor
	SuperClass1(){
		
	}
	
	// constructor
	SuperClass1(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			SuperClass1 c1 = new SuperClass1("John");
			System.out.println(i);
			System.out.println(c1);
			System.out.println("My Name is " + c1.getName());
			System.out.println();
		}
		SuperClass1 c1 = new SuperClass1("Wang");
		System.out.println(c1.getName());
		c1.setName("Collin");
		System.out.println(c1.getName());
		c1 = new SuperClass1();
		c1.setName("Patrick");
		System.out.println(c1.getName());
		
		
	}
}
