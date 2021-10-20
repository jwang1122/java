package com.huaxia.john;

import javax.swing.JFrame;

public class KeyboardControl extends JFrame{

	/**
	 * we use the serialVersionUID attribute to remember versions of a Serializable class to verify
	 *  that a loaded class and the serialized object are compatible.
	 */
	private static final long serialVersionUID = 1L;
	public KeyboardControl() {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		MyPanel2 myPanel = new MyPanel2();
		add(myPanel);
		
	}
	public static void main(String[] args) {
		KeyboardControl mi = new KeyboardControl();
		mi.setVisible(true);

	}

}
