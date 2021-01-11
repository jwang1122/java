package com.huaxia.ap2021.section2;

public class Name {
	private String lastName; 
	private String firstName; 
	
	Name (String lName, String fName) {
		lastName = lName.trim();
		firstName = fName.trim();
	}
	public String getLastName(){return lastName; }
	public String getFirstName(){ return firstName; } 
	public String toString() {
		return lastName + ", " + firstName;
	}
}
