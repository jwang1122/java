package com.huaxia.datastructure;

public interface Occupation { // define common task for different classes
	double pi = 3.1415926;
	enum OCCUP {TEACHER, DEVELOPER, ENGINEER, DOCTOR};
	
	public abstract String getOccuption(); // all methods in interface are public, abstract
}
