package com.huaxia.ap2021.section1;

public class Question15 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 2; i++)
			for (int j = 1; j <= 3; j++)
				for (int k = 1; k < 4; k++)
					sum += (i * j * k);
		System.out.println(sum);
	}
}
