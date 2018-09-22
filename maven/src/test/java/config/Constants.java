package config;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.ExcelOperations;

public class Constants {

	protected static final Logger logger = Logger.getLogger(Constants.class.getName());
	private static final String Browser = null;
	public static RemoteWebDriver driver = null;

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ITestResult result;
	public static ExtentHtmlReporter htmlReporter;

	// Path Declarations
	public static String DriverPath = System.getProperty("user.dir") + "/src/test/java/config/chromedriver";
	public static String LogPath = System.getProperty("user.dir") + "/src/test/java/config/log4j.properties";
	public static String ExcelPath = System.getProperty("user.dir") + "/src/test/java/excel/TestData.xlsx";
	public static String ScreensPath = System.getProperty("user.dir") + "/src/test/java/screens/";
	public static String reportsPath = System.getProperty("user.dir") + "/src/test/java/report/";

	// Object Creations
	public static ExcelOperations eo = new ExcelOperations();

	// Reporting purpose
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(reportsPath + formater.format(calendar.getTime()) + ".html", false);
		extent.addSystemInfo("OS", "Linux");
		extent.addSystemInfo("Environment", "QA");

	}

	// to take screen shot
	public String screenshot(String imagename) throws IOException {
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//String imagelocation = System.getProperty("user.dir") + "/src/test/java/screens/";
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateforamt = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		String Actualimage = imagename + ScreensPath + dateforamt.format(calendar.getTime()) + ".png";
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

	public static String startBrowser(Row r) {

		getbrowser(Browser, r);
		String URL = r.getCell(9).getStringCellValue();
		driver.get(URL);
		driver.manage().window().maximize();
		return URL;

	}

	public static void getbrowser(String Browser, Row r) {
		Browser = r.getCell(8).getStringCellValue();
		if (Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		else if (Browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "/home/venkateshshinde/chromedriver");
			// Handle https certifications
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver();
		}

		else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEdriver");
			driver = new InternetExplorerDriver();
		}

	}

}
