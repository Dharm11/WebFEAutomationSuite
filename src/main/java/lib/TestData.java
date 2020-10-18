package lib;

import java.util.HashMap;
import java.util.Map;

import com.codoid.products.fillo.Recordset;

public class TestData {
	
	
	/**Methodname:readTestData : it is used to read the test data based on the className and method name
	 * return : Recordset
	 * @author  Dharmendra singh
	 * @return 
	 *
	 */	
	public static Map readTestData(String id , String strClassName ,  String strMethodName) {
		HashMap m = new HashMap();
		
		String strQuery = "select * from " + strMethodName +" where ID = '"+ id +"' ";
		String fileName = Global.testArtifacts + "TestData_"+strClassName+".xlsx";
		
		try {
			Recordset rs = Utility.getRecordusingFillo(fileName, strQuery);
			while(rs.next()) {
				for(int i=0 ; i<rs.getFieldNames().size();i++) {
					String strColumnName = rs.getField(i).name();
					String strvalue = rs.getField(i).value();
					m.put(strColumnName, strvalue);
				}
				
			}
		}
		catch(Exception e) {
			
		}
		
		return m;
		
	}
	
	
	
	
	
	public static String readValueBasedOnTheKey(String StrKey) {
		
		String strValue= (String) Global.dataMap.get(StrKey.toUpperCase());
		return strValue;
		
	}

}
