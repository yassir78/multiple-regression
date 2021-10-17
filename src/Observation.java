

import java.util.LinkedHashMap;

import java.util.Set;

// Represents a observation vector with a map of features and values. 
public class Observation {
	private LinkedHashMap<String, Double> features = new LinkedHashMap<String, Double>();

	public void putFeature(String feature, double value) {
		features.put(feature, value);
	}

	public double getFeature(String feature) {
		return features.get(feature);
	}

	public int size() {
		return features.size();
	}

	public Set<String> getFeatures() {
		return features.keySet();
	} 



	public String toString() {
		String output = "";
		for (String feature : getFeatures()) {
			output = output + feature + ": " + getFeature(feature) + "\n";
		}
		return output;
	}

}