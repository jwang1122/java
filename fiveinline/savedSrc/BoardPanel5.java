package fiveinline;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	static final int SIZE = 19;
	Chess[][] chesses = new Chess[SIZE][SIZE];
	boolean isBlack = true;

	public BoardPanel() {
		this.addMouseListener(new MyMouseListener());
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				chesses[i][j] = new Chess(i,j);
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(221, 168, 85));
		g.fillRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		g.setColor(Color.black);
		for(int i=0; i<SIZE; i++) {
			g.drawLine(chesses[i][0].x, chesses[i][0].y, chesses[i][SIZE-1].x, chesses[i][SIZE-1].y);
		}
		for(int i=0; i<SIZE; i++) {
			g.drawLine(chesses[0][i].x, chesses[0][i].y, chesses[SIZE-1][i].x, chesses[SIZE-1][i].y);
		}
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(chesses[i][j].color!=null) {
					g.setColor(chesses[i][j].color);
					g.fillOval(chesses[i][j].x-10, chesses[i][j].y-10, 20, 20);
				}
			}
		}
	}
	
	class MyMouseListener extends MouseInputAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			Chess c = getChess(e.getX(), e.getY());
			if(c!=null) {
				if(isBlack) {
					c.color = Chess.BLACK;
				}else {
					c.color = Chess.WHITE;
				}
				repaint();
				isBlack = !isBlack;
			}
		}
		
		Chess getChess(int mouseX, int mouseY) {
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					Chess c = chesses[i][j];
					double r = Math.sqrt(Math.pow((c.x-mouseX),2)+Math.pow((c.y-mouseY), 2));
					if(r<14) {
						return c;
					}
				}
			}
			return null;
		}
	}
}
