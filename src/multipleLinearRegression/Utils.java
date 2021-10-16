package multipleLinearRegression;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class Utils {

	public static void multipleRegression(double[][] matrix, double[] y) {
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
		regression.newSampleData(y, matrix);
		double[] beta = regression.estimateRegressionParameters();
		for (int i = 0; i < beta.length; i++) {
			System.out.println(beta[i]);
		}
	}
}
