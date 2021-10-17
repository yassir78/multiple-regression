
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Filehandler {
	public static Observation[] read(String filePath) {
		File input = new File(filePath);
		BufferedReader reader = null;
		Observation[] obsArr = null;

		// Reads the input file.
		try {
			String text = null;

			
			reader = new BufferedReader(new FileReader(filePath));
			int size = -1;
			while ((text = reader.readLine()) != null) {
				size++;
			}
			obsArr = new Observation[size];

			
			// object in the array.
			reader = new BufferedReader(new FileReader(filePath));
			String[] features = reader.readLine().split(",");
			int index = 0;
			while ((text = reader.readLine()) != null) {
				String[] values = text.split(",");
				obsArr[index] = new Observation();
				for (int i = 0; i < features.length; i++) {
					obsArr[index].putFeature(features[i], Double.parseDouble(values[i]));
				}
				index++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return obsArr;
	}
}
