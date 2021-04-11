package com.huaxia.ap2021.section2;

/**
 * @see SeatingChart (main())
 * 
 * Solution for the question: C:\Users\12818\workspace\apcomputer\exams\sectionII-04.md
 *
 * 
 * @author John
 *
 */
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
