package cn.edu.tsinghua.thss.datamining.knn.core;

import java.util.Vector;

import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;
import cn.edu.tsinghua.thss.datamining.knn.model.Instance;

public class ClassifierKnnDiscrete extends ClassifierKnn {

	public ClassifierKnnDiscrete(int k, DataSet trainingset) {
		super(k, trainingset);
	}

	@Override
	public double classifyNewInstance(Instance newinstance) {
		Vector<Instance> nearestNeighbours = getNearestNeighbours(newinstance);
		int label_num = trainingset.getTarget().getAttribute_values().size();
		int[] label_count = new int[label_num];
		for (int i = 0; i < label_num; i++)
			label_count[i] = 0;
		for (int i = 0; i < nearestNeighbours.size() - 1; i++) {
			int label = (int) (nearestNeighbours.get(i).getLabel());
			label_count[label]++;
		}
		int max = 0;
		int max_label = -1;
		for (int i = 0; i < label_num; i++)
			if (label_count[i] > max) {
				max = label_count[i];
				max_label = i;
			}

		return max_label;
	}

}
