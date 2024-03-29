package snake;

import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game3 extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	private Snake3 snake; // DDD: Demand Driven Development
	private Apple3 apple;
	
	public Game3(){
		init();
		Image headImg = loadImage("head.png");
		Image tailImg = loadImage("dot.png");
		snake = new Snake3(headImg, tailImg); // initialize objects
		Image appleImg = loadImage("apple.png");
		apple = new Apple3(appleImg);
		apple.locateApple();
//		BoardPanel mainPnl = new BoardPanel(snake, apple);
//		MoveSnake mainPnl = new MoveSnake(snake, apple);
		BoardPanel3 mainPnl = new BoardPanel3(snake, apple);
		add(mainPnl);
	}

	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake Eat Apple Game");
		this.setResizable(true);	
	}

	public Image loadImage(String filename) {
		URL url = getClass().getClassLoader().getResource("resources/" + filename);
//		System.out.println(url.getPath());
		return getToolkit().getImage(url);
	}

}
