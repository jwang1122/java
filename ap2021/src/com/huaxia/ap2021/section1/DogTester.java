package com.huaxia.ap2021.section1;

public class DogTester {
	public static void main(String[] args) {
		Dog d1 = new SportingDog (30 , 74 , "Black");
		Dog d2 = new Retriever("Labrador", "Yellow", 75); 
		SportingDog d3 = new Retriever ("Golden", "Red", 70); 
//		SportingDog d4 = new Dog (25, 80, "Bed");
		Retriever d5 = new Retriever ("Golden", "Blonde", 60 ); 
		
		Dog mason = new Retriever ("Labrador", "chocolate", 85);
		System.out.println (mason.toString());
	}
}
