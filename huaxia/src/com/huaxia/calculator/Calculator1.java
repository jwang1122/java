package com.huaxia.calculator;

//Java program to create a simple calculator 
//with basic +, -, /, * using java swing elements 

import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
class Calculator1 extends JFrame implements ActionListener { 

	private static final long serialVersionUID = 1L;

	// create a frame 
	static JFrame f; 
	
	// create a textfield 
	static JTextField l; 

	// store oprerator and operands 
	String s0, s1, s2; 

	// default constrcutor 
	Calculator1() 
	{ 
		s0 = s1 = s2 = ""; 
	} 

	// main function 
	public static void main(String args[]) 
	{ 
		// create a frame 
		f = new JFrame("calculator"); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = f.getContentPane();
		container.setLayout(new BorderLayout());
		try { 
			// set look and feel 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		} 
		catch (Exception e) { 
			System.err.println(e.getMessage()); 
		} 

		// create a object of class 
		Calculator1 c = new Calculator1(); 
		// create a textfield 
		l = new JTextField(); 
		l.setEditable(false);
		container.add(l, BorderLayout.NORTH);
		// set the textfield to non editable 
	
		// create number buttons and some operators 
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1; 
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,4));
		// create number buttons 
		b0 = new JButton("0"); 
		b1 = new JButton("1"); 
		b2 = new JButton("2"); 
		b3 = new JButton("3"); 
		b4 = new JButton("4"); 
		b5 = new JButton("5"); 
		b6 = new JButton("6"); 
		b7 = new JButton("7"); 
		b8 = new JButton("8"); 
		b9 = new JButton("9"); 
		
		// equals button 
		beq1 = new JButton("="); 

		// create operator buttons 
		ba = new JButton("+"); 
		bs = new JButton("-"); 
		bd = new JButton("/"); 
		bm = new JButton("*"); 
		beq = new JButton("C"); 
		
		// create . button 
		be = new JButton("."); 

		// create a panel 
//		JPanel p = new JPanel(); 

		// add action listeners 
		bm.addActionListener(c); 
		bd.addActionListener(c); 
		bs.addActionListener(c); 
		ba.addActionListener(c); 
		b9.addActionListener(c); 
		b8.addActionListener(c); 
		b7.addActionListener(c); 
		b6.addActionListener(c); 
		b5.addActionListener(c); 
		b4.addActionListener(c); 
		b3.addActionListener(c); 
		b2.addActionListener(c); 
		b1.addActionListener(c); 
		b0.addActionListener(c); 
		be.addActionListener(c); 
		beq.addActionListener(c); 
		beq1.addActionListener(c); 

		// add elements to panel 
//		p.add(l); 
		center.add(ba); 
		center.add(b1); 
		center.add(b2); 
		center.add(b3); 
		center.add(bs); 
		center.add(b4); 
		center.add(b5); 
		center.add(b6); 
		center.add(bm); 
		center.add(b7); 
		center.add(b8); 
		center.add(b9); 
		center.add(bd); 
		center.add(be); 
		center.add(b0); 
		center.add(beq); 
		

		// set Background of panel 
		center.setBackground(Color.blue); 
		container.add(center, BorderLayout.CENTER);
		container.add(beq1, BorderLayout.SOUTH); 

		f.setSize(350, 230); 
//		f.setResizable(false);
		f.setVisible(true);; 
	} 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 

		// if the value is a number 
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
			// if operand is present then add to second no 
			if (!s1.equals("")) 
				s2 = s2 + s; 
			else
				s0 = s0 + s; 

			// set the value of text 
			l.setText(s0 + s1 + s2); 
		} 
		else if (s.charAt(0) == 'C') { 
			// clear the one letter 
			s0 = s1 = s2 = ""; 

			// set the value of text 
			l.setText(s0 + s1 + s2); 
		} 
		else if (s.charAt(0) == '=') { 

			double te; 

			// store the value in 1st 
			if (s1.equals("+")) 
				te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
			else if (s1.equals("-")) 
				te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
			else if (s1.equals("/")) 
				te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 

			// set the value of text 
			l.setText(s0 + s1 + s2 + "=" + te); 

			// convert it to string 
			s0 = Double.toString(te); 

			s1 = s2 = ""; 
		} 
		else { 
			// if there was no operand 
			if (s1.equals("") || s2.equals("")) 
				s1 = s; 
			// else evaluate 
			else { 
				double te; 

				// store the value in 1st 
				if (s1.equals("+")) 
					te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
				else if (s1.equals("-")) 
					te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
				else if (s1.equals("/")) 
					te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 

				// convert it to string 
				s0 = Double.toString(te); 

				// place the operator 
				s1 = s; 

				// make the operand blank 
				s2 = ""; 
			} 

			// set the value of text 
			l.setText(s0 + s1 + s2); 
		} 
	} 
} 
