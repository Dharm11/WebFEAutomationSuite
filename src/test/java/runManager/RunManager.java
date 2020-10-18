package runManager;

import java.lang.reflect.Method;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import lib.Global;
import lib.Reporting;
import lib.Utility;

public class RunManager {

	public static void main(String[] args) throws Exception {
		Reporting.createHTMLReport();
		List listModules = Utility.readModules(Global.groupControlFile, Global.moduleQuery);
		
		for(int i=0;i<listModules.size();i++) {
			String strModuleName= (String) listModules.get(i);
			String strTestCaseQuery =  "select * from " + strModuleName + " where Run = 'Y'";
			Recordset  rs = Utility.readTestCases(Global.groupControlFile, strTestCaseQuery);
			
			while(rs.next()) {
				Global.id = rs.getField("ID");
				Global.automationID = rs.getField("AutomationID");
				Global.desciption = rs.getField("Desciption");
				String strComponents = rs.getField("BatchFile");
				String []  arrComponents = strComponents.split("_");
				
				new Utility(Global.strBrowserName);
				
				for(int j= 0;j<arrComponents.length;j++) {
					String strClassName = arrComponents[j].split("\\.")[0];
					Global.className=strClassName;
					String strMethodName = arrComponents[j].split("\\.")[1];
					Global.methodName=strMethodName;
					
					//Reflection
					Class cls = Class.forName("pages."+strClassName);
					Object obj = cls.newInstance();
					Method m = cls.getMethod(strMethodName);
					m.invoke(obj);
				}
				
			}
				
		}
		
		Global.report.flush();
		
		
		
		
		
		

	}

}
