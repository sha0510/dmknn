package cn.edu.tsinghua.thss.datamining.knn.core;

import java.util.Vector;

import cn.edu.tsinghua.thss.datamining.knn.model.Instance;

public abstract class ClassifierKnn {
	public double classifyNewInstance(Instance newinstance) {

		return 0;
	}

	public Vector<Instance> getNearestNeighbours(Instance newinstance) {
		
		return null;
	}
	
}
