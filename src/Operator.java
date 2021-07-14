package com.huaxia.java1;

public class Operator {

	public static void main(String[] args) {
		// arithmetic operator +, -, *, /, % mod or remainder
		int a, b, c;
		a = 5;
		b = 6;
		c = a + b;
		c = a - b;
		c = a * b;
		c = a / b;
		System.out.println(c);
		c = a % b;
		System.out.println(c);
		
		// compound assignment operator: +=, -=, *=, /=, %= 
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
		
		// comparison operator: >, <, >=, <=, ==, !=
		boolean f = a > b;
//		System.out.println(f);
		String s1 = "John";
		String s2 = "Wang"; // check the object id for s1 and s2
//		String s1 = new String("John");
//		String s2 = new String("John");
//		f = (s1 == s2); // it is ok: f=s1==s2; // = has lowest priority
//		f = s1.equals(s2);
//		System.out.println(f);
		
		// logical operator: && and, || or, ! not
		int x = 5;
		// if both side of && are true, && return true
		f = x>6 && x<10; // priority of operator: comparison first, then logicl, assignment =
		// if one side of || is true, || return true
		f = x>6 || x<4;
		// ! operator reverse the comparison result
		f = !(x>6);
		System.out.println(f);
		
		// ternary operator
		x = a<b?a:b;
		System.out.println(x);

		// bitwise operator
	}

}
