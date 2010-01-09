package cn.edu.tsinghua.thss.datamining.knn.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import cn.edu.tsinghua.thss.datamining.knn.model.Attribute;
import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;
import cn.edu.tsinghua.thss.datamining.knn.model.Instance;


public class ArffTransformer {
	private String file_path;
	private DataSet dataset;

	public ArffTransformer(String file_path) {
		this.file_path = file_path;
	}

	public DataSet getDatasetFromFile() {

		// Needs implementation here.
		Vector<Attribute> attributes=new Vector<Attribute>();
		try {
			FileReader fr = new FileReader(file_path);
			BufferedReader br = new BufferedReader(fr);
			String Line = br.readLine();
			Line=br.readLine();
			Line=br.readLine();

			while (Line.length()!=0) //go to the third line
			{
				String[] spLine=Line.split(" ");
				System.out.println(spLine[2]);
				String attribute_name=spLine[1];
				int type;
				Vector<String> attribute_values=new Vector<String>();
				if(spLine[2].equals("numeric"))
				{
					type=Attribute.NUMERIC_TYPE;
					attribute_values.add(null);
				}
				else
				{
					type=Attribute.NOMINAL_TYPE;
					String[] aValues=spLine[2].substring(1, spLine[2].length()-1).split(",");//get values between {}
					for(int i=0;i<aValues.length;i++)
					{
						attribute_values.add(aValues[i]);
					}
				}
				attributes.add(new Attribute(attribute_name,type,attribute_values));
				Line=br.readLine();					
			}
			dataset=new DataSet(attributes,attributes.get(attributes.size()-1));
			Line=br.readLine();
			if(!Line.equals("@data"))
				System.out.println("error!can't read instance date");
			else
			{
				Line=br.readLine();

			    while(Line!=null)
			    {
			    	Vector<Double> feature_values=new Vector<Double>();
			    	String[] fValues=Line.split(",");
			    	int length=fValues.length;
			    	for(int j=0;j<length;j++)
			    	{Attribute attribute = attributes.get(j);
			    	if(attribute.getAttribute_type()==Attribute.NOMINAL_TYPE)
			    		feature_values.add(attribute.getNumericValue(fValues[j]));
			    	else
			    		feature_values.add(Double.parseDouble(fValues[j]));
			    	}
			    	double lable=feature_values.get(length-1);
			    	dataset.addInstance(new Instance(feature_values,lable));
			    	Line=br.readLine();
			    }
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataset;

	}
}
