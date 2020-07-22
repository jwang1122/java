package com.huaxia.john;

public class Math1 {
	public int add(int x, int y) {
		return x + y;
	}
	public int sub(int x, int y) {
		return x - y;
	}
	public int mul(int x, int y) {
		return x * y;
	}
	public int div(int x, int y) {
		return x / y;
	}
	
	public double add(double x, double y) {
		return x + y;
	}


	public static void main(String[] args) {
		Math1 m = new Math1();
		m.testAdd();
	}
	
	private void testAdd() {
		int x = add(10,20);
		System.out.println(x);
		double y = add(10.2, 11.3);
		System.out.println(y);		
	}
}
