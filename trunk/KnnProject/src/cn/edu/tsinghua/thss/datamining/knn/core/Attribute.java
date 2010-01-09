package cn.edu.tsinghua.thss.datamining.knn.core;

import java.util.Hashtable;
import java.util.Vector;

public class Attribute {
	private String attribute_name;

	/** Only for nominal features */
	private Vector<String> attribute_values;

	private Hashtable<String, Integer> hashtable;

	private double lower_bound;

	private double upper_bound;

	public Attribute(String attribute_name) {
		this(attribute_name, null);
	}

	public Attribute(String attribute_name, Vector<String> attribute_values) {
		this.attribute_name = attribute_name;
		this.attribute_values = attribute_values;

		if (attribute_values == null) {
			return;
		}

		hashtable = new Hashtable<String, Integer>();
		for (int i = 0; i < attribute_values.size(); i++) {
			String value = attribute_values.get(i);
			if (hashtable.containsKey(value)) {
				throw new IllegalArgumentException("A nominal attribute ("
						+ attribute_name + ") cannot"
						+ " have duplicate labels (" + value + ").");
			}
			hashtable.put(value, i);
		}
	}

	public double getNumericValue(String value) {
		return hashtable.get(value);
	}

	public String getAttribute_name() {
		return attribute_name;
	}

	public void setAttribute_name(String attributeName) {
		attribute_name = attributeName;
	}

	public Vector<String> getAttribute_values() {
		return attribute_values;
	}

	public void setAttribute_values(Vector<String> attributeValues) {
		attribute_values = attributeValues;
	}

	public double getLower_bound() {
		return lower_bound;
	}

	public void setLower_bound(double lowerBound) {
		lower_bound = lowerBound;
	}

	public double getUpper_bound() {
		return upper_bound;
	}

	public void setUpper_bound(double upperBound) {
		upper_bound = upperBound;
	}
}
