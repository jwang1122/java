package snake;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Snake1 {
	Image head;
	Image tail;
	ArrayList<Position> bodies = new ArrayList<>();
	
	public Snake1(Image head, Image tail) {
		super();
		this.head = head;
		this.tail = tail;
		bodies.add(new Position(100,100)); // head topleft coordinates
		bodies.add(new Position(100,90)); // tail topleft
	}

	public void draw(JPanel mainPnl) {
		// TODO Auto-generated method stub
		
	}

}
