package com.huaxia.java1;

import com.huaxia.java1.Engineer;
import com.huaxia.java1.Occupation;
import com.huaxia.java1.Teacher;

import languagebasics.control.Hello;

public class Test {

	static void testHello() {
		Hello h = new Hello("John");
		System.out.println(h);		
	}
	
	static void printOccupation(Occupation obj) { //polymorphism: same method do the job in different ways based on the object data type.
		System.out.println(obj.getOccupation());
	}
	
	public static void main(String[] args) {
		Occupation person = new Engineer("eng-1"); // Person class implements Occupation interface
		printOccupation(person );
		Occupation teacher = new Teacher("teacher-1","John","Wang","111-11-1111");
		printOccupation(teacher);
		System.out.println("Done.");
	}

}
