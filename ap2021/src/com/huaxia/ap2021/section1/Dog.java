package com.huaxia.ap2021.section1;

public class Dog {
	private int height; 
	private String size; 
	private String color; 
	Dog (int iheight, int iweight, String icolor) {
		height = iheight; 
		color = icolor;
		if (iweight >= 65)
			size = "large" ; 
		else 
			size = "medium" ;
	}
	public int getHeight() { return height; } 
	public String getSize() { return size;}
	public String getColor() {return color; } 
	public String toString () {return "        color is: "+ color;}
}
