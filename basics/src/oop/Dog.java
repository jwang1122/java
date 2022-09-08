package oop;

public class Dog extends Pet {
	Dog() { // default constructor
		
	}
	
	public Dog(String name, int age) {  // 4 modifier: public, protected, default, private
		this.name = name;
		this.age = age;
	}

	@Override
	public String speak() { 
		return "Wown, Wown, Wown...";
	}
	
	public int add(int a, int b) {
		return a + b;
	}
}
