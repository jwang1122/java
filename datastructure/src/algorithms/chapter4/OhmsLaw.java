package algorithms.chapter4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class OhmsLaw {

	public static void main(String[] args) {
		double v = 5;
		double r1 = 10000;
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter resistency for resistor r2: ");
		double r2 = input.nextDouble();
		BigDecimal[] valtages = getVoltages(v, r1, r2);
		System.out.printf("the valtage v1 and v2 are %s\n", Arrays.toString(valtages));
		input.close();
	}

	private static BigDecimal[] getVoltages(double v, double r1, double r2) {
		double r = r1 + r2;
		double i = v / r; // Ohm's law
		double v2 = i * r2;
		double v1 = i * r1;
		BigDecimal v1big = new BigDecimal(v1).setScale(2,RoundingMode.HALF_UP);
		BigDecimal v2big = new BigDecimal(v2).setScale(2,RoundingMode.HALF_UP);
		BigDecimal[] valtages = {v1big, v2big};
		return valtages;
	}

}
