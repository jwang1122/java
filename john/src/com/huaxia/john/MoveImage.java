package com.huaxia.john;

import javax.swing.JFrame;

public class MoveImage extends JFrame{

	/**
	 * we use the serialVersionUID attribute to remember versions of a Serializable class to verify that a loaded class and the serialized object are compatible.
	 */
	private static final long serialVersionUID = 1L;
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
