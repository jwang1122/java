package languagebasics.operators;

import languagebasics.datatype.DataType;

public class Operators {
	
	public static void main(String[] args) {
//		arithmeticOps();
//		comparisonOps();
		bitwiseOperator();
	}

	
	static void arithmeticOps() {
		// arithmetic operators +, -, *, /, % (mod or remainder)
		int a, b, c;
		a = 5;
		b = 7;
		c = b % a;   // int/int return an int
//		double d = (double)b/a; // double/int return double; double/double return doulbe; int/double return double
		System.out.println(c);		
	}

	static void assignmentOps() {
		int d =5;
		// compound assignment operators: =, +=, -=, *=, /*, %=
		d += 1; // d = d + 1;
		d -= 3; // d = d - 3
		d *= 1.2;
		d /= 3.4;
		d %= 2;
		System.out.println(d);
	}
	
	
	static void binaryOps() {
		int a = 4;
		// binary operator: ++, --
		int i = 0;
//		a = i++; // i assign to a first, and then increase by 1
		a = ++i; // i increase by 1 first, and then assign to a
		System.out.println("a="+a);
		System.out.println("i="+i);
		a = --i;
		System.out.println("a="+a);
		System.out.println("i="+i);
	
	}
	
	static void comparisonOps() {
		// comparison operator: <, >, <=, >=, ==, !=
		// returns true or false can be used for if or else if condition check
		int a = 0;
		int b = 7;
		System.out.println(a>b);
		System.out.println(a<b);
		System.out.println(a>=b);
		System.out.println(a<=b);
		System.out.println(a==b);
		System.out.println(a!=b);
		if(a>b) System.out.printf("%d is greater than %d.\n", a, b);
		else System.out.printf("%d is less than %d.\n", a, b);
		
		String s1 = "Hello";
		String s2 = "Hello";
		System.out.println(s1==s2);
		System.out.println(s1!=s2);
		
		char f = 'F';
		char w = 'W';
		System.out.println(f<w);
		System.out.printf("The letter %s(%d) is less than letter %s(%d)\n",f,(int)f,w,(int)w);
		
		DataType type1 = new DataType();
		DataType type2 = new DataType();
		DataType type3 = type1;
		System.out.printf("Is type1 and type2 the same? %s\n",type1==type2);
		System.out.printf("Is type1 and type3 the same? %s\n",type1==type3);
	}
	
	static void logicalOps() {
		int a=0, b=7;
		// logical operator: && and, || or, ! not; 
		boolean x = a==0 && b>7; // will return true or false. && return true if both side are true
		System.out.println(x);
		
		x = a==0 || b>7; // || return true if one side is true
		System.out.println(x);
		
	}
	
	static void ternaryOps() {
		// ternary operator: combination of ? and :, which separate the expression into 3 parts
		
		int a = 5, b=16;
		int min = a<b?a:b;
		System.out.println(min);
		int max = a>b?a:b;
		System.out.println(max);		
	}
	
	public static void bitwiseOperator() {
		// bitwise operator:
		// &: bitwise and
		// |: bitwise or
		// ^: bitwise xor
		// ~: bitwise compliment
		
		byte b1 = 0b00111100;
		byte b2 = 0b00001101;
		byte b3 = (byte)(b1 & b2);
		System.out.println(b3);
		byte b4 = 0b00001100;
		System.out.println(b4);
		System.out.println(b3==b4);
		byte b5 = 0b00111101;
		byte b6 = (byte)(b1 | b2);
		byte b7 = 0b0000_1000;
		byte b8 = (byte)2;
		byte b9 = (byte)-2;
		byte b10 = (byte)(b8 + b9);
		System.out.println(b5==b6);
		System.out.println(formatByte(b1));
		System.out.println(formatByte(b2));
		System.out.println(formatByte(b6));
		System.out.println(formatByte(b5));		
		System.out.println(formatByte(b7));
		System.out.println(formatByte(b8));		
		System.out.println(formatByte(b9));		
		System.out.println(formatByte(b10));		
	}
	

	static String formatByte(byte b) {
		String s = String.format("%32s", Integer.toBinaryString(b));
		return s.replace(' ', '0');
	}

}
