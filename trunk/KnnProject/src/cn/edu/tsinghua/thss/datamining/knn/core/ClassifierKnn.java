package cn.edu.tsinghua.thss.datamining.knn.core;

import java.util.Vector;

import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;
import cn.edu.tsinghua.thss.datamining.knn.model.Instance;

public abstract class ClassifierKnn {
	private int k;
	private DataSet trainingset;

	public ClassifierKnn(int k, DataSet trainingset) {
		if (k <= 0)
			throw new IllegalArgumentException("K must be greater than zero!");
		this.k = k;
		this.trainingset = trainingset;
	}

	public double classifyNewInstance(Instance newinstance) {

		return 0;
	}

	public Vector<Instance> getNearestNeighbours(Instance newinstance) {
		Vector<Instance> neighbors = new Vector<Instance>();
		Vector<Double> distances = new Vector<Double>();
		for (Instance instance : trainingset.getInstances()) {
			double distance = getDistance(instance, newinstance);
			for (int i = 0; i < neighbors.size(); i++) {
				if (distances.get(i) > distance) {
					neighbors.insertElementAt(newinstance, i);
					distances.insertElementAt(distance, i);
				}
			}
		}

		return neighbors;
	}

	protected double getDistance(Instance a, Instance b) {
		int attr_num = trainingset.getFeatures().size();
		double distance = 0;
		for (int i = 0; i < attr_num; i++) {
			double x = a.getFeature_values().get(i);
			double y = b.getFeature_values().get(i);
			distance += (x - y) * (x - y);
		}
		return Math.sqrt(distance);
	}

	public DataSet getTrainingset() {
		return trainingset;
	}

	public void setTrainingset(DataSet trainingset) {
		this.trainingset = trainingset;
	}

}
