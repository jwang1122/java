package snake;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	public MainFrame(){
		init();
	}

	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake Eat Apple Game");
		this.setResizable(false);	
	}

}
