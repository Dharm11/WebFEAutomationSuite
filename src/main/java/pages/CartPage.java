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

public class CartPage {
	
WebDriver driver;
	
	
	@FindBy(xpath="//a[text()='Add to cart']")
	public WebElement lnk_C_addToCart;
	
	@FindBy(xpath="//*[@class='price-container']")
	public WebElement ele_C_laptopPrice;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement lnk_C_Homelink;
	
	@FindBy(xpath="//a[text()='Cart']")
	public WebElement lnk_C_cart;
	
	@FindBy(xpath="//button[text()='Place Order']")
	public WebElement btn_C_PlaceOrder;
	
	@FindBy(id="name")
	public WebElement edt_C_Name;
	
	@FindBy(id="country")
	public WebElement edt_C_country;
	
	@FindBy(id="city")
	public WebElement edt_C_City;
	
	@FindBy(id="card")
	public WebElement edt_C_CreditCard;
	
	@FindBy(id="month")
	public WebElement edt_C_month;
	
	@FindBy(id="year")
	public WebElement edt_C_Year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	public WebElement btn_C_Purchase;
	
	@FindBy(xpath="//*[contains(@class,'lead text-muted')]")
	public WebElement ele_C_ConfirmationPopUp;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement btn_C_Ok;



	public CartPage() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//Business components (it just method)
	public void addCart() throws IOException {
		Global.dataMap = TestData.readTestData(Global.id, Global.className, Global.methodName);

		String strExpectedAmount =  UserActions.ngGetText(ele_C_laptopPrice, "laptop Price", "C_laptopPriceGet");
		UserActions.clickElement(lnk_C_addToCart, "add To Cart link", "C_addToCartClick");
		UserActions.acceptIfAlertPresent("handleAlert");
		UserActions.clickElement(lnk_C_Homelink, "Home link", "C_HomelinkClick");
		UserActions.clickElement(HomePage.lnk_H_Laptop, "laptop link", "H_laptopClick");
		ApplicationUtility.clickLaptopBasedOnText("H_laptopName");
		UserActions.clickElement(lnk_C_addToCart, "add To Cart link", "C_addToCartClick");
		UserActions.acceptIfAlertPresent("handleAlert");
		UserActions.clickElement(lnk_C_cart, "cart link", "C_cartClick");
		ApplicationUtility.deleteLaptopBasedOnText("deleteLaptopName");
		UserActions.clickElementUsingAction(btn_C_PlaceOrder, "Place Order button", "C_PlaceOrderClick");
		UserActions.enterText(edt_C_Name, "Name", "C_NameSet");
		UserActions.enterText(edt_C_country, "country", "C_countrySet");
		UserActions.enterText(edt_C_City, "City", "C_CitySet");
		UserActions.enterText(edt_C_CreditCard, "Credit Card", "C_CreditCardSet");
		UserActions.enterText(edt_C_month, "month", "C_monthSet");
		UserActions.enterText(edt_C_Year, "Year", "C_YearSet");
		UserActions.clickElement(btn_C_Purchase, "Purchase button", "C_PurchaseClick");
	    String strActualAmount =  ApplicationUtility.getActualAmount(ele_C_ConfirmationPopUp, "Actual amount", "ActualLaptopPriceGet");
	    ApplicationUtility.verifyAmount(strActualAmount, strExpectedAmount, "verifyAmount");
	    UserActions.clickElement(btn_C_Ok, "OK button", "C_OkClick");
	}
	

}
