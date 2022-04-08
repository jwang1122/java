package com.huaxia.ap2021.section1;

import java.util.Arrays;

public class PassByReference {

	public static void main(String[] args) {
		PassByReference test = new PassByReference();
		int x = 3;
		int y = 4;
		System.out.printf("Before int switch: x=%d, y=%d\n", x, y);
		test.switchInt(x, y); // pass by value, no effect on original variables
		System.out.printf("After int switch: x=%d, y=%d\n", x, y);

		Student s1 = new Student("John", 12);
		Student s2 = new Student("Helen", 11);
		System.out.printf("Before object switch: student1: %s, student2: %s\n", s1, s2);
		test.switchStudent(s1, s2);
		System.out.printf("After object switch: student1: %s, student2: %s\n\n", s1, s2);

		System.out.printf("Before object switch: student1: %s, student2: %s\n", s1, s2);
		test.switchStudent(s1, s2, true);
		System.out.printf("After object switch: student1: %s, student2: %s\n\n", s1, s2);

		int num = 6;
		increment(num); // pass by value
		System.out.println(num);

		System.out.println("s1: " + s1);
		incrementAge(s1); // pass by reference
		System.out.println("Student age increase by 1.");
		System.out.println("s1: " + s1);
		System.out.println();
		
		int[] a1= {1,2,3};
		int[] a2= {4,5,6};
		System.out.printf("Before switch array: %s; %s\n", Arrays.toString(a1), Arrays.toString(a2));
		test.switchArray(a1, a2, false);
		System.out.printf("After switch array: %s; %s\n\n", Arrays.toString(a1), Arrays.toString(a2));
		
		System.out.printf("Before switch array: %s; %s\n", Arrays.toString(a1), Arrays.toString(a2));
		test.switchArray(a1, a2, true);
		System.out.printf("After switch array: %s; %s\n", Arrays.toString(a1), Arrays.toString(a2));
	}

	public void switchInt(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public void switchStudent(Student s1, Student s2) {
		Student temp = s1;
		s1 = s2;
		s2 = temp;
	}

	public void switchStudent(Student s1, Student s2, boolean flag) {
		Student temp = new Student(s1.name, s1.age);
		s1.name = s2.name;
		s1.age = s2.age;
		s2.name = temp.name;
		s2.age = temp.age;
	}

	public void switchArray(int[] a1, int[] a2, boolean flag) {
		if (flag) {
			for(int i=0; i<a1.length; i++) {
				int tmp = a1[i];
				a1[i] = a2[i];  // content changes!!!
				a2[i] = tmp;   
			}
		} else {
			int[] tmp = a1;  // referenct changes
			a1 = a2;
			a2 = tmp;
		}
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
