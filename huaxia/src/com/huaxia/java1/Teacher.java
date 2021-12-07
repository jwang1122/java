package com.huaxia.java1;

public class Teacher implements Occupation {
	private String id;
	private String firstName;
	private String lastName;
	private String ssn;
	
	public Teacher() {
		
	}
	
	public Teacher(String id, String firstName, String lastName, String ssn) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	@Override
	public String getOccupation() {
		// TODO Auto-generated method stub
		return "Teacher";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
