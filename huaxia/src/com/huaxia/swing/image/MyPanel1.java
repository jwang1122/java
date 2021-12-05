package com.huaxia.swing.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel1 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Image apple;
	private int apple_x = 100;
	private int apple_y = 100;
	private final int DELAY = 40;
	private Timer timer;
	
	public MyPanel1() {
		loadImage();
		timer = new Timer(DELAY, this);
		timer.start();
		JButton btn = new JButton("<");
		btn.setBounds(5, 5, 50, 30);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked...");
				
			}
			
		});
		add(btn);
		setLayout(null);
	}
	public void paint(Graphics g) {
		g.clearRect(60,0,400,400);
		g.drawImage(apple, apple_x, apple_y, this);

	}
	
	private void loadImage() {
		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("resources/apple.png");
		apple = t.getImage(iconUrl);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
	}
	
	private void move() {
		apple_x += 1;
		apple_y += 1;		
	}
}