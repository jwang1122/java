package com.huaxia.ap2021.section1;

public class Constellation {
	private String name;
	private String month;
	private int northernLatitude;
	private int southernLatitude;
	
	
	public Constellation(String name, String month) {
		super();
		this.name = name;
		this.month = month;
		northernLatitude = 0;
		southernLatitude = 0;
	}
	
	public Constellation(String name, String month, int northernLatitude, int southernLatitude) {
		super();
		this.name = name;
		this.month = month;
		this.northernLatitude = northernLatitude;
		this.southernLatitude = southernLatitude;
	}

	public void chgMonth(String m) {
		String month = m;
	}

	public void chgLatitude(String direction, int latitude) {
		if(direction.toUpperCase().equals("N")) {
			this.northernLatitude = latitude;
		}else if(direction.toUpperCase().equals("S")) {
			this.southernLatitude = latitude;			
		}
	}

	public void chgLatitude(int northLatitude, int southLatitude) {
		this.northernLatitude = northLatitude;
		this.southernLatitude = southLatitude;			
}

	public void chgLatitude(double northLatitude, double southLatitude) {
			this.northernLatitude = (int)northLatitude;
			this.southernLatitude = (int)southLatitude;			
	}

	public static void main(String[] args) {
// Question 5
		Constellation c1 = new Constellation("Hercules", "July");
		Constellation c2 = new Constellation("Pisces", "Nov", 90, 65);
//		Constellation c3 = new Constellation("Aquarius", "Oct", 65.0, 9.0);
		Constellation c4 = new Constellation("Leo", "4", 0, 0);
		Constellation c5 = new Constellation("Phoenix", "Nov", 32, 90);

// Question 6
		c1.chgLatitude("N", 20);
		c1.chgLatitude(30,  35);
		c1.chgLatitude(23.5, 45.3);
	}

}
