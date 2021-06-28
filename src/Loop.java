package com.huaxia.java1;

public class Loop {

	public static void main(String[] args) {
		// for loop syntax, i is defined within for loop scope
		for (int i=2; i<=10; i+=2) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		// for loop with neigative step
		int i = 10;
		for (;i>0; i--) { // initialize looping variable; condition on looping variable; adjust looping variable
			System.out.print(i + ", ");
//			if(i==10) break;
		}
		System.out.println("\nAfter the for loop, i = "+i);
		
		String[] cars = {"Volvo","BMW","Ford","Mazda"};
		for(String car: cars) { // for each loop
			System.out.println(car);
		}
		
	}

}
