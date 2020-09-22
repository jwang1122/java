package com.huaxia.swing;

import javax.swing.JFrame;

public class MoveImage extends JFrame{

	public MoveImage() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		MyPanel1 myPanel = new MyPanel1();
		add(myPanel);
		
	}
	public static void main(String[] args) {
		MoveImage mi = new MoveImage();
		mi.setVisible(true);

	}

}
