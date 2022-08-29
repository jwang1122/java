package builtins;

import java.util.Stack;

import linkedlist.Person;

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

