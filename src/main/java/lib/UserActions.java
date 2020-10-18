package lib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserActions {
	
	static WebDriver driver;
	static WebDriverWait  wait;
	
	
	/**Methodname:enterText : it is used to enter the text into the text box
	 * return : boolean
	 * @author  Dharmendra singh

	 *
	 */
	public static boolean enterText(WebElement ele , String label , String strColumn)  {
		
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return true;
		}
		
		try {
			waitTillElementIsVisbile(ele);
			ele.sendKeys(strValue);
			Reporting.writeHtmlLogs("PASS", "sucessfully enter the " + strValue + " in the text box " + label);
			//Reporting.takeScreenshot("PASS");
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to enter the " + strValue + " in the text box " + label + "  . " + e.getMessage());
		}
		return true;
		
		
	}
	
	/**Methodname: clickElement : it is used to click on the webelement
	 * return : boolean
	 * @author  Dharmendra singh
	 *
	 */
	public static boolean clickElement(WebElement ele , String label , String strColumn) {
		
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return true;
		}
		
		try {
			waitTillElementIsVisbile(ele);
			ele.click();
			Reporting.writeHtmlLogs("PASS", "sucessfully click on " + label);
			Reporting.takeScreenshot("PASS");
		
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to  click on " + label + " " +e.getMessage());
		}
		return true;
		
		
	}
	
	
	
	
	
	/**Methodname: ngGetText : it is used to return the text of webelement
	 * return : String
	 * @author Dharmendra singh
	 *
	 */
	public static String ngGetText(WebElement ele , String label , String strColumn) {
		
		String text="";
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return "";
		}
		
		try {
			waitTillElementIsVisbile(ele);
			text = ele.getText().replaceAll("[^0-9]", "").trim();
			Reporting.writeHtmlLogs("PASS", "text : " + text + " for " + label);
			Reporting.takeScreenshot("PASS");
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to get text for  " +label + " "  +e.getMessage());
		}
		return text;		
	}
	
	/**Methodname: acceptIfAlertPresent : it is used to accept the alert pop-up
	 * return : String
	 * @author Dharmendra singh
	 *
	 */
	public static String acceptIfAlertPresent(String strColumn) {
		Alert ale=null;
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return "";
		}
			
		try {
			wait = new WebDriverWait(Utility.returnDriver(), 20);
			ale = wait.until(ExpectedConditions.alertIsPresent());
			ale.accept();
		}
		catch(Exception e) {
			
		}
		return strValue;
	
	}
	
	

	/**Methodname: waitTillElementIsVisbile : driver will wait untill element is visible
	 * return : void
	 * @author Dharmendra singh
	 *
	 */
	public static void waitTillElementIsVisbile(WebElement ele) {
			
		try {
			wait = new WebDriverWait(Utility.returnDriver(), 30);
			wait.until(ExpectedConditions.visibilityOf(ele));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
	}	
	

	/**Methodname: clickElementUsingAction : it is used to click on the webelement using Action class
	 * return : boolean
	 * @author  Dharmendra singh
	 *
	 */
	public static boolean clickElementUsingAction(WebElement ele , String label , String strColumn)  {
		
		Actions act = new Actions(Utility.returnDriver());
		String strValue = TestData.readValueBasedOnTheKey(strColumn);
		
		if(strValue.contains("SKIP")|| strValue.contentEquals("")) {			
			return true;
		}
		
		try {
			waitTillElementIsVisbile(ele);
			waitTillElementIsClickable(ele,30);
			act.moveToElement(ele).pause(Duration.ofSeconds(15)).click().perform();
			clickElementUsingJs(ele);
			Reporting.writeHtmlLogs("PASS", "sucessfully click on " + label);
			//Reporting.takeScreenshot("PASS");
		
		}
		catch(Exception e) {
			Reporting.writeHtmlLogs("FAIL", "Failed to  click on " + label + " " +e.getMessage());
			try {
				Reporting.takeScreenshot("FAIL");

			}
			catch(Exception e1) {
				Reporting.writeHtmlLogs("FAIL", "Failed to  click on " + label + " " +e.getMessage());
			}
					}
		return true;
		
		
	}
	
	

	/**Methodname: waitTillElementIsClickable : driver will wait untill element is clickable
	 * return : void
	 * @author Dharmendra singh
	 *
	 */
	public static void waitTillElementIsClickable(WebElement ele , int time) {
			
		try {
			wait = new WebDriverWait(Utility.returnDriver(), time);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	
	/**Methodname: clickElementUsingJs : it is used to click on the webelement using javascript executor
	 * return : void
	 * @author  Dharmendra singh
	 *
	 */
	public static void clickElementUsingJs(WebElement ele)  {
		try {
			 Thread.sleep(500);
			 ((JavascriptExecutor)Utility.returnDriver()).executeScript("arguments[0].click", ele);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 
		
	}

	
	

	

	
	
	
	
	

}
