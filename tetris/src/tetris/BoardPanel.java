package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JPanel;
import javax.swing.Timer;

import game2D.Rect;
import game2D.Size;

public class BoardPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final int DELAY = 300;
	static Hashtable<Integer, Size> arrowDirections = new Hashtable<>();
	static {
		arrowDirections.put(KeyEvent.VK_LEFT, new Size(-10, 0));
		arrowDirections.put(KeyEvent.VK_RIGHT, new Size(10, 0));
		arrowDirections.put(KeyEvent.VK_UP, new Size(0, -10));
		arrowDirections.put(KeyEvent.VK_DOWN, new Size(0, 10));		
	}
	
	private Timer timer;
//	private Image backgroundImg;
	private ArrayList<Rect> shape;
	private Tetris tetris;
	
	BoardPanel(Tetris tetris) {
		this.tetris = tetris;
		shape = tetris.getShape();
		addKeyListener(new ArrowKey());
		setFocusable(true); // must call or no key response
		
		this.setPreferredSize(new Dimension(400, 300));
		timer = new Timer(DELAY, this); // create a time ticker for every DELAY
		timer.start();
	}

	@Override
	public void paint(Graphics g) {		
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		for(int i=0; i<shape.size(); i++) {
			g.setColor(tetris.color);
			Rect rect = shape.get(i);
			g.fillRect(rect.left, rect.top, rect.width, rect.height);
			g.setColor(tetris.color.brighter());
			g.drawRect(rect.left, rect.top, rect.width, rect.height);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tetris.moveDown();
		repaint();
	}
	
	class ArrowKey extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				tetris.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				tetris.moveRight();
				break;
			case KeyEvent.VK_UP:
				tetris.rotateLeft();
				shape = tetris.getShape();
				break;
			case KeyEvent.VK_DOWN:
				tetris.rotateRight();
				shape = tetris.getShape();
				break;
			}		
			repaint();
		}
	}
}
