package com.huaxia.java2;

public class Enum1 {
	Weekdays day;

	public Enum1(Weekdays day) {
		this.day = day;
	}

	public void tellItLikeItIs() {
		switch (day) { // use enum for switch key
		case MONDAY:
			System.out.println("Mondays are bad.");
			break;

		case FRIDAY:
			System.out.println("Fridays are better.");
			break;

		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			break;

		default:
			System.out.println("Midweek days are so-so.");
			break;
		}
	}

	public static void main(String[] args) {
		System.out.println("Lazy boy's thoughts: ");
		Enum1 firstDay = new Enum1(Weekdays.MONDAY);
		firstDay.tellItLikeItIs();
		Enum1 thirdDay = new Enum1(Weekdays.WEDNESDAY);
		thirdDay.tellItLikeItIs();
		Enum1 fifthDay = new Enum1(Weekdays.FRIDAY);
		fifthDay.tellItLikeItIs();
		Enum1 sixthDay = new Enum1(Weekdays.SATURDAY);
		sixthDay.tellItLikeItIs();
		Enum1 seventhDay = new Enum1(Weekdays.SUNDAY);
		seventhDay.tellItLikeItIs();
	}
}
