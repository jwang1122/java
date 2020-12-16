package com.huaxia.java2;

interface Score {
	int run = 321;

	void getScore();
}

public class AnonymousClassExample {
	public static void main(String[] args) {
// Myclass is hidden inner class of Score interface   
// whose name is not written but an object to it    
// is created.   
		Score s = new Score() {
			@Override
			public void getScore() {
//prints score  
				System.out.print("Score is " + run); // can access interface variable
			}
		};
		s.getScore();
	}
}