

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Utils utils = new Utils();
		// Load dataset
		Observation[] observations = Filehandler.read(
				"C:\\Users\\Belkoweb\\sms\\ML_LR_\\src\\data.csv");
		double[][] matrix = getMatrixOfVariables(observations.length, observations[0].size(), observations);
		 // displayMatrix(matrix);
		double[] y = getYvector(observations[0].size(), observations);
		
		Utils.multipleRegression(matrix, y);
		System.out.println("");
		System.out.println("");
	  //Predict  
		// create the feature vector 
		double[] featureVector = new double[] { 1.0, 2012.92, 32.0, 84.85, 10.0, 24.98, 121.64};
		double predictedPrice = utils.predict(featureVector);
		System.out.println("Predction Value: "+predictedPrice);
		
		
		double cost = utils.cost(matrix, y);
	   System.out.println("Cost : "+cost);
	   
	   
	   do {
		   
		   utils.train(matrix, y, 0.1); 
		   
	   } while(utils.cost(matrix, y) > 5);
	
	   
	   
		System.out.println("");
		System.out.println("");
	  //Predict  
		// create the feature vector
		double[] featureVector2 = new double[] { 1.0, 2012.92, 32.0, 84.85, 10.0, 24.98, 121.64};
		double predictedPrice2 = utils.predict(featureVector2);
		System.out.println("Predction Value: "+predictedPrice2);
		
		
		double cost2 = utils.cost(matrix, y);
	   System.out.println("Cost : "+cost2);
	   
	   
	   
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static double[][] getMatrixOfVariables(int rows, int column, Observation[] observations) {
		double[][] matrix = new double[rows][column-1];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				 if(j< 6)
					matrix[i][j] = observations[i].getFeature(getMapFeatures().get(j));
				

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
		features.put(0, "transaction_date");
		features.put(1, "house_age");
		features.put(2, "distance_to_the_nearest_MRT_station");
		features.put(3, "number_of_convenience_stores");
		features.put(4, "latitude");
		features.put(5, "longitude");
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
