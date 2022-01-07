package com.huaxia.image;

import javax.swing.JFrame;

public class DiaplayBallImage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int WIDTH = 600;
	static final int HEIGHT = 400;

	public DiaplayBallImage() {
		initFrame();
		init();
	}

	private void init() {
		MyPanel6 panel = new MyPanel6();
		add(panel);
	}

	private void initFrame() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Moving Image");
	}

	public static void main(String[] args) {
		DiaplayBallImage frame = new DiaplayBallImage();
		frame.setVisible(true);
	}

}
