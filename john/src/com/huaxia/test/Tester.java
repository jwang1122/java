package com.huaxia.test;

import com.huaxia.john.Math1;
import com.huaxia.john.Person;
import com.huaxia.john.Student;

public class Tester {

	public static void main(String[] args) {
		Person p1 = new Person("John","999-99-9999", 'm', 18);
		System.out.println(p1);
		System.out.println(p1.getName());
		Student s1 = new Student("Student1","999-99-9999", 'm', 18);
		System.out.println(s1);
		Math1 math = new Math1();
		int z = math.add(10, 30);
		System.out.println("10+30=" + z);
		z = math.mul(10, 30);
		System.out.println("10*30=" + z);
	}

}
