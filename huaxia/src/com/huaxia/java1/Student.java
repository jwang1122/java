package com.huaxia.java1;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
	int id;
	String firstName;
	String lastName;
	int score;
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Student(int id, String firstName, String lastName, int score) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}
	
	public static float average(ArrayList<Student> list) {
		float sum = 0;
		for(Student s: list) {
			sum += s.score;
		}
		return (float)sum/list.size();
	}
	
	@Override
	public int compareTo(Student other) {
		return this.id < other.id ? -1: this.id == other.id ? 0 :1;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + "]";
	}

}
