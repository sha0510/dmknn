import java.util.Vector;

import cn.edu.tsinghua.thss.datamining.knn.core.ArffTransformer;
import cn.edu.tsinghua.thss.datamining.knn.model.Attribute;
import cn.edu.tsinghua.thss.datamining.knn.model.DataSet;


public class TestArffTrans {
	 public static void main(String[] args) {

         ArffTransformer arffTrans=new ArffTransformer("d:/test.arff");
         DataSet ds=arffTrans.getDatasetFromFile();
         Vector<Attribute> features=ds.getFeatures();
         for(int i=0;i<features.size();i++)
         {
        	 System.out.println(features.get(i).getAttribute_name());
         }
     }


}
