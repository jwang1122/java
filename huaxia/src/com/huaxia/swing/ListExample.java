package com.huaxia.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

class ListExample {

	// frame
	static JFrame f;

	// lists
	static JList<String> b;

	// main class
	public static void main(String[] args) {
		// create a new frame
		f = new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// create a object
//		ListExample s = new ListExample();

		// create a panel
		JPanel p = new JPanel();

		// create a new label
		JLabel l = new JLabel("Select the day of the week");

		// String array to store weekdays
		String week[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

		// create list
		b = new JList<String>(week);

		// set a selected index
		b.setSelectedIndex(2);

		// add list to panel
		p.add(l);
		p.add(b);
		
		f.add(p);

		// set the size of frame
		f.setSize(400, 400);

		f.setVisible(true);
	}

}
