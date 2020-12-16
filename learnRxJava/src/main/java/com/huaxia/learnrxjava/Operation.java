package com.huaxia.learnrxjava;

//abstract class  
abstract class MathematicalOperations {
	int a = 30, b = 40;

//abstract method  
	public abstract void add();
	public int sub(int x, int y) {
		return x-y;
	}
}

public class Operation extends MathematicalOperations {
//definition of abstract method       
	public void add() {
		System.out.println("Sum of a and b is: " + (a + b));
	}

	public static void main(String args[]) {
		MathematicalOperations obj = new Operation();
		obj.add();
		System.out.println(obj.sub(10, 3));
		System.out.printf("10 - 3 = %d\n",obj.sub(10, 3));
	}
}