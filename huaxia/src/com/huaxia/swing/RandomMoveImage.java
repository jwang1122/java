package com.huaxia.swing;

import javax.swing.JFrame;

public class RandomMoveImage extends JFrame{

	public RandomMoveImage() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		MyPanel3 myPanel = new MyPanel3();
		add(myPanel);
		
	}
	public static void main(String[] args) {
		RandomMoveImage mi = new RandomMoveImage();
		mi.setVisible(true);

	}

}
