package Base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Predicate;
import org.openqa.selenium.NoSuchElementException;

public class commonMethods {

	public WebDriver driver;

	public commonMethods(WebDriver driver) {
		this.driver = driver;
		
		
		
	}

	public void MspLogin(Row r1) {
		
		
		
		driver.findElement(KeyWords.UserName).sendKeys(r1.getCell(3).getStringCellValue());
		driver.findElement(KeyWords.Password).sendKeys(r1.getCell(4).getStringCellValue());
		driver.findElement(KeyWords.LoginBtn).click();
		
		/*KeyWords kw = PageFactory.initElements(driver, KeyWords.class);
	 	kw.UserName.sendKeys(r1.getCell(3).getStringCellValue());		
		kw.Password.sendKeys(r1.getCell(4).getStringCellValue());
		kw.LoginBtn.click();*/
	}

	public String ClientSelection(Row r) throws InterruptedException {
		KeyWords kw = PageFactory.initElements(driver, KeyWords.class);
		kw.Clientlink.click();
		String ClientSelection = r.getCell(10).getStringCellValue();
		kw.Clientselect.sendKeys(ClientSelection);
		Thread.sleep(3000);
		kw.Client.click();
		return ClientSelection;
	}

	public void EleVisibility(WebDriver driver, WebElement element) {

		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		fwait.until(ExpectedConditions.visibilityOf(element));
		fwait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void EleClickabe(WebDriver driver, WebElement element) {
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public int Thread(int x) throws InterruptedException {
		Thread.sleep(x);
		return x;
	}

	public void turnOnImplicitWaits(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void waitForElementToBeClickable(WebDriver driver, Predicate<WebDriver> expectedConditions) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(expectedConditions);
	}

	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitMyTime(WebDriver driver, int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}

	public String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
		Date dt = new Date();
		return dateFormat.format(dt);
	}

	public String randNum() {
		String randomNumbers = RandomStringUtils.randomNumeric(4);
		String Num = randomNumbers;
		return Num;
	}

	public String generateEmail() {
		String email = randNum() + "@tm.com";
		return email;
	}

	public String Name() {
		String[] firsname = { "priya", "Tanya", "Priyanka", "divya", "tanvi", "Ishita", "vani", "Anjali", "Shreya",
				"mayur", "tushar", "Harish", "Avinash", "Avi", "SURESH", "Ajeet" };
		String FN = (firsname[new Random().nextInt(firsname.length)]);
		return FN;
	}

	
	
	
	public String phones(int i) {
		String[] pho = { "", "9123434340", "9123434341", "9123434342", "9123434343", "9123434344", "9123434345",
				"9123434346", "9123434347" };
		return pho[i];
	}

	public String adharNum() {
		String randomNumbers = RandomStringUtils.randomNumeric(12);
		String adhar = randomNumbers;
		return adhar;
	}

	public String adharNum1() {
		String randomNumbers = randNum() + "1001" + randNum();
		String adhar = randomNumbers;
		return adhar;
	}

	public String phoneNUM() {
		String PhoneNum = "91" + randNum() + randNum();
		return PhoneNum;
	}

	public String panNum() {
		String randomText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 5;
		String pan = RandomStringUtils.random(length, randomText);
		return pan;
	}

	public String IFSCcode() {
		String randomText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 4;
		String ifscAlpha = RandomStringUtils.random(length, randomText);

		String randomNumbers = RandomStringUtils.randomNumeric(6);
		String ifscNum = randomNumbers;

		String newIFSC = ifscAlpha + "0" + ifscNum;
		return newIFSC;
	}

	// WEWE0323232

	public int randomQUES() {
		int[] Ques = { 1, 2, 3, 4, 5, 6, 7 };
		int qus = (Ques[new Random().nextInt(Ques.length)]);
		return qus;
	}

	public String EmpType() {
		String[] Employee = { "Employment", "Salaried" };
		String emp = (Employee[new Random().nextInt(Employee.length)]);
		return emp;
	}

	public String IndType() {
		String[] Industry = { "IT", " Banking And Finance", "Government Service", "Consulting", "Telecom", "BPO",
				"Other" };
		String Ind = (Industry[new Random().nextInt(Industry.length)]);
		return Ind;
	}

}
