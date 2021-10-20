package com.huaxia.john;

import java.util.ArrayList;

public class Teacher implements GetInfo {
	String name;
	
	
	public Teacher(String name) {
		super();
		this.name = name;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Teacher: " + name;
	}
	
	public void assignHomework(ArrayList<Student> students) {
		
	}

}
