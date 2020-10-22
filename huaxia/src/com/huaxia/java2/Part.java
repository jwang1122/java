package com.huaxia.java2;

public class Part {
	private String name;
	private String id;
	private String make;
	private String model;
	private String year;

	public Part(String[] line) {
		int length = line.length;
		this.make = line[length - 3];
		this.model = line[length - 2];
		this.year = line[length - 1];
		this.id = line[length - 4];
		if (length % 2 == 0) {
			String s1 = line[0];
			String s2 = line[1];
			String s = s1 + " " + s2;
			this.name = s;
		} else
			this.name = line[0];
	}

	/*
	class Sortbyname implements Comparator<Part> 
	{ 
	    
	    public int compare(Part a, Part b) 
	    { 
	        return a.make.compareTo(b.make); 
	    } 
	} 
	*/
	public String toString() {
		return make + " " + model + " " + year + " " + name + " " + id;
	}
}
