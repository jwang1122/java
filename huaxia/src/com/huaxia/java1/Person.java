package com.huaxia.java1;

public abstract class Person extends Object implements Occupation{ // developer defined data type
	protected String firstName; // all protected fields can be used in its subclass.
	protected String lastName;  // attribute, field, variable of a class
	protected int age;
	protected String gender;
	protected String ssn;
	
	public abstract double add(double x, double y);
	
	public String getFirstName() { // getter/assessor
		return firstName;
	}
	public void setFirstName(String firstName) { //setter/mutator
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	// if you override toString() method defined in Object class, 
	// whenever you print out this object, JVM will call the toString() below
	@Override
	public String toString() { 
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	@Override
	public String getOccupation() {
		// TODO Auto-generated method stub
		return "Person";
	}
	
}
