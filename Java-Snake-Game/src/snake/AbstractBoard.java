package snake;

import java.awt.Image;
import java.net.URL;

import javax.swing.JPanel;

public abstract class AbstractBoard extends JPanel{
	private static final long serialVersionUID = 1L;

	public Image loadImage(String filename) {
		URL url = getClass().getClassLoader().getResource("resources/" + filename);
		Image image = getToolkit().getImage(url);
		return image;
	}

}
