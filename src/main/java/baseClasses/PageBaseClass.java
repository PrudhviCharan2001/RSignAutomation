package baseClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.Envelopespage;
import PageClasses.Homepage;
import PageClasses.Sendpage;
import utilities.DateUtil;

public class PageBaseClass extends BaseTestClass {

	public static ExtentTest logger;
	@FindBy(xpath = "//*[@name='loginfmt']")
	public static WebElement yahooemail;
	@FindBy(xpath = "//*[@value='Next']")
	public static WebElement emailnextbtn;
	@FindBy(xpath = "//*[@name='passwd']")
	public static WebElement yahoopassword;
	@FindBy(xpath = "//*[@value='Sign in']")
	public static WebElement yahoologinbtn;
	@FindBy(xpath = "//*[contains(@type,'submit')]")
	public static WebElement staysignedin;
	@FindBy(xpath = "(//*[@title='rsign@rsign.rpost.net'])[1]")
	public static WebElement openmail;
	@FindBy(xpath = "//*[contains(@href,'https://sign.use.rsign.com//SignDocument/Index')]")
	public static WebElement viewandsigndocument;
	@FindBy(xpath = "//*[@id='btnContinueTermsAndService']")
	public static WebElement termsandservice;
	@FindBy(xpath = "//*[@id='chkterms']")
	public static WebElement acceptclicktosigncheckbox;
	@FindBy(xpath = "//*[@id='btnAccept']")
	public static WebElement acceptclicktosign;
	@FindBy(xpath = "//*[contains(@id,'control_signControl')]")
	public static WebElement clickonsignature;
	@FindBy(xpath = "//*[contains(@id,'control_newInitialsControl')]")
	public static WebElement clickoninitial;
	@FindBy(xpath = "//*[contains(@id,'control_nameControl')]")
	public static WebElement namecontrol;
	@FindBy(xpath = "//*[contains(@id,'control_titleControl')]")
	public static WebElement titlecontrol;
	@FindBy(xpath = "//*[contains(@id,'control_companyControl')]")
	public static WebElement companycontrol;
	@FindBy(xpath = "//*[contains(@id,'control_emailControl')]")
	public static WebElement emailcontrol;
	@FindBy(xpath = "//*[contains(@id,'control_DropDownControl')]")
	public static WebElement dropdowncontrol;
	@FindBy(xpath = "//*[contains(@id,'control_checkboxControl')]")
	public static WebElement checkboxcontrol;
	@FindBy(xpath = "//*[contains(@id,'control_radioControl')]")
	public static WebElement radiobuttoncontrol;
	@FindBy(xpath = "//*[contains(@id,'control_dateControl')]")
	public static WebElement datecontrol;
	@FindBy(xpath = "//*[contains(@id,'control_textControl')]")
	public static WebElement textcontrol;
	@FindBy(xpath = "//*[contains(@id,'btnSubmit')]")
	public static WebElement finishbtn;
	@FindBy(xpath = "(//*[@id='MessageSubject'])")
	public static WebElement subject;

	@FindBy(xpath = "/html/body")
	public static WebElement messagebody;

	@FindBy(xpath = "//*[@id='DocumentUploadButton']")
	public static WebElement adddocument;

	@FindBy(xpath = "(//*[@id='loaclDriveUpload'])")
	public static WebElement localdriver;

	@FindBy(xpath = "//*[@id='btnNext']")
	public static WebElement next;

	@FindBy(xpath = "(//*[@id='Sign'])[2]")
	public WebElement signature;

	@FindBy(xpath = "(//*[@id='newInitials'])[2]")
	public WebElement initial;

	@FindBy(xpath = "(//*[@id='DateTimeStamp'])[2]")
	public WebElement dateandtimestamp;

	@FindBy(xpath = "(//*[@id='Name'])[2]")
	public WebElement name;

	@FindBy(xpath = "(//*[@id='Title'])[2]")
	public WebElement title;

	@FindBy(xpath = "(//*[@id='Company'])[2]")
	public WebElement company;

	@FindBy(xpath = "(//*[@id='Email'])[2]")
	public WebElement email;

	@FindBy(xpath = "(//*[@id='Dropdown'])[2]")
	public WebElement dropdown;

	@FindBy(xpath = "(//*[@id='Checkbox'])[2]")
	public WebElement checkbox;

	@FindBy(xpath = "(//*[@id='Radio'])[2]")
	public WebElement radiobutton;

	@FindBy(xpath = "(//*[@id='Date'])[2]")
	public WebElement date;

	@FindBy(xpath = "(//*[@id='Text'])[2]")
	public WebElement text;

	@FindBy(xpath = "(//*[@id='Label'])[2]")
	public WebElement label;

	@FindBy(xpath = "(//*[@id='Hyperlink'])[2]")
	public WebElement hyperlink;
	
	@FindBy(xpath = "(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/a[2]")
	public WebElement signerdropdown;
	
	@FindBy(xpath = "(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li[2])")
	public WebElement selectsigner;

	@FindBy(xpath = "(//*[@class='done btn'])[15]")
	public WebElement controldone;
	
	@FindBy(xpath = "//*[@id='btnSaveAdvanceSettings']")
	public WebElement savesettings;

	@FindBy(xpath = "(//*[@id='1'])")
	public WebElement document;

	@FindBy(xpath = "(//*[@id='btnSend'])")
	public WebElement sendbutton;

	@FindBy(xpath = "(//*[@name='txtDropDownOption'])")
	public WebElement dropdownoption;

	@FindBy(xpath = "(//*[@id='btnAddOption'])")
	public WebElement dropdownaddoption;

	@FindBy(xpath = "(//*[@class='radioControlGrpBlock clearfix'])[2]/div/input[1]")
	public WebElement radiobuttongroupname;

	@FindBy(xpath = "/html/body/div[5]/div/div/form/div/div[1]/input")
	public WebElement labelname;

	@FindBy(xpath = "/html/body/div[5]/div/div/form/div/div[1]/input[1]")
	public WebElement urlname;

	@FindBy(xpath = "/html/body/div[5]/div/div/form/div/div[1]/input[2]")
	public WebElement url;
	@FindBy(xpath = "(//*[contains(@class,'form-control TextLabel')])[4]")
	public WebElement textlabel;
	@FindBy(xpath = "//*[contains(@class,'reciptName')]")
	public static WebElement recipientname;
	@FindBy(xpath = "//*[contains(@class,'reciptEmail')]")
	public static WebElement recipientemail;
	@FindBy(xpath = "//*[contains(@class,'recipientMobile')]")
	public static WebElement recipientmobile;

	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	/****************** OpenApplication ***********************/
	public Homepage OpenApplication() {
		logger.log(Status.INFO, "Opening the WebSite");
		driver.get("https://app3.use.rsign.com/Account/LogOn");
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[1]/div[1]/input"))
				.sendKeys("prudhvi.vu@rpostlabs.com");
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[1]/div[2]/input"))
				.sendKeys("PrudhviCharan@2001");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")).click();
		driver.switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/main/div/div/div/div[1]/form/div[4]/button")));
		driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[4]/button")).click();
		logger.log(Status.PASS, "Successfully Opened the https://app3.use.rsign.com/Account/LogOn");
		Homepage homepage = new Homepage(driver, logger);
		PageFactory.initElements(driver, homepage);
		return homepage;
	}

	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	public static void addrecipientdetails(String name, String email) {
		recipientname.sendKeys(email);
		recipientemail.sendKeys(name);
		//recipientmobile.sendKeys("7032997552");
	}

	/****************** Accept Java Script Alert ***********************/
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.log(Status.PASS, "Page Alert Accepted");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Cancel Java Script Alert ***********************/
	public void cancelAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			;
			logger.log(Status.PASS, "Page Alert Rejected");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Select value From DropDown ***********************/
	public void selectDropDownValue(WebElement webElement, String value) {
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
			logger.log(Status.PASS, "Selectd the Value : " + value);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Verify Element is Present ***********************/
	public void veriyElementIsDisplayed(WebElement webElement) {
		try {
			if (webElement.isDisplayed()) {
				reportPass("Password Box is Displayed");
			} else {
				reportFail("Password box is not appeared");
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Get All Elements of DropDown ***********************/
	public List getAllElementsOfDropDown(WebElement webElement) {
		try {
			Select select = new Select(webElement);
			List<WebElement> allElements = select.getOptions();
			return allElements;
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void signature() throws InterruptedException {
		waitForPageLoad();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(signature));
		act.dragAndDrop(signature, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		controldone.click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,80);", "");
	}

	public void initial() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing initial control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(initial));
		act.dragAndDrop(initial, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in intial control popup");
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,80);", "");
	}

	public void dateandtimestamp() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing date and time stamp control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dateandtimestamp));
		act.dragAndDrop(dateandtimestamp, document).build().perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in date and time stamp control popup");
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void name() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing name control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(name));
		act.dragAndDrop(name, document).build().perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in name control popup");
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void title() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing title control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(title));
		act.dragAndDrop(title, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in title control popup");
		Thread.sleep(500);
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void company() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing company control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(company));
		act.dragAndDrop(company, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in company control popup");
		Thread.sleep(500);
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void email() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing email control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		act.dragAndDrop(email, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in intial email popup");
		Thread.sleep(500);
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void dropdown() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing dropdown control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		act.dragAndDrop(dropdown, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		dropdownoption.sendKeys("QA");
		dropdownaddoption.click();
		dropdownoption.sendKeys("dev");
		dropdownaddoption.click();
		dropdownoption.sendKeys("manager");
		dropdownaddoption.click();
		logger.log(Status.INFO, "Clicking done in dropdown control popup");
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void checkbox() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing checkbox control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(checkbox));
		act.dragAndDrop(checkbox, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in checkbox control popup");
		Thread.sleep(500);
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void radiobutton() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing radiobutton control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(radiobutton));
		act.dragAndDrop(radiobutton, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		Thread.sleep(500);
		radiobuttongroupname.sendKeys("radiobutton");
		logger.log(Status.INFO, "Clicking done in radiobutton control popup");
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void date() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing date control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(date));
		act.dragAndDrop(date, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in date control popup");
		Thread.sleep(500);
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void text() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing text control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(text));
		act.dragAndDrop(text, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		textlabel.sendKeys("text");
		logger.log(Status.INFO, "Clicking done in text control popup");
		Thread.sleep(500);
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void label() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing label control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(label));
		act.dragAndDrop(label, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		Thread.sleep(500);
		labelname.sendKeys("enter the name:");
		logger.log(Status.INFO, "Clicking done in label control popup");
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void hyperlink() throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing hyperlink control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(hyperlink));
		act.dragAndDrop(hyperlink, document).build().perform();
		// urlname.sendKeys("rsign");
		url.sendKeys("https://app3.use.rsign.com/Home/Index");
		Actions actions = new Actions(driver);
		act.moveToElement(controldone).doubleClick().build().perform();
//	controldone.click();
		logger.log(Status.INFO, "Clicking done in hyperlink control popup");
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}
	public void signature(int i) throws InterruptedException {
		waitForPageLoad();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(signature));
		act.dragAndDrop(signature, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		Thread.sleep(1000);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,80);", "");
	}

	public void initial(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing initial control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(initial));
		act.dragAndDrop(initial, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in intial control popup");
		Thread.sleep(1000);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,80);", "");
	}

	public void dateandtimestamp(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing date and time stamp control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dateandtimestamp));
		act.dragAndDrop(dateandtimestamp, document).build().perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in date and time stamp control popup");
		Thread.sleep(1000);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void name(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing name control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(name));
		act.dragAndDrop(name, document).build().perform();
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in name control popup");
		Thread.sleep(1000);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void title(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing title control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(title));
		act.dragAndDrop(title, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in title control popup");
		Thread.sleep(500);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void company(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing company control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(company));
		act.dragAndDrop(company, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in company control popup");
		Thread.sleep(500);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void email(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing email control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(email));
		act.dragAndDrop(email, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in intial email popup");
		Thread.sleep(500);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void dropdown(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing dropdown control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		act.dragAndDrop(dropdown, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		dropdownoption.sendKeys("QA");
		dropdownaddoption.click();
		dropdownoption.sendKeys("dev");
		dropdownaddoption.click();
		dropdownoption.sendKeys("manager");
		dropdownaddoption.click();
		logger.log(Status.INFO, "Clicking done in dropdown control popup");
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void checkbox(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing checkbox control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(checkbox));
		act.dragAndDrop(checkbox, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in checkbox control popup");
		Thread.sleep(500);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void radiobutton(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing radiobutton control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(radiobutton));
		act.dragAndDrop(radiobutton, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		Thread.sleep(500);
		radiobuttongroupname.sendKeys("radiobutton");
		logger.log(Status.INFO, "Clicking done in radiobutton control popup");
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void date(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing date control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(date));
		act.dragAndDrop(date, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		logger.log(Status.INFO, "Clicking done in date control popup");
		Thread.sleep(500);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}

	public void text(int i) throws InterruptedException {
		waitForPageLoad();
		logger.log(Status.INFO, "Placing text control");
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(text));
		act.dragAndDrop(text, document).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(controldone));
		textlabel.sendKeys("text");
		logger.log(Status.INFO, "Clicking done in text control popup");
		Thread.sleep(500);
		signerdropdown.click();
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown SignerNames SignDropDown')])[13]/ul/li["+i+"]")).click();
		controldone.click();
		logger.log(Status.INFO, "Scrolling the page");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}
	public void signersignature(int i) throws InterruptedException {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"' and contains(@id,'control_signControl')]")).click();
		Thread.sleep(1200);
		driver.findElement(By.xpath("//*[@id='defaultSignerName']")).sendKeys("prudhvicharan");
		Thread.sleep(1200);
		driver.findElement(By.xpath("(//*[@id='UserSignatureModal'])/div/div/div[1]/div/a[3]")).click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,60);", "");
		}
	public void signerinitial(int i) throws InterruptedException {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"' and contains(@id,'control_newInitialsControl')]")).click();
		Thread.sleep(1200);
		driver.findElement(By.xpath("//*[@id='newInitialdefaultSignerName']")).sendKeys("prudhvicharan");
		Thread.sleep(1200);
		driver.findElement(By.xpath("(//*[@id='NewInitialModal'])/div/div/div[1]/div/a[3]")).click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,60);", "");
	}
	public void signername(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/input[contains(@id,'control_nameControl')]")).sendKeys("prudhvi");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,60);", "");
		}
	public void signertitle(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/input[contains(@id,'control_titleControl')]")).sendKeys("RPOST");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
		}
	public void signercompany(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/input[contains(@id,'control_companyControl')]")).sendKeys("RPOST");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
		}
	public void signeremail(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/input[contains(@id,'control_emailControl')]")).sendKeys("prudhvicharanv@yahoo.com");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
		}
	public void signercheckbox(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/span/input[contains(@id,'control_checkboxControl')]")).click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
		}
	public void signerradiobutton(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/input[contains(@id,'control_radioControl')]")).click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}
	public void signerdate(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/input[contains(@id,'control_dateControl')]")).click();
		selectDateIncalendar("11/09/2019");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}
	public void signertext(int i) {
		driver.findElement(By.xpath("//*[@data-role-name='QA"+i+"']/div/div/textarea[contains(@id,'control_textControl')]")).sendKeys("prudhvi");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,30);", "");
	}
	
	public Envelopespage sendbutton() {
		sendbutton.click();
		Envelopespage envelopestab = new Envelopespage(driver, logger);
		PageFactory.initElements(driver, envelopestab);
		return envelopestab;
	}

	public void allcontrols() throws InterruptedException {
		signature();
		initial();
		dateandtimestamp();
		name();
		title();
		company();
		email();
		dropdown();
		checkbox();
		// hyperlink();
		radiobutton();
		date();
		text();
		// label();
	}
	
	public void allcontrols(int i) throws InterruptedException {
		signature(i);
		initial(i);
		dateandtimestamp(i);
		name(i);
		title(i);
		company(i);
		email(i);
		dropdown(i);
		checkbox(i);
		// hyperlink();
		radiobutton(i);
		date(i);
		text(i);
		// label();
	}

	public static void adddocument(String filepath) throws AWTException {
		adddocument.click();
		localdriver.click();
		waitForPageLoad();
		Robot r = new Robot();
		r.delay(2000);
		StringSelection s = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		waitForPageLoad();
	}
public static void adddocwithlogin() throws InterruptedException {
	adddocument.click();
	Thread.sleep(2000);
   driver.findElement(By.xpath("//*[@id='SkyDriveUpload']")).click();
   Thread.sleep(2000);
   ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(1));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@type='email']")).sendKeys("prudhvicharanv@hotmail.com");
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Charan@2001");
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	Thread.sleep(12000);
	driver.findElement(By.xpath("(//*[text()='API contract &.pdf'])[1]")).click();
	driver.findElement(By.xpath("//*[text()='Select']")).click();
	Thread.sleep(4000);
	driver.switchTo().window(tab.get(0));
}
public static void robot() throws AWTException {
	Robot r= new Robot();
	r.keyPress(KeyEvent.VK_WINDOWS);
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_WINDOWS);
	r.keyRelease(KeyEvent.VK_DOWN);
}
public static void adddoc() throws InterruptedException {
	adddocument.click();
	Thread.sleep(2000);
   driver.findElement(By.xpath("//*[@id='SkyDriveUpload']")).click();
   Thread.sleep(2000);
   ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(1));
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@type='email']")).sendKeys("prudhvicharanv@hotmail.com");
//	driver.findElement(By.xpath("//*[@type='submit']")).click();
//	driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Charan@2001");
//	driver.findElement(By.xpath("//*[@type='submit']")).click();
//	driver.findElement(By.xpath("//*[@type='submit']")).click();
//	Thread.sleep(12000);
	driver.findElement(By.xpath("(//*[text()='API contract &.pdf'])[1]")).click();
	driver.findElement(By.xpath("//*[text()='Select']")).click();
	Thread.sleep(4000);
	driver.switchTo().window(tab.get(0));
}

	public static void subject(String subjectname, String message) {
		subject.sendKeys(subjectname);
		driver.switchTo().frame(0);
		messagebody.sendKeys(message);
		driver.switchTo().parentFrame();
	}

	public static void next() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='step1NextButton']")).click();
		next.click();
	}

}
