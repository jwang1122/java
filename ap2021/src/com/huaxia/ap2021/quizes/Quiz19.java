package com.huaxia.ap2021.quizes;

public class Quiz19 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		ClassOne c1 = new ClassOne();
		ClassOne c2 = new ClassTwo();
//		c1.methodTwo();
//		c2.methodTwo();
		c2.methodOne();
	}

	private static void question2() {
		System.out.println("question 2...");
		ifelseif(1, 1);
		ifonly(1, 1);
		ifelseif(4, 1);
		ifonly(4, 1);
	}

	static void ifelseif(int n, int k) {
		if (n == 1)
			k++;
		else if (n == 4)
			k += 4;
		System.out.println(k);
	}

	static void ifonly(int n, int k) {
		if (n == 1 || n == 4)
			k += n;
		System.out.println(k);
	}

	private static void question3() {
		System.out.println("question 3...");
		String s = "holy";
		String t = s.substring(4);
		System.out.println("[" + t + "]");
	}

	private static void question4() {
		System.out.println("quesion 4...");
		double a = 1.123;
		double b = 2.211;
		double c = a*a + b*b;
		System.out.println(c);
		boolean flag = isPythTriple(a, b, c);
		System.out.println(flag);
	}

	public static boolean isPythTriple(double a, double b, double c) {
		double d = a * a + b * b;
		System.out.println(d);
		return d == c;
	}

	private static void question5() {
		System.out.println("question 5...");
		int[] arr = {7, 2, 3};
		SomeClass test = new SomeClass(arr);
		int result = test.mystery();
		System.out.println(result);
	}

}

class ClassOne {
	public void methodOne() {
		System.out.println("methodOne()...");
	}

	// other methods not shown
}

class ClassTwo extends ClassOne {
	public void methodTwo() {
		System.out.println("methodTwo()...");
	}
	// other methods not shown
}

class SomeClass 
{
    private int [] arr; 

    //Constructor. Initializes arr to contain nonnegative 
    // integers k such that 0 <= k <= 9.
    public SomeClass(int[] arr)
    { /* implementation not shown */ 
    	this.arr = arr;
    } 

    public int mystery() 
    {
        int value = arr[0];
        for (int i = 1; i< arr.length; i++)
            value = value * 10 + arr [i] ; 
        return value; 
    }
}