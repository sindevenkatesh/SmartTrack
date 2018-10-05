package testsuite;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.commonMethods;
import config.Constants;

public class CreateCW_Test extends Constants
{
	static Logger Log = Logger.getLogger(SmartTrack_Test.class.getName());

	public static String Main = "Main";
	public static String ClientData = "ClientData";
	public static String outputData = "Output";

	@Test
	public void createCW() throws IOException, InterruptedException {
		PropertyConfigurator.configure(LogPath);

		Row r = eo.getRowData(ExcelPath, Main, 1);

		Log.info("Test");
		startBrowser(r);
		Thread.sleep(3000);
		
		commonMethods comMeth = PageFactory.initElements(driver, commonMethods.class);
		
		Row r1 = eo.getRowData(ExcelPath, ClientData, 1);
		comMeth.MspLogin(r1);


	}

}
