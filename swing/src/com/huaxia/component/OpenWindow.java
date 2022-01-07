package com.huaxia.component;

import javax.swing.JFrame;

public class OpenWindow {
	public static void main(String[] args) {
		JFrame f = new JFrame("My First Window");// creating instance of JFrame
		f.setSize(600, 400);// 400 width and 500 height
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // terminate app on close window
		f.setVisible(true);// making the frame visible
	}
}
