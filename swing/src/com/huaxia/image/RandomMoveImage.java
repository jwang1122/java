package com.huaxia.image;

import javax.swing.JFrame;

/**
 * @see MyPanel3
 * @author John
 *
 */
public class RandomMoveImage extends JFrame{

	private static final long serialVersionUID = 1L;
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
