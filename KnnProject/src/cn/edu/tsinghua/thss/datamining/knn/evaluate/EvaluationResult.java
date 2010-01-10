package cn.edu.tsinghua.thss.datamining.knn.evaluate;

/**
 * Defines the result of the evaluation, which contains the classification
 * accuracy, the true positive rates, false positive rates, recall and
 * precision, etc.
 * 
 * @author Wang Yue
 * 
 */
public class EvaluationResult {
	private int matrix_size;
	private int[][] matrix;
	private int dataset_size;
	private double[] tp_rate;
	private double[] fp_rate;
	private double[] precision;
	private double[] recall;

	private int tp_total;
	private double accuracy;

	/**
	 * Instantiates an evaluation result.
	 * 
	 * @param confusionMatrix
	 *            the confusion matrix
	 * @param dataset_size
	 *            the size of the test set
	 */
	public EvaluationResult(int[][] confusionMatrix, int dataset_size) {
		this.matrix = confusionMatrix;
		this.dataset_size = dataset_size;
		matrix_size = matrix[0].length;
		recall = tp_rate = new double[matrix_size];
		fp_rate = new double[matrix_size];
		precision = new double[matrix_size];

		evaluate();
	}

	/**
	 * Caculate the evaluation indicators.
	 */
	private void evaluate() {
		// Compute accuracy
		for (int i = 0; i < matrix_size; i++)
			tp_total += matrix[i][i];
		accuracy = ((double) (tp_total)) / dataset_size;

		// Compute recall(TP Rate)
		for (int i = 0; i < matrix_size; i++) {
			double temp_sum = 0;
			for (int j = 0; j < matrix_size; j++)
				temp_sum += matrix[i][j];
			recall[i] = matrix[i][i] / temp_sum;
		}

		// Compute precision
		for (int i = 0; i < matrix_size; i++) {
			double temp_sum = 0;
			for (int j = 0; j < matrix_size; j++)
				temp_sum += matrix[j][i];
			precision[i] = matrix[i][i] / temp_sum;
		}
	}

	/**
	 * Get the confusion matrix
	 * 
	 * @return the confusion matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * Get the total number of instances in the test set.
	 * 
	 * @return the size of the test set
	 */
	public int getDataset_size() {
		return dataset_size;
	}

	/**
	 * Get values of the recall indicator.
	 * 
	 * @return the recall values.
	 */
	public double[] getRecall() {
		return recall;
	}

	/**
	 * Get values of the precision indicator
	 * 
	 * @return the precision values
	 */
	public double[] getPrecision() {
		return precision;
	}

	/**
	 * Get the classification accuracy.
	 * 
	 * @return the classification accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}

	/**
	 * Get the number of classes of the target attribute
	 * 
	 * @return the number of classes
	 */
	public int getMatrix_size() {
		return matrix_size;
	}

	/**
	 * Get values of the true positive rate.
	 * 
	 * @return true positive rates
	 */
	public double[] getTp_rate() {
		return tp_rate;
	}

	/**
	 * Get values of the false positive rate.
	 * 
	 * @return false positive rates
	 */
	public double[] getFp_rate() {
		return fp_rate;
	}

	/**
	 * Get the number of correctly classified instances.
	 * 
	 * @return the number of correctly classified instances
	 */
	public int getTp_total() {
		return tp_total;
	}
}
