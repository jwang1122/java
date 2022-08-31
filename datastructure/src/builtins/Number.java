package builtins;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Number {

	public static void main(String[] args) {
		Integer i = Integer.valueOf(100);
		Double d = Double.valueOf(14.56);
		d = d.doubleValue() + i.intValue();
		System.out.println(d);
		
		BigDecimal bd = new BigDecimal(12.34);
		System.out.println(bd.setScale(3, RoundingMode.UP));
	}

}
