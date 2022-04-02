package blackjack;

import java.awt.Color;

public class MyColor extends Color {
	private static final long serialVersionUID = 1L;
	private String name;
	
	public MyColor(int r, int g, int b, String name) {
		super(r, g, b);
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	
}
