package com.huaxia.java1;

public class Loop {

	static void forLoopTest() {
		// for loop
		int[] a = {1,3,5,4,86,34};
		for (int i=0; i<a.length; i++) { // 1. initial index; 2. loop condition; 3. adjust index
			if(i<2) continue;
			System.out.println(i + ": " + a[i]); // get individual value of array by index
			if(i==3) break;
		}		
	}
	
	static void forEachTest() {
		// for-each
		String[] carType = {"Vovl", "BMW", "TOYOTA","FORD"};
		for(String type: carType) { // for-each has no loop index
			if(type.equals("TOYOTA")) break;
			System.out.println(type);
		}		
	}
	
	static void whileLoopTest() {
		// while loop
		int a = 15;
		while(a<10) { // check condition first and then do the loop
			System.out.println(a);
			a++; // adjust your condition variable towards the condition to be false
		}
		
	}
	public static void main(String[] args) {
		whileLoopTest();
		// do-while loop
		int a = 15;
		do {          // do-while will run the code body at least once.
			System.out.println(a++);
		}while(a<10); // check the condition last
		
		System.out.println("\nDone.");
	}

}
