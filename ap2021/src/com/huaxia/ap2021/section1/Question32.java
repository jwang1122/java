package com.huaxia.ap2021.section1;

public class Question32 {
	static int nums[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

	public static void main(String[] args) {
		// I.
		for (int r = 0; r < nums.length; r++) {
			for (int c = 0; c < nums[0].length; c++) {
				System.out.print(nums[r][c] +" ");
			}
			System.out.print("\n") ;
		}

		System.out.println();
		// II.
		for (int[] row : nums) {
			for (int col: row) {
				System.out.print(col +" ");
			}
			System.out.print("") ;
		}
		System.out.println();
		
		// III.
//		for (int r = 0; r < nums[0].length; r++) {
//			for (int c = 0; c < nums.length; c++) {
//				System.out.print(nums[r][c] +" ");
//			}
//			System.out.print("\n") ;
//		}
	}

}
