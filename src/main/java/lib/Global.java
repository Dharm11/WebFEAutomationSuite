package lib;

import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Global {
	
	public static String htmlFile = System.getProperty("user.dir")+"\\Reports\\ResultLogs\\Batch.html";
	public static String testArtifacts =System.getProperty("user.dir")+"\\TestArtifacts\\";
	public static String groupControlFile = System.getProperty("user.dir")+"\\TestArtifacts\\GroupControlFile.xlsx";
	public static String moduleQuery = "select * from Groups where Run = 'Y'";
	public static String screenshotFolder =System.getProperty("user.dir")+"\\Reports\\ScreenShots\\";
	

	
	//reporting global variables
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	public static Map  dataMap;		
	public static String appURL = "https://www.demoblaze.com/index.html";
	
	public static String id;
	public static String automationID;
	public static String manualID;
	public static String desciption;
	//===================
	public static String className;
	public static String methodName;
	
	public static String strBrowserName = "CHROME";
	
	
	
	
	
	
	

}
