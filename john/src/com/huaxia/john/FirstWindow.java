package com.huaxia.john;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton Startbutton;
	JPanel welcomePanel;
	JPanel SecondPanel;
	JPanel StandardPanel;
	JPanel custPanel;
	JPanel panelFill;
	JButton Standard;
	JButton fill;
	JButton put;
	JButton cust;
	JLabel label;
	TextField rows;
	TextField col;
	JButton[][] button;
	int r1;
	int cc;

	public FirstWindow() {

		setSize(800, 600);
		setVisible(true);
		setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		welcomePanel = new JPanel();

		label = new JLabel("Welcome to Dvonn");
		welcomePanel.add(label);
		welcomePanel.setVisible(true);

		label.setForeground(Color.RED);
		label.setFont(new Font("Serif", Font.PLAIN, 40));

		Startbutton = new JButton("start");

		Startbutton.setBackground(Color.BLACK);
		Startbutton.setForeground(Color.RED);
		Startbutton.setPreferredSize(new Dimension(120, 40));

		welcomePanel.add(Startbutton);
		add(welcomePanel);

		Startbutton.addActionListener(this);

		SecondPanel = new JPanel();
		SecondPanel.setVisible(false);
		SecondPanel.setSize(400, 400);
		rows = new TextField();
		col = new TextField();
		SecondPanel.add(rows);
		SecondPanel.add(col);

		fill = new JButton("fill random");
		fill.addActionListener(this);
		fill.setBackground(Color.LIGHT_GRAY);
		fill.setForeground(Color.BLUE);

		put = new JButton("put");
		put.setBackground(Color.LIGHT_GRAY);
		put.setForeground(Color.BLUE);

		Standard = new JButton("Standardised board");
		Standard.setBackground(Color.LIGHT_GRAY);
		Standard.setForeground(Color.BLUE);
		Standard.addActionListener(this);

		cust = new JButton("customized");
		cust.setBackground(Color.LIGHT_GRAY);
		cust.setForeground(Color.BLUE);
		cust.addActionListener(this);

		panelFill = new JPanel();

		panelFill.add(fill);
		panelFill.add(put);
		SecondPanel.add(Standard);
		SecondPanel.add(cust);

		this.r1 = 5;
		this.cc = 11;
		button = new JButton[r1][cc];
		StandardPanel = new JPanel();
		StandardPanel.setBackground(Color.WHITE);
		StandardPanel.setLayout(new GridLayout(r1, cc));

		for (int i = 0; i <= r1 - 1; i++) {
			for (int j = 0; j <= cc - 1; j++) {
				button[i][j] = new JButton(); // i want to add an image to it

				button[i][j].addActionListener(this);
			}
		}
		for (int i = 0; i <= r1 - 1; i++) {
			for (int j = 0; j <= cc - 1; j++) {

				button[i][j].setLayout(new FlowLayout());
				button[i][j].setBackground(Color.WHITE);

				StandardPanel.add(button[i][j], i, j);

			}
		}

	}

	public FirstWindow(int row, int cols) {

		setSize(800, 600);
		setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fill = new JButton("fill random");
		fill.addActionListener(this);
		fill.setBackground(Color.LIGHT_GRAY);
		fill.setForeground(Color.BLUE);

		put = new JButton("put");
		put.setBackground(Color.LIGHT_GRAY);
		put.setForeground(Color.BLUE);

		Standard = new JButton("Standardised board");
		Standard.setBackground(Color.LIGHT_GRAY);
		Standard.setForeground(Color.BLUE);
		Standard.addActionListener(this);

		cust = new JButton("customized");
		cust.setBackground(Color.LIGHT_GRAY);
		cust.setForeground(Color.BLUE);
		cust.addActionListener(this);

		panelFill = new JPanel();
		panelFill.add(fill);
		panelFill.add(put);

		this.r1 = row;
		this.cc = cols;

		button = new JButton[r1][cc];

		custPanel = new JPanel();
		custPanel.setBackground(Color.WHITE);
		custPanel.setLayout(new GridLayout(r1, cc));

		for (int i = 0; i <= r1 - 1; i++) {
			for (int j = 0; j <= cc - 1; j++) {
				button[i][j] = new JButton(); // i want to add an image to it
				button[i][j].addActionListener(this);
			}
		}
		for (int i = 0; i <= r1 - 1; i++) {
			for (int j = 0; j <= cc - 1; j++) {

				button[i][j].setLayout(new FlowLayout());
				button[i][j].setBackground(Color.WHITE);
				custPanel.add(button[i][j], i, j);

			}
		}
		add(custPanel);
		add(panelFill, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		FirstWindow window = new FirstWindow();
		window.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Startbutton) {

			this.remove(welcomePanel);
			this.add(SecondPanel);
			SecondPanel.setVisible(true);
			// this.add(SecondPanel);

			JLabel label1 = new JLabel("dvonn");
			label1.setForeground(Color.RED);
			label1.setFont(new Font("Serif", Font.PLAIN, 25));
			SecondPanel.add(label1);

		}

		if (e.getSource() == cust) {
			String rowText = rows.getText();
			String colText = col.getText();

			r1 = Integer.parseInt(rowText);
			cc = Integer.parseInt(colText);
			this.setVisible(false);
//			FirstWindow custom = new FirstWindow(r1, cc);

		}
		if (e.getSource() == Standard) {
			SecondPanel.setVisible(false); // set the second panel invisible
			this.add(StandardPanel); // to add the panel with the buttons
			StandardPanel.setVisible(true);

			add(panelFill, BorderLayout.SOUTH);
			add(StandardPanel, BorderLayout.CENTER);

		}

		/*
		 * Board b = new Board(r1,c1); b.fillRandom();
		 */

		// }

	}
}