package cn.edu.tsinghua.thss.datamining.knn.control;

import cn.edu.tsinghua.thss.datamining.knn.core.ArffTransformer;
import cn.edu.tsinghua.thss.datamining.knn.core.ClassifierKnn;
import cn.edu.tsinghua.thss.datamining.knn.core.ClassifierKnnDiscrete;
import cn.edu.tsinghua.thss.datamining.knn.evaluate.EvaluationResult;
import cn.edu.tsinghua.thss.datamining.knn.evaluate.Evaluator;
import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;

public class ClassifierControl {

	public static ClassifierControl getInstance() {
		return new ClassifierControl();
	}

	public EvaluationResult doClassification(String train_file,
			String test_file, int k, int weight_type) {
		ArffTransformer arffTrans = new ArffTransformer(train_file);
		DataSet trainingset = arffTrans.getDatasetFromFile();
		arffTrans = new ArffTransformer(test_file);
		DataSet testset = arffTrans.getDatasetFromFile();
		ClassifierKnn classifier = new ClassifierKnnDiscrete(k, trainingset);
		classifier.setWeight_type(weight_type);
		Evaluator evaluator = new Evaluator(classifier, testset);
		return evaluator.evaluateClassification();
	}
}
