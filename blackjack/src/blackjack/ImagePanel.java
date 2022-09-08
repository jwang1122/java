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
	private Image image;
	
	ImagePanel(){
		URL url = this.getClass().getClassLoader().getResource("resources/animation.gif");
		image = Toolkit.getDefaultToolkit().getImage(url);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		g.setColor(new Color(103, 139, 74));
		g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		g.drawImage(image, 180, 110, this);
		g.setColor(new Color(110, 15, 135));
		g.setFont(new Font(Font.SERIF, Font.BOLD, 48));
		g.drawString("Welcome to Our Blackjack Game!", 160, 70);
	}
	
	
}
