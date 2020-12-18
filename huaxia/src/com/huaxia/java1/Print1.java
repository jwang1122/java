package com.huaxia.java1;

public class Print1 {

	public static void main(String[] args) {
		Print1 test = new Print1();
		test.basicPrint();
	}

	void basicPrint() {
		String name = "John";
		String sf1 = String.format("name is %s.", name);
		String sf2 = String.format("value is %f.", 3.1415926);
		String sf3 = String.format("value is %5.3f.", 3.1415926);
		System.out.println(sf1);
		System.out.println(sf2);
		System.out.println(sf3);
		System.out.println("2020-20=" + (2020 - 20));// bad practice, hardcode everything!
		int a = 2040;
		int b = 20;
		sf1 = String.format("2020-20=%d", (2020 - 20));
		System.out.println(sf1);
		sf1 = String.format("%d-%d=%d", a, b, (a - b));
		System.out.println(sf1);
		System.out.printf("%d+%d=%d", a,b,(a+b));
		System.out.println();
	}

	
}
