package com.huaxia.swing.layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
 
public class BorderLayoutExample1 {
 
    public static void main(String[] args) {
        // Create and set up a frame window
//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Border Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        // Define new buttons 
        JButton jb1 = new JButton("NORTH");      
        JButton jb2 = new JButton("SOUTH");
        JButton jb3 = new JButton("WEST");          
        JButton jb4 = new JButton("EAST");          
        JButton jb5 = new JButton("CENTER");          
        // Define the panel to hold the buttons 
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jb1, BorderLayout.NORTH);
        panel.add(jb2, BorderLayout.SOUTH);
        panel.add(jb3, BorderLayout.WEST);
        panel.add(jb4, BorderLayout.EAST);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(jb5);
        JButton jb6 = new JButton("jb6");
        JTextField txt = new JTextField("Default value");
        panel1.add(txt);
        panel1.add(jb6);
        panel.add(panel1, BorderLayout.CENTER);
        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);     
    }
 
}
