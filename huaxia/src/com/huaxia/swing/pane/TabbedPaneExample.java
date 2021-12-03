package com.huaxia.swing.pane;

import javax.swing.*;

public class TabbedPaneExample {
	JFrame f;

	TabbedPaneExample() {
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea ta = new JTextArea(20,18);
		ta.setText("This is Main tabbed panel.");
		JPanel p1 = new JPanel();
		p1.add(ta);
		JPanel p2 = new JPanel();
		JButton jb = new JButton("this is visit panel.");
		p2.add(jb);
		JPanel p3 = new JPanel();
		JTextField txt = new JTextField("This is help panel.");
		p3.add(txt);
		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(50, 50, 200, 200);
		tp.add("main", p1);
		tp.add("visit", p2);
		tp.add("help", p3);
		f.add(tp);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TabbedPaneExample();
	}
}