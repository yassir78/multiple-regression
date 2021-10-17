
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class Utils {
	private static double[] thetas;

	public static void multipleRegression(double[][] matrix, double[] y) {
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
		regression.newSampleData(y, matrix);
		thetas = regression.estimateRegressionParameters();

		System.out.println("");
		System.out.println("");

		System.out.print("Y = ");
		for (int i = 0; i < thetas.length; i++) {
			if (i == 0) {
				System.out.print(thetas[i] + " + ");
			} else {
				System.out.print(thetas[i] + " X" + i + " +");
			}

		}
	}

	public static double[] getThetas() {
		return thetas;
	}

	public static void setThetas(double[] betas) {
		for (int i = 0; i < betas.length; i++) {
			System.out.println(betas[i]);
		}
		Utils.thetas = betas;
	}

	public static double predict(double[] featureVector) {
		// the theta vector used here was output of a train process
		double[] thetaVector = getThetas();
		LinearRegressionFunction targetFunction = new LinearRegressionFunction(thetaVector);
		// prediction

		double predictedPrice = targetFunction.apply(ArrayUtils.toObject(featureVector));
		return predictedPrice;
	}

	public static double cost(double[][] dataset, double[] y) {
		int m = dataset.length;
		System.out.println("$len");
		System.out.println(m);
		double sumSquaredErrors = 0;

		for (int i = 0; i < m; i++) {

			double[] featureVector = new double[dataset[i].length + 1];
			featureVector[0] = 1;

			for (int j = 0; j < dataset[i].length; j++) {
				featureVector[j + 1] = dataset[i][j];
			}

			double predicted = predict(featureVector);
			double label = y[i];
			double gap = predicted - label;
			sumSquaredErrors += Math.pow(gap, 2);
		}

		return (1.0 / (2 * m)) * sumSquaredErrors;
	}

	public static void train( double[][] dataset,
			double[] y, double alpha) {
		int m = dataset.length;
		double[] thetaVector = getThetas();
		double[] newThetaVector = new double[thetaVector.length];

       // compute the new theta of each element of the theta array
		for (int j = 0; j < thetaVector.length; j++) {
			double sumErrors = 0;
			for (int i = 0; i < m; i++) {
				
				double[] featureVector = new double[dataset[i].length + 1];
				featureVector[0] = 1;

				for (int k = 0; k < dataset[i].length; k++) {
					featureVector[k + 1] = dataset[i][k];
				}
				double error = predict(featureVector) - y[i];
				sumErrors += error * featureVector[j];
			}

             // compute the new theta value
			double gradient = (1.0 / m) * sumErrors;
			newThetaVector[j] = thetaVector[j] - alpha * gradient;
		}
        
		
		setThetas(newThetaVector);
		
	}

}
