package swing.component;

import javax.swing.JFrame;

public class OpenWindow2 extends JFrame {
	private static final long serialVersionUID = 1L;
	final int width = 640;
	final int height = 480;
	
	OpenWindow2(){
		init();
	}

	private void init() {
		setTitle("My frame");
		setSize(width, height);// 400 width and 500 height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // terminate app on close window
		setLocationRelativeTo(null);		
	}

	public static void main(String[] args) {
		OpenWindow2 frame = new OpenWindow2();
		frame.setVisible(true);
	}

}
