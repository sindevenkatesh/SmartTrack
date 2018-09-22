package Base;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class KeyWordMethods {
	public WebDriver driver;

	public KeyWordMethods(WebDriver driver) {

		this.driver = driver;
	}

	
	
	public void CreateNewReq(Row r1) throws InterruptedException {

		KeyWords kw = PageFactory.initElements(driver, KeyWords.class);
		Actions act = new Actions(driver);
		act.moveToElement(kw.HomeBtn).moveToElement(kw.HomeOpen).build().perform();
		Thread.sleep(2000);
		try {
			if (kw.HomeOpen != null) {
				act.moveToElement(kw.HomeBtn).moveToElement(kw.HomeOpen).build().perform();
			}

		} catch (Exception e) {
			System.out.println("Exception");
		}

		Thread.sleep(3000);

		String str_MainMenuName = r1.getCell(6).getStringCellValue();
		String str_SubMenuName = r1.getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//a[@class='gn-icon gn-parent-menu'][text()='" + str_MainMenuName + "']")).click();
		driver.findElement(
				By.xpath("//*[@class='gn-submenu']//li[contains(normalize-space(),'" + str_SubMenuName + "')]"))
				.click();

		String str_NewRegularRequisition = r1.getCell(8).getStringCellValue();
		String str_NewRequisition = r1.getCell(9).getStringCellValue();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[@id='etkresult']//b[contains(normalize-space(),'" + str_NewRegularRequisition + "')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='ui-corner-all tip wcagtrigger']//b[contains(normalize-space(),'"
				+ str_NewRequisition + "')]")).click();

	}

}
