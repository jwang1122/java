package org.john.swing;

import javax.swing.JFrame;

public class OpenWindow {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
