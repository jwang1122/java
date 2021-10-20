package com.huaxia.john;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel; 

public class CheckBoxExample extends JFrame implements ActionListener { 
	/**
	 * we use the serialVersionUID attribute to remember versions of a Serializable class to verify 
	 * that a loaded class and the serialized object are compatible.
	 */	
	private static final long serialVersionUID = 1L;
	static final String FOLDER = "/Users/wangqianjiang/workspace/java/john/doc/";
	static final String ASTROS1 = "HoustonAstros.png";
    JCheckBox c1 = new JCheckBox("Python"); 
    JCheckBox c2 = new JCheckBox("Java");//, icon);
    
	public CheckBoxExample(){
	       // set layout of frame 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); 
//        Toolkit t = Toolkit.getDefaultToolkit();
//        ImageIcon icon = new ImageIcon(t.getImage(FOLDER + ASTROS1));
        // create checkbox 
        JCheckBox c1 = new JCheckBox("Python"); 
        JCheckBox c2 = new JCheckBox("Java");//, icon);
        c1.addActionListener(this);
        c2.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		System.out.println(c1.isSelected());
		System.out.println(c2.isSelected());
	} 
} 
