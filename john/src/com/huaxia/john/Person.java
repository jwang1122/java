package com.huaxia.john;

public class Person {
	protected String name;
	protected String ssn;
	protected char gender;
	protected int age;

	public Person() {
		
	}
	public Person(String name, String ssn, char gender, int age) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
