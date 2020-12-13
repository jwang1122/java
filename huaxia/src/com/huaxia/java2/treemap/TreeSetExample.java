package com.huaxia.java2.treemap;

import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
//creating a TreeSet   
		TreeSet<String> ts = new TreeSet<String>();
//adding elements to TreeSet  
		ts.add("Dell");
		ts.add("HP");
		ts.add("Apple");
		ts.add("Acer");
		ts.add("Asus");
		ts.add("Lenovo");
		ts.add("Samsung");
//try to a duplicate element   
		ts.add("Asus");
//prints the TreeSet elements on the console  
		System.out.println("TreeSet elements are: ");
		for (String temp : ts) {
			System.out.println(temp);
		}
	}
}
