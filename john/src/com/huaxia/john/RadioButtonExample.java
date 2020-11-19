package com.huaxia.john;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton; 

class Demo extends JFrame {

	private static final long serialVersionUID = 1L;

	// Declaration of object of JRadioButton class. 
	JRadioButton jRadioButton1; 

	// Declaration of object of JRadioButton class. 
	JRadioButton jRadioButton2; 

	// Declaration of object of JButton class. 
	JButton jButton; 

	// Declaration of object of ButtonGroup class. 
	ButtonGroup buttonGroup; 

	// Declaration of object of JLabel class. 
	JLabel qualifyLbl; 

	// Constructor of Demo class. 
	public Demo() 
	{ 

		// Setting layout as null of JFrame. 
		this.setLayout(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// Initialization of object of "JRadioButton" class. 
		jRadioButton1 = new JRadioButton(); 

		// Initialization of object of "JRadioButton" class. 
		jRadioButton2 = new JRadioButton(); 

		// Initialization of object of "JButton" class. 
		jButton = new JButton("Clear");
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonGroup.clearSelection();				
			}
			
		});

		// Initialization of object of "ButtonGroup" class. 
		buttonGroup = new ButtonGroup(); 

		// Initialization of object of " JLabel" class. 
		qualifyLbl = new JLabel("Qualification"); 

		// setText(...) function is used to set text of radio button. 
		// Setting text of "jRadioButton2". 
		jRadioButton1.setText("Under-Graduate"); 

		// Setting text of "jRadioButton4". 
		jRadioButton2.setText("Graduate"); 

		// Setting Bounds of "jRadioButton2". 
		jRadioButton1.setBounds(120, 30, 220, 50); 

		// Setting Bounds of "jRadioButton4". 
		jRadioButton2.setBounds(350, 30, 220, 50); 

		// Setting Bounds of "jButton". 
		jButton.setBounds(125, 90, 80, 30); 
		// Setting Bounds of JLabel "L2". 
		qualifyLbl.setBounds(20, 30, 150, 50); 

		// "this" keyword in java refers to current object. 
		// Adding "jRadioButton2" on JFrame. 
		this.add(jRadioButton1); 

		// Adding "jRadioButton4" on JFrame. 
		this.add(jRadioButton2); 

		// Adding "jButton" on JFrame. 
		this.add(jButton); 

		// Adding JLabel "L2" on JFrame. 
		this.add(qualifyLbl); 

		// Adding "jRadioButton1" and "jRadioButton3" in a Button Group "G2". 
		buttonGroup.add(jRadioButton1); 
		buttonGroup.add(jRadioButton2); 
	}
	
} 

public class RadioButtonExample { 
	// Driver code. 
	public static void main(String args[]) 
	{ // Creating object of demo class. 
		Demo f = new Demo(); 

		// Setting Bounds of JFrame. 
		f.setBounds(100, 100, 500, 200); 

		// Setting Title of frame. 
		f.setTitle("RadioButtons"); 

		// Setting Visible status of frame as true. 
		f.setVisible(true); 
	} 
} 
