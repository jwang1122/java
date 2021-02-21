package com.huaxia.java1.homework;

public class LoopHW1 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0)
				System.out.println(i);
		}
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1)
				System.out.println(i);
		}
		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
		int i = 1;
		while (i <= 10) {
			if (i % 2 == 0)
				System.out.println(i++);
		}
		i = 1;
		while (i <= 10) {
			if (i % 2 == 1)
				System.out.println(i++);
		}
	}

}
