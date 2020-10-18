package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Singleton class (design pattern)

public class InitDriver {
	
	private static WebDriver driver;
	
	
	private InitDriver() {
		
	}
	
	public static WebDriver getDriverInstance(String strBrowserName) {
		
		if(driver==null) {
			if(strBrowserName.contentEquals("CHROME")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Resources\\chromedriver.exe");			
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				
			}
			else if(strBrowserName.contentEquals("FIREFOX")) {
				//firefox code will be there. so just for assignment , i have used only chromedriver
				
			}
			
			
		}
		
		
		
		return driver;
		
	}
	
	
	
	

}
