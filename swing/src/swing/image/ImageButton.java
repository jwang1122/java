package swing.image;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageButton extends JFrame {

	private static final long serialVersionUID = 1L;

	public ImageButton(String title) throws HeadlessException {
		super(title);
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JButton b = new JButton(new ImageIcon("ok-hand.png"));// creating instance of JButton
		b.setBounds(130, 100, 60, 60);// x axis, y axis, width, height
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("The button clicked.");				
			}
		});
		add(b);// adding button in JFrame
		
	}

	public static void main(String[] args) {
		ImageButton btn = new ImageButton("Button with image");
		btn.setLayout(null);
		btn.setVisible(true);

	}

}
