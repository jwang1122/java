package blackjack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Image frontImg;
	
	public ImagePanel() {
		URL url = getClass().getResource("/resources/animation.gif");
		frontImg = Toolkit.getDefaultToolkit().getImage(url);
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, 1024, 768);
		g.setColor(new Color(107,155,17));
		g.fillRect(0, 0, 1024, 768);
		g.setColor(new Color(110, 15, 135));
		g.setFont(new Font(Font.SERIF, Font.BOLD, 48));
		g.drawString("Welcome to Our Blackjack Game!", 160, 70);
		g.drawImage(frontImg, 180, 110, this);
	}
	
}
