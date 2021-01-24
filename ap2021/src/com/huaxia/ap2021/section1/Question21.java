package com.huaxia.ap2021.section1;
// exclusion method + list value 
public class Question21 {

	public static void main(String[] args) {
		int[] nums = {11, 22, 33, 44, 55, 66};
		for (int i=0; i<nums.length; i++)
			nums[nums[i]/11] = nums[i];
		for(int i : nums)
			System.out.print(i + ", ");
		System.out.println();
	}

}
