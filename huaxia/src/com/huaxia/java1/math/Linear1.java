package com.huaxia.java1.math;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
   * 几个老头去赶集，上街看到一堆梨，一人一个多一个，一人俩梨少俩梨。
   * 请问几个老头几个梨？ 
 * 
 * x: 老头儿数量
 * y: 梨子的个数
 * 
 * x * 1pear = y - 1
 * x * 2pear = y + 2
 * 
 * x - y = -1
 * 2x -y = 2
 */
public class Linear1 {

	public static void main(String[] args) {
		RealMatrix coefficients = new Array2DRowRealMatrix(new double[][] { { 1, -1 }, { 2, -1 } }, false);
		DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(new double[] { -1, 2 }, false);
		RealVector solution = solver.solve(constants);
		System.out.printf("There are %.0f old man and %.0f pears.\n",solution.getEntry(0), solution.getEntry(1));
		String s = "世界你好";
		System.out.println(s);
	}

}
