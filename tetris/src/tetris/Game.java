package tetris;

import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 400;
	
	public Game(){
		init();
		Tetris tetris = new Tetris();
		BoardPanel mainPnl = new BoardPanel(tetris);
		add(mainPnl);
	}

	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tetris");
		this.setResizable(true);	
	}

	public Image loadImage(String filename) {
		URL url = getClass().getClassLoader().getResource("resources/" + filename);
		return getToolkit().getImage(url);
	}

}
