package com.huaxia.java1.math;

import java.util.ArrayList;
import java.util.List;

public class PerfactNumber {

	public static void main(String[] args) {
		System.out.println(isPerfactNumber(6));
		System.out.println(isPerfactNumber(12));
		List<Integer> list = findPerfactNumber(1,10000);
		System.out.println(list);
	}

	static boolean isPerfactNumber(int x) {
		int sum = 0;
		for (int i = 1; i<x; i++) {
			if ( x % i == 0)
				sum += i;
		}
		return sum==x;
	}
	
	static List<Integer> findPerfactNumber(int start, int end){
		List<Integer> l = new ArrayList<>();
		for(int i=start; i<end; i++) {
			if(isPerfactNumber(i)) l.add(i);
		}
		return l;
	}
}

/*
 * Total 51 perfact number
 * [6, 28, 496, 8128]
*/