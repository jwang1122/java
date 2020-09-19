package com.huaxia.john;

public class Dog {
	double weight;
	String color;
	String owner;
	
	public Dog(double weight, String color, String owner) {
		this.weight  = weight;
		this.color = color;
		this.owner = owner;
	}
	
	void bark() {
		System.out.println("woh!woh!woh!");
	}
	
	public static void main(String[] args) {
		Dog yellowDog = new Dog(25.5, "black", "John's");
		yellowDog.bark();
		System.out.println(yellowDog.color);
	}

}
