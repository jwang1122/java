package com.huaxia.swing;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel; 

public class CheckBoxExample extends JFrame { 

	private static final long serialVersionUID = 1L;
	static final String FOLDER = "/Users/12818/workspace/java/john/doc/";
	static final String ASTROS1 = "HoustonAstros.png";
	
	public CheckBoxExample(){
	       // set layout of frame 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); 
        Toolkit t = Toolkit.getDefaultToolkit();
        ImageIcon icon = new ImageIcon(t.getImage(FOLDER + ASTROS1));
        // create checkbox 
        JCheckBox c1 = new JCheckBox("checkbox 1"); 
        JCheckBox c2 = new JCheckBox("checkbox 2", icon);
  
        // create a new panel 
        JPanel p = new JPanel(); 
  
        // add checkbox to panel 
        p.add(c1); 
        p.add(c2); 
  
        // add panel to frame 
        add(p); 
  
        // set the size of frame 
        setSize(600, 400); 
 		
	}
	
    // main class 
    public static void main(String[] args) 
    { 
    	CheckBoxExample window = new CheckBoxExample();
    	window.setVisible(true); 
    } 
} 
