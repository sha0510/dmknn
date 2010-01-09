package cn.edu.tsinghua.thss.datamining.knn.evaluate;

public class EvaluationResult {

	private int[][] matrix;
	private int dataset_size;

	public EvaluationResult(int[][] confusionMatrix, int dataset_size) {
		this.matrix = confusionMatrix;
		this.dataset_size = dataset_size;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getDataset_size() {
		return dataset_size;
	}

	public void setDataset_size(int datasetSize) {
		dataset_size = datasetSize;
	}
}
