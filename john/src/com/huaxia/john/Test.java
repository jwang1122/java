package com.huaxia.john;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person("John","999-99-9999", 'm', 18);
		System.out.println(p1.name);
		System.out.println(p1);
		Student s1 = new Student("Eric","999-99-9999", 'm', 18);
		s1.doHomework();
	}

}
