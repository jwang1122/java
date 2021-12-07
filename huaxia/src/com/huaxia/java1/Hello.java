package com.huaxia.java1;

public class Hello {
	private String name;
	Hello(String name){
		this.name = name;
	}
	public static void main(String[] args) {
		System.out.println("Hello, World!");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
