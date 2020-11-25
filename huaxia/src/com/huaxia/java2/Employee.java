package com.huaxia.java2;

public class Employee {
	String organizationId;
	String name;
	int age;
	String team;
	
	public Employee(String organizationId, String team, String name, int age) {
		this.organizationId = organizationId;
		this.team = team;
		this.name = name;
		this.age = age;
	}
}
