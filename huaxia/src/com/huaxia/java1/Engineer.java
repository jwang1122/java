package com.huaxia.java1;

public class Engineer implements Occupation {
	private String name;
	
	Engineer(String name){
		this.name = name;
	}
	@Override
	public String getOccupation() {
		// TODO Auto-generated method stub
		return "Engineer";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
