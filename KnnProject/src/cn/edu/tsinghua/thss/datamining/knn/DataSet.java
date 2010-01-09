package cn.edu.tsinghua.thss.datamining.knn;

import java.util.List;
import java.util.Vector;

public class DataSet {
	private int size;
	private Vector<Attribute> features;
	private Attribute target;
	private List<Instance> instances;

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
}
