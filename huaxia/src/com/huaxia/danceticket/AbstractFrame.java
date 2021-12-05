package com.huaxia.danceticket;

import javax.swing.JFrame;

public abstract class AbstractFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	String title = "Dance Ticket";

	public AbstractFrame() {
		setSize(510, 570);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(title);
//		setLayout(null);
		init();
	}
	protected abstract void init(); // agreement

}
