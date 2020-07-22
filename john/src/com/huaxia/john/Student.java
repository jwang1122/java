package com.huaxia.john;

public class Student extends Person {

	public Student(String name, String ssn, char gender, int age) {
		super(name, ssn, gender, age);
		// TODO Auto-generated constructor stub
	}

	public void doHomework() {
		System.out.println(this.name + ": I am doing my homework...");
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}


}
