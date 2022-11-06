package swing.image;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class OverlapImageLabel extends JFrame {

	public OverlapImageLabel()  {
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		MyPanel7 myPanel = new MyPanel7();
		add(myPanel);
	}

	public static void main(String[] args) {
		OverlapImageLabel frame = new OverlapImageLabel();
		frame.setVisible(true);

	}

}
