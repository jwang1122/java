package com.huaxia.ap2021.quiz5;

public class Question2 {

	public static void main(String[] args) {
		int[] nums = { 11, 22, 33, 44, 55, 66 };
		for (int i = 0; i < nums.length; i++) {
			nums[nums[i] / 11] = nums[i];
		}
		int i = 0;
		while (i < nums.length) {
			System.out.print(nums[i++]);
			if (i != 0 && i<nums.length)
				System.out.print(", ");
		}
		System.out.println();
	}

}
