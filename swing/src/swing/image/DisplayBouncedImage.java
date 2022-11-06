package swing.image;

import javax.swing.JFrame;

public class DisplayBouncedImage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	
	public DisplayBouncedImage() {
		initFrame();
		init();
	}
	
	private void init() {
		MyPanel4 panel = new MyPanel4();
		add(panel);
	}

	private void initFrame() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Moving Image");
	}

	public static void main(String[] args) {
		DisplayBouncedImage frame = new DisplayBouncedImage();
		frame.setVisible(true);
	}

}
