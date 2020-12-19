package com.huaxia.java1;
/*
 * LCM: Least Common Multiple
 */
public class LCM {
	public static int lcm(int n1, int n2) {
		int lcm = 1;
	     // maximum number between n1 and n2 is stored in lcm
        lcm = (n1 > n2) ? n1 : n2;

        // Always true
        while(true)
        {
            if( lcm % n1 == 0 && lcm % n2 == 0 )
            {
                break;
            }
            ++lcm;
        }		
		return lcm;
	}
	public static void main(String[] args) {
		System.out.println(lcm(15,6));
	}
}
