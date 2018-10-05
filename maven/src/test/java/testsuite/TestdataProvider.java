package testsuite;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Constants;

public class TestdataProvider extends Constants{


	@Test(dataProvider = "sampTest")
	public static void login(String loginName, String password) {		
		System.out.println("User Name :" + loginName);
		System.out.println("Password :" + password);
		System.out.println("*************************");
	}

	public static Object[][] XlReading() throws IOException {
		Object abc[][] = null;
		try {
			FileInputStream fis = new FileInputStream(ExcelPath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet st = wb.getSheetAt(4);
			int Rowcount = st.getLastRowNum();
			int COlumncount = st.getRow(0).getLastCellNum();
			abc = new Object[Rowcount][COlumncount];
			
			for (int i = 1; i <= Rowcount; i++) {
				for (int j = 0; j < COlumncount; j++) {
					abc[i - 1][j] = st.getRow(i).getCell(j).getStringCellValue();					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return abc;
	}
	@Test
	@DataProvider(name = "sampTest", parallel = false)
	public static Object[][] testParameterData() throws Exception {// Data provider annotation usage starts here
		Object data[][] = XlReading();
		return data;
	}
}
