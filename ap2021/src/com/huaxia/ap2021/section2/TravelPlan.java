package com.huaxia.ap2021.section2;

import java.util.ArrayList;

public class TravelPlan {
	private String destination; 
	private ArrayList <Tour> plans; 
	
	/** Constructs a Tour 
	 * Instance fields : destination and plans are initialized 
	 */
	TravelPlan (String destination) 
	{
		/* to be implemented in part (a)	*/ 
	}
	/** Returns true if the timeframe in t overlaps with another Tour in plans;
	 * otherwise false
	 */
	public boolean checkForConflicts (Tour t) 
	{
		/* to be implemented in part(b) */ 
	}
	
	/** Must call checkForConflicts for full credit, if checkForConflicts returns false
	 * (the timeframe does not overlap), adds t to plans. Returns true if
	 * t was added, otherwise returns false 
	 */
	public boolean addTour(Tour t) 
	{
		/* to be implemented in part(c) */ 
	}
}
