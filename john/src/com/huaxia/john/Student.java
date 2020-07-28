package com.huaxia.john;

public class Student extends Person implements Comparable{

	private int id;
	private String firstName;
	private String lastName;
	private int score;
	
	public Student(String name, String ssn, char gender, int age) {
		super(name, ssn, gender, age);
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String firstName, String lastName, int score) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = firstName + " " + lastName;
		this.score = score;
	}

	public void doHomework() {
		System.out.println(this.name + ": I am doing my homework...");
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", ID:" + id + "]";
	}

	@Override
	public int compareTo(Object o) {
		Student other = (Student)o;
		int otherId = other.getId();
		if( this.id > otherId)
			return 1;
		if(this.id < otherId)
			return -1;					
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
