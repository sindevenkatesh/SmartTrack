package testsuite;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.commonMethods;
import config.Constants;
 
public class BrokenLinks extends Constants{
	static Logger Log = Logger.getLogger(SmartTrack_Test.class.getName());

	public static String Main = "Main";
	public static String ClientData = "ClientData";
	public static String outputData = "Output";
	
	

	@Test
	public void SmartTrackLogin() throws IOException, InterruptedException {

		PropertyConfigurator.configure(LogPath);

		Row r = eo.getRowData(ExcelPath, Main, 1);

		Log.info("Test");
		startBrowser(r);
		Thread.sleep(3000);

		commonMethods comMeth = PageFactory.initElements(driver, commonMethods.class);
		
		Row r1 = eo.getRowData(ExcelPath, ClientData, 1);
		comMeth.MspLogin(r1);
		Thread.sleep(10000);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));	
		Log.info("Total links are "+links.size());	
		
		//used for loop to 
		for(int i=0; i<links.size(); i++) {
			WebElement element = links.get(i);
			//By using "href" attribute, we could get the url of the requried link
			String url=element.getAttribute("href");
			Log.info(url);
			//calling verifyLink() method here. Passing the parameter as url which we collected in the above link
			//See the detailed functionality of the verifyLink(url) method below
			verifyLink(url);			
		}	
	}
	
	// The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
	public static void verifyLink(String urlLink) {
        //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
        try {
			//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
			URL link = new URL(urlLink);
			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			//Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);
			//connect using connect method
			httpConn.connect();
			//use getResponseCode() to get the response code. 
				if(httpConn.getResponseCode()== 200) {	
					Log.info(urlLink+" - "+httpConn.getResponseMessage());
				}
				if(httpConn.getResponseCode()== 404) {
					Log.info(urlLink+" - "+httpConn.getResponseMessage());
				}
			}
			//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
		catch (Exception e) {
			//e.printStackTrace();
		}
    } 
}
