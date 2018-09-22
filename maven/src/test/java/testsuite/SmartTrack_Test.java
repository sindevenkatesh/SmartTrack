package testsuite;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.support.PageFactory;
import Base.KeyWordMethods;
import Base.commonMethods;
import Base.requisitionPage;
import config.Constants;

public class SmartTrack_Test extends Constants {

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
		KeyWordMethods kwm = PageFactory.initElements(driver, KeyWordMethods.class);
		requisitionPage reqPage = PageFactory.initElements(driver, requisitionPage.class);

		Row r0 = eo.getRowData(ExcelPath, ClientData, 0);
		Row r1 = eo.getRowData(ExcelPath, ClientData, 1);
		comMeth.MspLogin(r1);

		Thread.sleep(5000);
		Log.info("Login is successfully Done...!");

		comMeth.ClientSelection(r);
		Thread.sleep(10000);
		kwm.CreateNewReq(r1);

		Thread.sleep(5000);
		reqPage.Supervalu(r1);

	}
}
