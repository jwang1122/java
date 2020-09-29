package com.huaxia.swing;

public class Student implements GetInfo {
	private String name;
	private GetInfo info;
	
	public Student(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

}
