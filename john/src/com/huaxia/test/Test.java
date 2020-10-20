package com.huaxia.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.huaxia.john.GetInfo;
import com.huaxia.john.Student;

public class Test {

	public static void main(String[] args) {
		GetInfo info = new Student("John");
		System.out.println(info.getName());

	}

}
