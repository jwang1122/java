package com.huaxia.ap2021.section2;

public class Tour {
	private int actDate;// date is in mwddyyyy format 
	private int startTime; // times are represented in military format 
	private int endTime; // 1430 for 2:30 pm
	private String activity; 
	
	/** constructs a Tour 
	 * All instance fields are initialized 
	 */
	Tour (int actDate, int startTime, int endTime, String activity) 
	{
		// implementation not shown 
	}
	public int getActDate()	{ return actDate; } 
	public int getStartTime () { return startTime;} 
	public int getEndTime (){ return endTime; } 
	public String getActivity(){ return activity;} 
	
}
