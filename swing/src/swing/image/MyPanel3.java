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

/**
 * Random moving image
 * @see RandomMoveImage
 * @author John
 *
 */
public class MyPanel3 extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
//	private final int RAND_POS = 29;
//	private final int DOT_SIZE = 10;

	private Image apple;
	private int apple_x = 100;
	private int apple_y = 100;
	private final int DELAY = 100;
	private Timer timer;

	public MyPanel3() {
		loadImage();
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.drawImage(apple, apple_x, apple_y, this);

	}

	private void loadImage() {
		Toolkit t = Toolkit.getDefaultToolkit();
		URL iconUrl = this.getClass().getResource("/resources/apple.png");
		apple = t.getImage(iconUrl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
	}

	private void move() {
		Random rand = new Random();
		int r = (int) (Math.random() * 10);
		boolean flag = rand.nextBoolean();
		if (flag)
			apple_x += r;
		else
			apple_x -= r;
		if (apple_x <= 0)
			apple_x = 0;
		if (apple_x > 400)
			apple_x = 400;

		r = (int) (Math.random() * 10);
		flag = rand.nextBoolean();
		if (flag)
			apple_y += r;
		else
			apple_y -= r;
		if (apple_y <= 0)
			apple_y = 0;
		if (apple_y > 400)
			apple_y = 400;
	}
// System.out.println("x:" + apple_x);
//		System.out.println("y:" + apple_y);
}
