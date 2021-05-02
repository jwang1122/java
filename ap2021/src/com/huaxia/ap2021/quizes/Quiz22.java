package com.huaxia.ap2021.quizes;

public class Quiz22 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question1...");
		System.out.println("There are only 2 constructors in Time class, so (D) is false statement..");
		
	}

	private static void question2() {
		System.out.println("question2...");
		System.out.println("(B) is correcty constructor implementation.");
		
	}

	private static void question3() {
		System.out.println("question3...");
		Time t = new Time(3, 23, 12);
		t.display(t);
		
	}

	private static void question4() {
		System.out.println("question4...");
		System.out.println("(C) Two overloaded methods in the same class can have parameters with the same name. Only type and number of parameters matters.");
		Time t = new Time(3, 4, 23);
		t.resetTime(5, 10); // overloaded method with same parameter names
		System.out.println(t);
	}

	private static void question5() {
		System.out.println("question5...");
		System.out.println("(B) getPondTemerature() since it has nothing to do with the Frog.");
	}

}

class Time 
{
    private int myHrs; 
    private int myMins; 
    private int mySecs;

    public Time() 
    {/* implementation not shown*/ }

    public Time(int h, int m, int s) 
    { /* implementation not shown */ 
    	myHrs= h; 
        myMins= m;
        mySecs = s;
    }  

    //Resets time to myHrs = h, myMins = m, mySecs=s. 
    public void resetTime(int h, int m, int s) 
    { /* implementation not shown*/ 
    	myHrs = h;
    	myMins=m;
    	mySecs = s;
    } 

    public void resetTime(int h, int m) 
    { /* implementation not shown*/ 
    	myHrs = h;
    	myMins=m;
    } 
   //Advances time by one second. 
    public void increment ()
    { /* implementation not shown*/
    	mySecs += 1;
    	if(mySecs == 60) {
    		mySecs = 0;
    		myMins += 1;
    		if(myMins == 60) {
    			myMins = 0;
    			myHrs +=1;
    			if(myHrs==24) {
    				myHrs = 0;
    			}
    		}
    	}
    	
    } 

    //Returns true if this time equals t, false otherwise. 
    public boolean equals (Time t) 
    { /* implementation not shown */ 
    	return this.myHrs==t.myHrs && this.myMins==t.myMins && this.mySecs==t.mySecs;
    } 

    //Returns true if this time is earlier than t, false otherwise.
    public boolean lessThan (Time t)
    { /* implementation not shown*/ 
    	
    	if(myHrs<t.myHrs) {
    		return true;
    	}
    	if(myHrs==t.myHrs) {
    		if(myMins<t.myMins) {
    			return true;
    		}
    		if(myMins==t.myMins) {
    			if(mySecs<t.mySecs) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }

    //Returns time as a String in the form hrs:mins:secs. 
    public String toString()
    { /* implementation not shown */ 
    	return myHrs + ":" + myMins + ":" + mySecs;
    }

    public void display(Time t) {
    	System.out.println(t.myHrs + ":" + t.myMins+ ":" + t.mySecs);
    	System.out.println(t);
    	System.out.println("(D) is correct answer.");
    }
}
