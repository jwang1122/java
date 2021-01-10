package com.huaxia.ap2021.section1;

public class SportingDog extends Dog {
	private String purpose; 
	SportingDog (int h, int w, String c) {
		super (h, w, c);
		purpose = "hunting";
	}
	public String getPurpose() {
		return purpose;
	}
	
}
