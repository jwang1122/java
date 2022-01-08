package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ImagePanel() {
		setLayout(new BorderLayout());
		URL url = getClass().getClassLoader().getResource("resources/animation.gif");
		ImageIcon bkImage = new ImageIcon(url.getPath());
		JLabel titleLbl = new JLabel("Welcome to Our Blackjack Game!", SwingConstants.CENTER);
		titleLbl.setFont(new Font(Font.SERIF, Font.BOLD, 48));
		titleLbl.setForeground(new Color(152, 16, 61));
		JLabel imageLbl = new JLabel(bkImage);
		add(titleLbl, BorderLayout.NORTH);
		add(imageLbl, BorderLayout.CENTER);
	}
	
}
