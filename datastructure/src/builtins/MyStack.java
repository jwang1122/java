package builtins;

import java.util.Stack;

public class MyStack {

	public static void main(String[] args) {
		Stack<Person> s1 = new Stack<>();
		s1.add(new Person("John")); //first-in-last-out
		s1.add(new Person("David"));
		s1.add(new Person("Andrew"));
		s1.add(new Person("Samuel"));
		System.out.println(s1);
		System.out.println(s1.empty());
		System.out.println(s1.pop());
		System.out.println(s1);
	}

}

class Person{
	String name;
	public Person(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
}