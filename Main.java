import java.util.ArrayList; 
import java.util.Arrays;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
	public static void main(String[] args) {
		System.out.println("Naive_Bayes-Classification");
		Dataset dataset = new Dataset("iris_shuffled_matlab.csv");
		NaiveBayes classification = new NaiveBayes(dataset.getTrainingExamples(), dataset.getTrainingClass(), 1);
		ArrayList<String> predictions = classification.predict(dataset.getTestExamples());

		ArrayList<String> test_class = dataset.getTestClass();

		int correctPredictions = 0;
		int incorrectPredictions = 0;

		for(int i = 0; i < test_class.size(); i++) {
			if(test_class.get(i).equals(predictions.get(i))) {
				correctPredictions += 1;
			} else {
				incorrectPredictions += 1;
			}
		}

		double classificationAccuracy = Double.valueOf(correctPredictions) / Double.valueOf(test_class.size()) * 100;

		System.out.println("Correct predictions: " + correctPredictions);
		System.out.println("Incorrect predictions: " + incorrectPredictions);
		System.out.println("Classification accuracy: " + classificationAccuracy + "%");
	}
}

