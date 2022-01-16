package blackjack;

import java.awt.Color;

public class MyBackgroundColor extends Color {
	private static final long serialVersionUID = 1L;
	public static final MyBackgroundColor MY_BLUE = new MyBackgroundColor(114, 183, 244, "Blue");
	public static final MyBackgroundColor MY_GREEN = new MyBackgroundColor(183, 243, 79, "Green");
	public static final MyBackgroundColor MY_YELLOW = new MyBackgroundColor(244, 215, 114, "Yellow");

	private String name;
	
	public MyBackgroundColor(int r, int g, int b, String name){
		super(r, g, b);
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
