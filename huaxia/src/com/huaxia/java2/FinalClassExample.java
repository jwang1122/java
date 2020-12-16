package com.huaxia.java2;

class A {
	void printmsg() {
		System.out.println("Base class method is executed.");
	}
}

//derived class  
//extending a final class which is not possible   
//it shows the error cannot inherit final class at compile time   
final class B extends A {
	void printmsg() {
		System.out.println("Derived class method is executed.");
	}
}

//main class  
public class FinalClassExample {
	public static void main(String[] arg) {
		A objectA = new A();
		objectA.printmsg();
		B objectB = new B();
		objectB.printmsg();
	}
}