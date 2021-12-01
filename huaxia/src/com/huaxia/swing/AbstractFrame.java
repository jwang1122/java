package com.rodney.swing;

import javax.swing.JFrame;

public abstract class AbstractFrame extends JFrame {
	String title = "My Frame";
	public AbstractFrame() {
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
//		setLayout(null);
		init();
	}
	protected abstract void init();

}
