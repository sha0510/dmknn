package cn.edu.tsinghua.thss.datamining.knn.core;

import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;
import cn.edu.tsinghua.thss.datamining.knn.model.Instance;

/**
 * Defines the KNN classifier that deals with instances with a continuous-valued
 * label.
 * 
 * @author Wang Yue
 * 
 */
public class ClassifierKnnContinuous extends ClassifierKnn {

	public ClassifierKnnContinuous(int k, DataSet trainingset) {
		super(k, trainingset);
	}

	@Override
	public double classifyNewInstance(Instance newinstance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
