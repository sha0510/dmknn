package cn.edu.tsinghua.thss.datamining.knn.model;

import java.util.Vector;

public class Instance {
	private Vector<Double> feature_values;
	private DataSet dataset;
	private double label;

	public Instance(Vector<Double> feature_values, double label) {
		this.feature_values = feature_values;
		this.label = label;
		if (label == Double.NaN)
			throw new IllegalArgumentException("Label cannot be missing!");
	}

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

	public boolean isMissing(int i) {
		if (i >= feature_values.size())
			throw new IllegalArgumentException("Out of bound!");
		return feature_values.get(i) == Double.NaN;
	}

	public void setValue(int i, double value) {
		feature_values.set(i, value);
	}

	public String toString() {
		String text = "<";
		for (double value : feature_values)
			text += value + ",";
		text += label;
		text += ">";
		return text;
	}

}
