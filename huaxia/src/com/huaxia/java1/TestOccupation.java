package com.huaxia.java1;

public class TestOccupation {

	public static void whatIsYourOccupation(Occupation obj) {
		System.out.println(obj.getOccupation());
	}
	public static void main(String[] args) {
		Teacher t = new Teacher();
		whatIsYourOccupation(t);
		

	}

}
