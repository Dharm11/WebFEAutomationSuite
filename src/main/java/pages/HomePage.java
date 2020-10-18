package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lib.ApplicationUtility;
import lib.Global;
import lib.TestData;
import lib.UserActions;
import lib.Utility;

public class HomePage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//a[text()='Laptops']")
	public static WebElement lnk_H_Laptop;

	
	public HomePage() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Business components (it just method)
	public void home() throws IOException {		
		Global.dataMap = TestData.readTestData(Global.id, Global.className, Global.methodName);		
		driver.get(Global.appURL);
		UserActions.clickElement(lnk_H_Laptop, "laptop link", "H_laptopClick");
		ApplicationUtility.clickLaptopBasedOnText("H_laptopName");
		
		
	}
	
	
	
	
	


}
