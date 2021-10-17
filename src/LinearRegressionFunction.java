import java.util.Arrays;
import java.util.function.Function;

public class LinearRegressionFunction implements Function<Double[], Double> {
   private final double[] thetaVector;

   LinearRegressionFunction(double[] thetaVector) {
      this.thetaVector = Arrays.copyOf(thetaVector, thetaVector.length);
   }

   public Double apply(Double[] featureVector) {
      // for computational 
      assert featureVector[0] == 1.0;

      // sequential implementation
      double prediction = 0;
      for (int j = 1; j < thetaVector.length; j++) {
         prediction += thetaVector[j] * featureVector[j];
      }
      prediction += thetaVector[0];
      return prediction;
   }

   public double[] getThetas() {
      return Arrays.copyOf(thetaVector, thetaVector.length);
   }
}