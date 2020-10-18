package lib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Utility {
	static WebDriver driver;
	
	public Utility(String strBrowserName) {
		 driver = InitDriver.getDriverInstance(strBrowserName);
		 Global.test = Global.report.createTest(Global.automationID, Global.desciption);
	}
	
	
	
	
	public static WebDriver returnDriver() {
		return driver;
		
	}
	
	
	
	
	
	
	
	
	/**Methodname:getRecordusingFillo : it is used to retutn the recordSet based on the query
	 * return : Recordset
	 * @author  Dharmendra singh
	 *
	 */
	public static Recordset getRecordusingFillo(String fileName , String strQuery) {
		Recordset  rs=null;
		Fillo fillo=null;
		Connection con=null;
		try {
			fillo = new Fillo();
			con = fillo.getConnection(fileName);
			rs = con.executeQuery(strQuery);
		}
		catch(Exception e) {
			
		}
		finally {
			con.close();
		}
	
		return rs;
		
	}
	
	/**Methodname:getRecordusingFillo : it is used to read the modules from group control file based on the query
	 * return : List
	 * @author  Dharmendra singh
	 * @return 
	 *
	 */	
	public static List readModules(String fileName , String strQuery ) {
		Recordset  rs=null;
		List list = new ArrayList();
		
		try {
			rs = Utility.getRecordusingFillo(fileName, strQuery);
			while(rs.next()) {				
				String strModule = rs.getField("Module");
				list.add(strModule);
			}
		}
		catch(Exception e) {
			
		}
		return list;
		
	}
	
	
	/**Methodname:getRecordusingFillo : it is used to read the test cases and stored in the recordSet based on the query
	 * return : Recordset
	 * @author Dharm
	 * @return 
	 *
	 */	
	public static Recordset readTestCases(String fileName , String strQuery ) {
		Recordset  rs=null;
		
		try {
			rs = Utility.getRecordusingFillo(fileName, strQuery);	
		}
		
		catch(Exception e) {
			
		}
		return rs;
		
	}
	

}
