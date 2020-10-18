package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationUtility {
	
	static WebDriver driver;
	
	/**Methodname: deleteLaptopBasedOnText : it is used to delete the laptop using text
	 * return : ""
	 * @author Dharmendra singh
	 *
	 */
	public static String deleteLaptopBasedOnText(String strColumn) {		
		String strValue = TestData.readValueBasedOnTheKey(strColumn);	
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return "";
		}		
		try {
			driver = Utility.returnDriver();
			String strXpath = ApplicationConst.laptopDelete.replace("@placeholder@", strValue).trim();
			WebElement ele = new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath(strXpath)));
			ele.click();
			Reporting.writeHtmlLogs("PASS", "sucessfully delete laptop i.e. --> " + strValue);
			Reporting.takeScreenshot("PASS");
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to  delete  " + strValue + " " +e.getMessage());
		}
		return strValue;				
	}
	
	/**Methodname: clickLaptopBasedOnText : it is used to click on the laptop using text
	 * return : boolean
	 * @author Dharmendra singh
	 *
	 */
	public static boolean clickLaptopBasedOnText(String strColumn) {	
		String strValue = TestData.readValueBasedOnTheKey(strColumn);		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return true;
		}		
		try {
			driver = Utility.returnDriver();
			String strXpath = ApplicationConst.laptop.replace("@placeholder@", strValue).trim();
			driver.findElement(By.xpath(strXpath)).click();
			Reporting.writeHtmlLogs("PASS", "sucessfully click on " + strValue);
			Reporting.takeScreenshot("PASS");
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to  click on " + strValue + " " +e.getMessage());
		}
		return true;
			
	}
	
	/**Methodname: ngGetText : it is used to return the actual amount from the confirmation dialog box
	 * return : String
	 * @author Dharmendra singh
	 *
	 */
	public static String getActualAmount(WebElement ele , String label , String strColumn) {
		
		String text="";
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return "";
		}
		
		try {
			UserActions.waitTillElementIsVisbile(ele);
			text = ele.getText().split("USD")[0].split("Amount:")[1].trim();
			Reporting.writeHtmlLogs("PASS", "actual amount is displayed " + text + " in comfirmation pop-up");
			Reporting.takeScreenshot("PASS");
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to get text for  " +label + " "  +e.getMessage());
		}
		return text;
		
		
	}
	
	/**Methodname: verifyAmount : it is used to validate actual and expected amount
	 * return : boolean
	 * @author Dharmendra singh
	 *
	 */
	public static boolean  verifyAmount(String strActualAmount , String strexpectedAmount , String strColumn) {
		boolean flag = false;
		String text="";
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return flag;
		}
			
			if(strActualAmount.contentEquals(strexpectedAmount)) {
				Reporting.writeHtmlLogs("PASS", "actual and expected amount is matched .Actual amount -- > " + strActualAmount +" . Expected amount -- > " + strexpectedAmount );
				flag =true;
			}	
			else {
				Reporting.writeHtmlLogs("PASS", "actual and expected amount is NOT matched .Actual amount -- > " + strActualAmount +" . Expected amount -- > " + strexpectedAmount );
			}
			return flag;
			
	}

}
