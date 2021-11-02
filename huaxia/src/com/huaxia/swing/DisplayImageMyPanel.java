package com.huaxia.swing;

import javax.swing.JFrame;

/**
 * display image on JPanel, or remove it.
 * 
 * @author John
 *
 */
public class DisplayImageMyPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public DisplayImageMyPanel(){
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		DrawImagePanel myPanel = new DrawImagePanel();
		myPanel.setBounds(10, 10, 350, 350);
		add(myPanel);

		setLayout(null);
	}
	
	public static void main(String[] args) {
		DisplayImageMyPanel di = new DisplayImageMyPanel();

		di.setVisible(true);
	}

}
