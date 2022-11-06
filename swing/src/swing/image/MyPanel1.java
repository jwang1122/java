package swing.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel1 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Image apple;
	private int apple_x = 100;
	private int apple_y = 100;
	private final int DELAY = 100;
	private Timer timer;
	
	public MyPanel1() {
		loadImage();
		timer = new Timer(DELAY, this);
		timer.start();
//		JButton btn = new JButton("<");
//		btn.setBounds(5, 5, 50, 30);
//		btn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("button clicked...");
//				
//			}
//			
//		});
//		add(btn);
		setLayout(null);
	}
	public void paint(Graphics g) {
		g.clearRect(0,0,400,400);
		g.drawImage(apple, apple_x, apple_y, this);

	}
	
	private void loadImage() {
		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = getClass().getClassLoader().getResource("resources/tiger.jpeg");
		apple = t.getImage(iconUrl);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
	}
	
	private void move() {
		Random rand = new Random();
		int signX = rand.nextBoolean()?1:-1;
		int signY = rand.nextBoolean()?1:-1;
		int deltaX = (int)(Math.random()*10 + 1) * signX;
		int deltaY = (int)(Math.random()*10 + 1) * signY;
		apple_x += deltaX;
		apple_y += deltaY;		
		if(apple_x<0) apple_x=0;
		if(apple_y<0) apple_y=0;
	}
}
