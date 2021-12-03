package com.huaxia.swing.component;

import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

class CheckBoxExample1 extends JFrame implements ItemListener { 

	private static final long serialVersionUID = 1L;

	// frame 
    static JFrame f; 
  
    // label 
    static JLabel l, l1; 
  
    // checkbox 
    static JCheckBox c1, c2; 
  
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
        f = new JFrame("frame"); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        // create a object 
		CheckBoxExample1 s = new CheckBoxExample1(); 
    
        // create checkbox 
        c1 = new JCheckBox("geeksforgeeks", false); 
        c2 = new JCheckBox("checkbox 2", false); 
  
        // add ItemListener 
        c1.addItemListener(s); 
        c2.addItemListener(s); 
  
        // create labels 
        l = new JLabel("geeksforgeeks not selected"); 
        l1 = new JLabel("checkbox2 not selected"); 
  
        // set color of text 
        l.setForeground(Color.red); 
        l1.setForeground(Color.blue); 
  
        // create a new panel 
        JPanel p = new JPanel(); 
        p.setLayout(new GridLayout(2,2));
        // add checkbox to panel 
        p.add(c1); 
        p.add(c2); 
        p.add(l); 
        p.add(l1); 
  
        // add panel to frame 
        f.add(p); 
  
        // set the size of frame 
        f.setSize(600, 200); 
  
        f.setVisible(true); 
    } 
    public void itemStateChanged(ItemEvent e) 
    { 
        // if the state of checkbox1 is changed 
        if (e.getSource() == c1) { 
            if (e.getStateChange() == 1) 
                l.setText("geeksforgeeks  selected"); 
            else
                l.setText("geeksforgeeks  not selected"); 
        } 
  
        // if the state of checkbox2 is changed 
        else { 
            if (e.getStateChange() == 1) 
                l1.setText("checkbox 2  selected"); 
            else
                l1.setText("checkbox 2 not selected"); 
        } 
    } 
} 