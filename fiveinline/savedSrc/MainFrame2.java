package fiveinline;

import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=700;
	public static final int HEIGHT=650;
	
	Container container;
	
	public MainFrame() {
		init();
		BoardPanel boardPnl = new BoardPanel();
		add(boardPnl);
	}
	
	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Five in Line Chess Game");
		this.setResizable(false);	
		container = this.getContentPane();
	}

}
