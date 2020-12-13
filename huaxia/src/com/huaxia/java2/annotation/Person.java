package com.huaxia.java2.annotation;

// https://www.baeldung.com/java-custom-annotation

@JsonSerializable
public class Person {

	Person(String first, String last, String age) {
		this.firstName = first;
		this.lastName = last;
		this.age = age;
	}

	@JsonElement()
	private String firstName;

	@JsonElement()
	private String lastName;

	@JsonElement(key = "personAge")
	private String age;

	String address;

	@Init
	private void initNames() {
		this.firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
		this.lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
