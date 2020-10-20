package com.huaxia.john;

import javax.swing.JFrame;

public class DisplayImage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public DisplayImage(){
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		MyPanel myPanel = new MyPanel();
		add(myPanel);
	}
	
	public static void main(String[] args) {
		DisplayImage di = new DisplayImage();

		di.setVisible(true);
	}

}
