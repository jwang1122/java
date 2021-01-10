package com.huaxia.ap2021.section1;

public class Retriever extends SportingDog {
	private String type;
	Retriever (String itype, String icolor, int iweight) {
		super(24, iweight, icolor); 
		type = itype; 
	}
	public String toString () {return "type: " + type + super.toString(); }
}
