package cn.edu.tsinghua.thss.datamining.knn;

import java.util.Vector;

public class Instance {
	private Vector<Double> feature_values;
	private DataSet dataset;
	private double label;

	public Vector<Double> getFeature_values() {
		return feature_values;
	}

	public void setFeature_values(Vector<Double> featureValues) {
		feature_values = featureValues;
	}

	public DataSet getDataset() {
		return dataset;
	}

	public void setDataset(DataSet dataset) {
		this.dataset = dataset;
	}

	public double getLabel() {
		return label;
	}

	public void setLabel(double label) {
		this.label = label;
	}

}
