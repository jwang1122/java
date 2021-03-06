package com.huaxia.apcomputer;

public class PassByReference {

	public static void main(String[] args) {
		PassByReference test = new PassByReference();
		int x = 3;
		int y = 4;
		test.swap(x, y); // pass by value, no effect on original variables
		System.out.printf("x=%d\n", x);
		System.out.printf("y=%d\n", y);

		Student s1 = new Student("John", 12);
		Student s2 = new Student("Helen", 11);
		test.swap(s1, s2);
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);

		test.swapStudents(s1, s2);
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		
		int num = 6;
		increment(num); // pass by value
		System.out.println(num);
		
		System.out.println("s1: " + s1);
		incrementAge(s1); // pass by reference
		System.out.println("Student age increase by 1.");
		System.out.println("s1: " + s1);		
	}
	
	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public void swap(Student s1, Student s2) {
		Student temp = s1;
		s1 = s2;
		s2 = temp;
	}

	public void swapStudents(Student s1, Student s2) {
		Student temp = new Student(s1.name, s1.age);
		s1.name = s2.name;
		s1.age = s2.age;
		s2.name = temp.name;
		s2.age = temp.age;
	}

	public static void increment(int n) {
		n++;
	}
	
	public static void incrementAge(Student s) {
		s.age++;
	}
}

class Student {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return "(" + name + ", " + age + ")";			
	}
}
