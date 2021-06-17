package com.huaxia.java1;

public class Operator {

	public static void main(String[] args) {
		// arithmetic operator +, -, *, /, %
		double a, b, c;
		a = 5;
		b = 6;
		c = a + b;
		c = a - b;
		c = a * b;
		c = a / b;
		System.out.println(c);
		c = a % b;
		System.out.println(c);
		
		// binary assignment operator: +=, -=, *=, /=, %= 
		double d = 3.14;
		d += a; // same as d = d + a;
		System.out.println(d);
		
		// binary operator: ++, --,
		int i = 0;
		a += i++;
		a += i++;
		i--;
		++i;
		a += ++i;
		--i;
		a += --i;
		
		// comparison operator: >, <, >=, <=, ==
		boolean f = a > b;
		System.out.println(f);
//		String s1 = "John";
//		String s2 = "John";
		String s1 = new String("John");
		String s2 = new String("John");
		f = (s1 == s2); // it is ok: f=s1==s2;
		System.out.println(f);
	}

}
