package multipleLinearRegression;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observation[] observations = Filehandler.read(
				"C:\\Users\\yassi\\eclipse-workspace-1\\multipleLinearRegression\\src\\multipleLinearRegression\\data.csv");
		double[][] matrix = getMatrixOfVariables(observations.length, observations[0].size(), observations);
		double[] y = getYvector(observations[0].size(), observations);
		Utils.multipleRegression(matrix, y);
	}

	public static double[][] getMatrixOfVariables(int rows, int column, Observation[] observations) {
		double[][] matrix = new double[rows][column];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == 0) {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = observations[i].getFeature(getMapFeatures().get(j));
				}

			}
		}

		return matrix;
	}

	public static double[] getYvector(int column, Observation[] observations) {
		double[] y = new double[observations.length];
		for (int i = 0; i < observations.length; i++) {
			y[i] = observations[i].getFeature("house_price_of_unit_area");
		}

		return y;
	}

	public static Map<Integer, String> getMapFeatures() {
		Map<Integer, String> features = new HashMap<>();
		features.put(1, "transaction_date");
		features.put(2, "house_age");
		features.put(3, "distance_to_the_nearest_MRT_station");
		features.put(4, "number_of_convenience_stores");
		features.put(5, "latitude");
		features.put(6, "longitude");
		return features;
	}

	public static void displayMatrix(double[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
