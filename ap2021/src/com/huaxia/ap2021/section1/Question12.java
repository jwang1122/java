package com.huaxia.ap2021.section1;

/**
 * familiar with embedded loop 
 * *
 * @author John
 *
 */
public class Question12 {

	public static void main(String[] args) {
		int n = 6;
		int count = 0;
		int p = 0;
		int q = 0;
		for (p=1; p<n; p++)
			for(q=1; q<=n; q++)
				count++;
		System.out.println(count);
		System.out.println(n*(n-1));
	}

}
