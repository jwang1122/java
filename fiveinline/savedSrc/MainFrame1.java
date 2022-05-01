package fiveinline;

import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	final int WIDTH=600;
	final int HEIGHT=600;
	
	Container container;
	
	public MainFrame() {
		init();
	}
	
	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Five in Line Chess Game");
		this.setResizable(false);	
		container = this.getContentPane();
	}

}
