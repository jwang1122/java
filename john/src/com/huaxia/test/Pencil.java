package com.huaxia.test;

public class Pencil {
	String type;
	double price;
	String color;
	
	//Constructor
	Pencil(String type, double price){
		this.type = type;
		this.price = price;
	}

	public Pencil() {
	}

	@Override
	public String toString() {
		return "Pencil [type=" + type + ", price=$" + price + "]";
	}

	public static void main(String[] args) {
		Pencil p1 = new Pencil("No.2", .2);
		System.out.println(p1);
		Pencil p2 = new Pencil();
		p2.setType("HB");
		p2.setPrice(.25);
		p2.setColor("yellow");
		System.out.println(p2);
		System.out.println(p2.getColor());
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
