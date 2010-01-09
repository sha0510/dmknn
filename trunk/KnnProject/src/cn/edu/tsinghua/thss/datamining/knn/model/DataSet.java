package cn.edu.tsinghua.thss.datamining.knn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DataSet {
	private int size;
	private Vector<Attribute> features;
	private Vector<Double> feature_missing_values;
	private Attribute target;
	private List<Instance> instances;

	public DataSet(Vector<Attribute> features, Attribute target) {
		this.features = features;
		this.target = target;
		this.feature_missing_values = new Vector<Double>();
		size = 0;
		instances = new ArrayList<Instance>();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Vector<Attribute> getFeatures() {
		return features;
	}

	public void setFeatures(Vector<Attribute> features) {
		this.features = features;
	}

	public Attribute getTarget() {
		return target;
	}

	public void setTarget(Attribute target) {
		this.target = target;
	}

	public List<Instance> getInstances() {
		return instances;
	}

	public void setInstances(List<Instance> instances) {
		this.instances = instances;
	}

	public void addInstance(Instance instance) {
		instances.add(instance);
		instance.setDataset(this);
		size++;
	}

	public void replaceMissingValues() {
		for (int i = 0; i < features.size(); i++)
			feature_missing_values.set(i, features.get(i).getMissingValue());
		for (int i = 0; i < instances.size(); i++) {
			Instance instance = instances.get(i);
			if (instance.isMissing(i))
				instance.setValue(i, features.get(i).getMissingValue());
		}
	}
}
