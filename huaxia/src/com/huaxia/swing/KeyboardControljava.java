package com.huaxia.swing;

import javax.swing.JFrame;

public class KeyboardControljava extends JFrame{

	public KeyboardControljava() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		MyPanel2 myPanel = new MyPanel2();
		add(myPanel);
		
	}
	public static void main(String[] args) {
		KeyboardControljava mi = new KeyboardControljava();
		mi.setVisible(true);

	}

}
