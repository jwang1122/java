package com.huaxia.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * draw image on panel
 * 
 * @author John
 *
 */
public class DrawImagePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Image cardImg;
	private int x = 10;
	private int y = 40;
	private boolean flag = true;
	private boolean visible = true;

	public DrawImagePanel() {
		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("clubA.png");
		cardImg = t.getImage(iconUrl);
		JButton btn = new JButton("Click");
		btn.addActionListener(this);
		btn.setBounds(10, 10, 100, 40);
//		add(btn);

	}
//	public void paint(Graphics g) {
//
//		Toolkit t = Toolkit.getDefaultToolkit();
//		URL iconUrl = this.getClass().getResource("clubA.png");
//		apple = t.getImage(iconUrl);
//		int width = apple.getWidth(this);
//		int height = apple.getHeight(this);
//		float ratial = (float)height/width;
//		g.drawImage(apple, apple_x, apple_y, 40, (int)(40*ratial), this);
//
//	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void paint(Graphics g) {
//		if (visible) {
			int width = cardImg.getWidth(this);
			int height = cardImg.getHeight(this);
			float ratial = (float) height / width;
			g.drawImage(cardImg, x, y, 40, (int) (40 * ratial), this);
//		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(flag);
		repaint();
		flag = !flag;
	}
}
