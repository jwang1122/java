package blackjack;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private ImageIcon image;

	ImagePanel(){
		URL url = this.getClass().getClassLoader().getResource("resources/animation.gif");
		image = new ImageIcon(url);
		JLabel imageLbl = new JLabel(image);
		add(imageLbl);
//		image = Toolkit.getDefaultToolkit().createImage(url);
	}

//	@Override
//	public void paint(Graphics g) {
//		g.drawImage(image, 100, 100, this);
//	}
	
	
}
