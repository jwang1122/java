package fiveinline;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	static final int SIZE = 19;
	Chess[][] chesses = new Chess[SIZE][SIZE];
	boolean isBlack = true;
	String winner = "Black Win!";

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
	
	void gameOver() {
		JOptionPane.showMessageDialog(this, winner);
	}
	
	boolean fiveInLine() {
		if(checkAllRows()) return true;
		if(checkAllColumns()) return true;
		if(checkBackSlash()) return true;
		if(checkForwordSlash()) return true;
		return false;
	}

	boolean checkAllRows() {
        int count = 1;
        int a = 1;
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE-4; j++) {
                Color c = chesses[i][j].color;
                while (c != null && a<5) { 
                    if (c==chesses[i][j+a].color){
                        count += 1;
                    }
                    a += 1;
                }
                if (count == 5) {
                	if(c==Chess.BLACK) {
                		winner = "Black Win!";
                	}else {
                		winner = "White Win!";
                	}                		
                	return true;
                }
                else {
                    a = 1;
                    count = 1;
                }
            }
        }
        return false;		
	}
	
	boolean checkAllColumns() {
        int count = 1;
        int a = 1;
        for(int j=0; j<SIZE; j++) {
            for(int i=0; i<SIZE-4; i++) {
                Color c = chesses[i][j].color;
                while (c != null && a<5) { 
                    if (c==chesses[i+a][j].color) {
                        count += 1;
                    }
                    a +=1;
                }
                if (count == 5) {
                	if(c==Chess.BLACK) {
                		winner = "Black Win!";
                	}else {
                		winner = "White Win!";
                	}                		
                	return true;
                }
                else {
                    a= 1;
                    count=1;
                }
            }
        }
        return false;
	}
	
	boolean checkBackSlash() {
        int count = 1;
        int a = 1;
        for(int i=0; i<SIZE-4; i++) {
            for(int j=0; j<SIZE-4; j++) {
                Color c = chesses[i][j].color;
                while (c != null && a<5) { 
                    if (c==chesses[i+a][j+a].color){
                        count += 1;
                    }
                    a += 1;
                }
                if (count == 5) {
                	if(c==Chess.BLACK) {
                		winner = "Black Win!";
                	}else {
                		winner = "White Win!";
                	}                		
                	return true;
                }
                else {
                    a = 1;
                    count = 1;
                }
            }
        }
        return false;		
	}
	
	boolean checkForwordSlash() {
        int count = 1;
        int a = 1;
        for(int i=SIZE-1; i>4; i--) {
            for(int j=0; j<SIZE-4; j++) {
                Color c = chesses[i][j].color;
                while (c != null && a<5) { 
                    if (c==chesses[i-a][j+a].color){
                        count += 1;
                    }
                    a += 1;
                }
                if (count == 5) {
                	if(c==Chess.BLACK) {
                		winner = "Black Win!";
                	}else {
                		winner = "White Win!";
                	}                		
                	return true;
                }
                else {
                    a = 1;
                    count = 1;
                }
            }
        }
        return false;		
	}
	
	class MyMouseListener extends MouseInputAdapter{ // inner class can access outer class attributes or methods
		
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
				isBlack = !isBlack; // switch to another player
				boolean isWin = fiveInLine();
				if(isWin) {
					gameOver();
				}
			}
		}
		
		Chess getChess(int mouseX, int mouseY) { // find chess by mouse click position
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
