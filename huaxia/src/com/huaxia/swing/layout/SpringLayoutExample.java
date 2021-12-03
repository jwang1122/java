package com.huaxia.swing.layout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
 
public class SpringLayoutExample {
 
    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame frame = new JFrame("Spring Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
         
        JLabel label = new JLabel("Label: ");
        JTextField text = new JTextField("Default value", 15);
        panel.setSize(300, 300);
        panel.setLayout(layout);
        panel.add(label);
        panel.add(text);
 
        // Put constraint on components
        layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.BASELINE, panel);
        layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.BASELINE, panel);
        layout.putConstraint(SpringLayout.WEST, text, 5, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, text, 5, SpringLayout.NORTH, panel);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);     
    }
 
}
