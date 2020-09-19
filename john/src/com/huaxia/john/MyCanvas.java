package com.huaxia.john;

import java.awt.*;
import javax.swing.JFrame;

public class MyCanvas extends Canvas {

	private static final long serialVersionUID = 1L;
	static final String FOLDER = "C:/Users/12818/workspace/java/john/doc/";
	static final String RANGERS1 = "TexasRangers.png";
	static final String RANGERS2 = "Rangers.png";
	static final String ASTROS1 = "HoustonAstros.png";
	static final String ASTROS2 = "Astros.png";
	static final String MAVERICKS1 = "DallasMavericks.png";
	static final String MAVERICKS = "Mavericks.png";
	static final String ROCKETS1 = "HoustonRockets.png";
	static final String ROCKETS2 = "Astros.png";
	
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage(FOLDER + ASTROS1);
		g.drawImage(i, 0, 0, this);
		i = t.getImage(FOLDER + RANGERS1);
		g.drawImage(i, 300, 0, this);
		i = t.getImage(FOLDER + MAVERICKS1);
		g.drawImage(i, 0, 300, this);
		i = t.getImage(FOLDER + ROCKETS1);
		g.drawImage(i, 300, 300, this);
		

	}

	public static void main(String[] args) {
		MyCanvas m = new MyCanvas();
		JFrame f = new JFrame();
		f.add(m);
		f.setSize(600, 600);
		f.setVisible(true);
	}

}