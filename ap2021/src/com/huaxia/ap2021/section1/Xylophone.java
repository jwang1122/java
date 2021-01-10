package com.huaxia.ap2021.section1;

public class Xylophone extends Percussion{
	private int numberOfKeys; 
	Xylophone (String name, double weight, int numberOfKeys) {
		//<missing code>
//		this.numberOfKeys = numberOfKeys;
//		super (name, weight);

		super (name, weight);
		this.numberOfKeys = numberOfKeys;

//		super (name, weight);
//		numberOfKeys = this.numberOfKeys;
//
//		this.numberOfKeys = numberOfKeys;
//
//		numberOfKeys = this.numberOfKeys;		
	}
	
	public int getNumKeys() {
		return numberOfKeys;
	}

	public static void main(String[] args) {
		Xylophone test = new Xylophone("John", 157.5, 3);
		System.out.println(test.getName());
		System.out.println(test.getWeight());
		System.out.println(test.getNumKeys());
	}

}
