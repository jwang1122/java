package com.huaxia.ap2021.section2;

import java.util.ArrayList;

public class TravelPlan {
	String destination;
	private ArrayList<Tour> plans;

	/** Constructs a Tour 
	 * Instance fields : destination and plans are initialized 
	 */
	TravelPlan(String destination) {
		this.destination = destination;
		plans = new ArrayList<Tour>(); //very important, purpose of test
	}

	/** Returns true if the timeframe in t overlaps with another Tour in plans;
	 * otherwise false
	 */
	public boolean checkForConflicts(Tour t) {
		boolean result = false;
		int actDate = t.getActDate();
		int startTime = t.getStartTime();
		int endTime = t.getEndTime();
		for (Tour other : plans) {
			if (actDate == other.getActDate()) {
				//
				int otherStart = other.getStartTime();
				int otherEnd = other.getEndTime();
				if (startTime < otherStart && endTime > otherStart && endTime < otherEnd)
					return true;
				if (startTime > otherStart && startTime < otherEnd && endTime > otherEnd)
					return true;
				if (startTime > otherStart && startTime < otherEnd && endTime > otherStart && endTime < otherEnd)
					return true;
			}
		}
		return result;
	}

	/** Must call checkForConflicts for full credit, if checkForConflicts returns false
	 * (the timeframe does not overlap), adds t to plans. Returns true if
	 * t was added, otherwise returns false 
	 */
	public boolean addTour(Tour t) {
		if (!checkForConflicts(t)) {
			plans.add(t);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TravelPlan p1 = new TravelPlan("Capetown");
		Tour t1 = new Tour(12132020,800,1230,"Bungee jumping");
		Tour t2 = new Tour(12132020,900,1430,"Body surfing"	);
		System.out.println(p1.addTour(t1));
		System.out.println(p1.addTour(t2));
		Tour t3 = new Tour(12132020,1400,1700,"Shark cage diving");
		System.out.println(p1.addTour(t3));
		Tour t4 = new Tour (1222020,800,1700,"Deep sea fishing");
		System.out.println(p1.addTour(t4));
	}
}
