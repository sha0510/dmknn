package cn.edu.tsinghua.thss.datamining.knn.evaluate;

import cn.edu.tsinghua.thss.datamining.knn.core.ClassifierKnn;
import cn.edu.tsinghua.thss.datamining.knn.model.Attribute;
import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;
import cn.edu.tsinghua.thss.datamining.knn.model.Instance;

public class Evaluator {
	private ClassifierKnn classifier;
	private DataSet testset;

	private Attribute target_attribute;
	private int label_num;
	private int[][] confusion_matrix;

	public Evaluator(ClassifierKnn classifier, DataSet testset) {
		this.classifier = classifier;
		this.testset = testset;
		testset.replaceMissingValues();
		target_attribute = testset.getTarget();
		label_num = target_attribute.getLabelNum();
		confusion_matrix = new int[label_num][label_num];
		for (int i = 0; i < label_num; i++)
			for (int j = 0; j < label_num; j++)
				confusion_matrix[i][j] = 0;
	}

	public EvaluationResult evaluateClassification() {
		for (Instance instance : testset.getInstances()) {
			double label = classifier.classifyNewInstance(instance);
			double label_check = instance.getLabel();
			int label_class = target_attribute.getLabelClass(label);
			int check_class = target_attribute.getLabelClass(label_check);
			System.out.println("Label:" + label + "VS" + label_check);
			if (label_class == check_class)
				confusion_matrix[label_class][label_class]++;
			else
				confusion_matrix[check_class][label_class]++;

		}
		EvaluationResult result = new EvaluationResult(confusion_matrix,
				testset);
		return result;
	}
}
