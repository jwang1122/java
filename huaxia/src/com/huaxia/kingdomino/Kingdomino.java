package com.huaxia.kingdomino;

import javax.swing.JFrame;
/**
 * https://www.youtube.com/watch?v=smbwBPmP4Ms
 * 
 * @author John
 *
 */
public class Kingdomino extends JFrame {
	private static final long serialVersionUID = 1L;
	public Kingdomino() {
		setSize(1080, 720);
		setTitle("King Domino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainWindow window = new MainWindow();
		add(window);
		
//		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Kingdomino();
	}

}
