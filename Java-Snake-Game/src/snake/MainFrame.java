package snake;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	MainFrame(){
		init();
//		Board board = new Board();
//		MoveSnake board = new MoveSnake();
		ControlSnake board = new ControlSnake();
//		RandomApple board = new RandomApple();
		add(board);
	}
	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake eat apples");
		setLocationRelativeTo(null);
		
		this.setResizable(true);	
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
