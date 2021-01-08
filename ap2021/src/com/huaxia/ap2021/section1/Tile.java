package com.huaxia.ap2021.section1;

public class Tile {
	private int styleNumber;
	private String color;
	private double width;
	private double height;
	private String material;
	private double price;
	
	Tile(int style, String col){
		styleNumber = style;
		color = col;
	}
	
	Tile(int style, String col, double w, double h, String mat, double price){
		styleNumber = style;
		color = col;
		width = w;
		height = h;
		material = mat;
		price =price;
	}
	
	Tile(int style, String col, String mat, double price){
		styleNumber = style;
		color = col;
		material = mat;
		price =price;		
	}
	
	public void chgMaterial(String mat) {
		String material = mat;
	}
	
	public String toString() {
		return (styleNumber + " " + color + " " + width + " " + height + " " + material + " " + price);
	}

	public static void main(String[] args) {
		//Question 18
		Tile t1 = new Tile(785, "grey", "ceramic", 6.95);
		t1.chgMaterial("marble");
		System.out.println(t1.toString());

		// Question 19.
		Tile t2 = new Tile(101, "blue");
		System.out.print(t2);

	}

}
