package com.huaxia.image;


import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplatyImageOnJLabel extends JFrame {
	private static final long serialVersionUID = 1L;
	DisplatyImageOnJLabel(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640,480);
		URL iconUrl = this.getClass().getResource("diamondK.png");
		ImageIcon cardImage = new ImageIcon(iconUrl);	
		iconUrl = this.getClass().getResource("clubA.png");
		ImageIcon cardImage2 = new ImageIcon(iconUrl);	
		JLabel lbl = new JLabel(cardImage);
		JLabel lbl2 = new JLabel(cardImage2);
		add(lbl2);
		this.setLayout(null);
		lbl.setLocation(50, 100);
		lbl.setSize(125,170);
		lbl2.setLocation(80, 100);
		lbl2.setSize(125,170);
		add(lbl);
	}
	public static void main(String[] args) {
		DisplatyImageOnJLabel frame = new DisplatyImageOnJLabel();
		frame.setVisible(true);

	}

}
