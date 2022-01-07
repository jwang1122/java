package com.huaxia.layout;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.huaxia.component.AbstractFrame;

public class CardLayoutTest extends AbstractFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private CardLayout layout;
	private Container container;
	private JPanel pnl;

	@Override
	public void init() {
		setTitle("Card Layout");
		container = getContentPane();
		layout = new CardLayout();
		container.setLayout(layout);
		JButton btn1 = new JButton("Button1");
		JButton btn2 = new JButton("Button2");
		JButton btn3 = new JButton("Button3");
		JButton btn4 = new JButton("Button4");
		JButton btn5 = new JButton("Button5");
		pnl = new JPanel();
		JLabel helloLbl = new JLabel("Hello world!");
		pnl.add(helloLbl);
		pnl.add(btn5);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(pnl);
	}

	public static void main(String[] args) {
		CardLayoutTest win = new CardLayoutTest();
		win.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		layout.next(container);
	}

}
