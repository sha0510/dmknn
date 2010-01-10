package cn.edu.tsinghua.thss.datamining.knn.core;

import java.util.Vector;

import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;
import cn.edu.tsinghua.thss.datamining.knn.model.Instance;

/**
 * Defines the KNN classifier that deals with instances with a discrete-valued
 * label.
 * 
 * @author Wang Yue
 * 
 */
public class ClassifierKnnDiscrete extends ClassifierKnn {

	/**
	 * The constructor
	 * 
	 * @param k
	 *            the number of neighbors
	 * @param trainingset
	 *            the training set
	 */
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
		for (int i = 0; i < nearestNeighbours.size(); i++) {
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

		if (max_label == -1)
			System.out.println("Error occurred!");
		return max_label;
	}

}
