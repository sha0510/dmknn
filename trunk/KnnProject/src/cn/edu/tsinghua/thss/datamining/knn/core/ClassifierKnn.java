package cn.edu.tsinghua.thss.datamining.knn.core;

import java.util.Vector;

import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;
import cn.edu.tsinghua.thss.datamining.knn.model.Instance;

public abstract class ClassifierKnn {
	private int k;
	protected DataSet trainingset;
	private int weight_type;
	
	public static final int WEIGHT_NONE=1;
	public static final int WEIGHT_INVERSE=2;
	public static final int WEIGHT_SIMILARITY=3;

	public ClassifierKnn(int k, DataSet trainingset) {
		if (k <= 0)
			throw new IllegalArgumentException("K must be greater than zero!");
		this.k = k;
		this.trainingset = trainingset;
		trainingset.replaceMissingValues();
		this.weight_type=WEIGHT_NONE;
	}

	public abstract double classifyNewInstance(Instance newinstance) ;

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
				if (neighbors.size() > k)
					neighbors.remove(neighbors.size() - 1);
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
