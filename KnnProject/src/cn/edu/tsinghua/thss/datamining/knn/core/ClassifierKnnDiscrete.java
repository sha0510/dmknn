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
		// TODO Auto-generated method stub
		Vector<Instance> nearestNeighbours = getNearestNeighbours(newinstance);
		Vector<Integer> target_val_count = new Vector<Integer>();
		for (int i = 0; i < nearestNeighbours.size() - 1; i++) {
			int label = (int) (nearestNeighbours.get(i).getLabel());
			if (target_val_count.elementAt(label) == null)
				target_val_count.insertElementAt(label, 0);
			target_val_count.set(label, target_val_count.elementAt(label) + 1);
		}
		return 0;
	}

}
