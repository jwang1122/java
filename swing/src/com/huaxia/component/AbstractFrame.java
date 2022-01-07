package com.huaxia.component;

import javax.swing.JFrame;

public abstract class AbstractFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
