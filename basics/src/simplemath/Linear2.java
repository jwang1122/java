package simplemath;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/**
 * 2016年时，父母年龄（整数）和是78岁，哥哥和弟弟的年龄和是17岁。
四年后（2020年）父亲的年龄是弟弟年龄的4倍，母亲的年龄是哥哥年龄的3倍.
那么当父亲的年龄是兄的年龄的3倍时，是公元哪一年？
父：x1
母：x2
兄：x3
弟：x4
几年后：x5
x1+x2=78
x3+x4=17
x1+4 = 4(x4+4)
x2+4 = 3(x3+4)
x1+x5 = 3(x3+x5)
	x1 + x2                   = 78
               x3 + x4        = 17
    x1            - 4x4       = 12
         x2 - 3x3             = 8
    x1      - 3x3       - 2x5 = 0 
 *
 */
public class Linear2 {

	public static void main(String[] args) {
		double[][] coef = new double[][] { 
			{1,1,0,0,0}, 
			{0,0,1,1,0}, 
			{1,0,0,-4,0}, 
			{0,1,-3,0,0},
			{1,0,-3,0,-2}}; 
		double[] coef1 = new double[] { 78, 17, 12, 8, 0 };
		RealMatrix coefficients = new Array2DRowRealMatrix(coef, false);
		DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(coef1, false);
		RealVector solution = solver.solve(constants);
		System.out.println(solution);
		System.out.printf("当父亲的年龄是兄的年龄的3倍时，是公元%.0f年。\n",(solution.getEntry(4)+2016));
	}

}
