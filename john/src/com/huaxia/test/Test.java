package com.huaxia.test;

import com.huaxia.john.GetInfo;
import com.huaxia.john.Student;

public class Test {

	public static void main(String[] args) {
		GetInfo info = new Student("John");
		System.out.println(info.getName());

	}

}
