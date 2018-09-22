package utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;


public class TestReport {

	public static final Logger logger = Logger.getLogger(TestReport.class.getName());	
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ITestResult result;	
	public static ExtentHtmlReporter htmlReporter;


	// reporting purpose
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/test/java/report/"+ formater.format(calendar.getTime()) + ".html", false);	
		extent.addSystemInfo("OS", "Linux");
		extent.addSystemInfo("Environment", "QA");
				
	}

	// to take screen shot
	public String screenshot(String imagename) throws IOException {
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir") + "/src/test/java/screens/";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateforamt = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		String Actualimage = imagename + imagelocation + dateforamt.format(calendar.getTime()) + "png";
		File destFile = new File(Actualimage);
		FileUtils.copyFile(img, destFile);
		return Actualimage;
	}

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = screenshot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser() {
		extent.endTest(test);
		extent.flush();
	}

}
