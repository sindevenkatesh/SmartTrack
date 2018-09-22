package testsuite;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

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

	}

}
