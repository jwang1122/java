package com.huaxia.ap2021.section1;

public class XylophoneTester {

	public static void main(String[] args) {
		Xylophone [] xylophones = new Xylophone [5];
		Percussion [] xylophones1 = new Xylophone [5];
		Xylophone x1 = new Xylophone ("xylophone", 65, 32 );
		System.out.println(x1.getNumKeys());
//		Xylophone x2 = new Xylophone ("xylophone", 65, 32); 
//		System.out.println(x2.numberOfKeys); 
		Drums[] drums;
		
		Xylophone x2 = new Xylophone ("xylophone", 80, 32) ; 
		Xylophone x3 = new Xylophone ("xylophone", 65,	32);

//		if (x2.weight==x3.weight)
//			System.out.println ("equally heavy") ; 
//		else
//			System.out.println ("not equally heavy");

//		if (x2.weight()==x3.weight())
//			System.out.println ("equally heavy") ; 
//		else
//			System.out.println ("not equally heavy");
		
		if (x2.getWeight()==x3.getWeight())
			System.out.println ("equally heavy") ; 
		else
			System.out.println ("not equally heavy");
		
//		if (x2.weight.equals(x3.weight)
//			System.out.println ("equally heavy") ; 
//		else
//			System.out.println ("not equally heavy");
		
	}

}
