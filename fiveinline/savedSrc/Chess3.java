package fiveinline;

import java.awt.Color;

public class Chess {
	public static final int SIZE = 30;
	public static final Color BLACK = Color.black;
	public static final Color WHITE = Color.white;
	
	public int i, j; // indexes
	public int x, y; // coordinates
	public Color color = null;
	
	public Chess(int i, int j) {
		this.i = i;
		this.j = j;
		x = (i+1) * SIZE;
		y = (j+1) * SIZE;		
	}
}
