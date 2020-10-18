package lib;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting {
	

/**Methodname:createHTMLReport : it is used to generate the html report
 * return : Nothing
 * @author  Dharmendra singh
 *
 */
	public static void createHTMLReport() {
		try {
			Global.htmlReporter = new ExtentHtmlReporter(Global.htmlFile);
			Global.report = new ExtentReports();
			Global.report.attachReporter(Global.htmlReporter);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	/**Methodname:writeHtmlLogs : it is used to write the steps into the html report
	 * return : Nothing
	 * @author  Dharmendra singh
	 * @return 
	 *
	 */
	public static void writeHtmlLogs(String strPassfail , String description) {
		
		if(strPassfail.contentEquals("PASS")) {
			Global.test.log(Status.PASS, description);
		}
		else if (strPassfail.contentEquals("FAIL")){
			Global.test.log(Status.FAIL,description);
		}
		else {
			Global.test.log(Status.INFO,description);
		}
		
		
	}
	
	/**Methodname: takeScreenshot:
	 * return : Nothing
	 * @author  Dharmendra singh
	 * @return 
	 * @throws IOException 
	 *
	 */
	
	public static void takeScreenshot(String strPassfail ) throws IOException {
		LocalDateTime date = LocalDateTime.now();
		
		String strDateTime = date.toString().replaceAll(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot)Utility.returnDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String strDestFile = Global.screenshotFolder + "image_" + strDateTime +".png";
		File desFile = new File(strDestFile);
		FileHandler.copy(src, desFile);
		
		if(strPassfail.contentEquals("PASS")) {
			Global.test.pass("", MediaEntityBuilder.createScreenCaptureFromPath(strDestFile).build());
		}
		if(strPassfail.contentEquals("FAIL")) {
			Global.test.fail("", MediaEntityBuilder.createScreenCaptureFromPath(strDestFile).build());
		}
		
		
		
	}

}
