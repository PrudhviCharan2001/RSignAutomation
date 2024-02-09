package baseClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.Envelopespage;
import PageClasses.Homepage;
import PageClasses.Loginpage;
import PageClasses.Sendpage;
import PageClasses.Settingspage;
import PageClasses.Templatespage;

public class TopMenuClass extends PageBaseClass {

	public TopMenuClass(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@href='/Envelope/Index']")
	public WebElement sendpage;

	@FindBy(xpath = "/html/body/header/nav/div/div/div/span")
	public WebElement signout;
	
	@FindBy(xpath = "//*[@href='/DocumentPackage/DocumentPackageIndex']")
	public WebElement envelopespage;
	
	@FindBy(xpath = "//*[@href='/Template/Index']")
	public WebElement templatespage;
	
	@FindBy(xpath = "//*[@href='/Settings/Index']")
	public WebElement settingspage;
	
	@FindBy(xpath = "//*[@href='/Home/Index']")
	public WebElement homepage;
	
	@FindBy(xpath = "//*[@id='alink']/span[1]/strong")
	public WebElement personalsettings;
	
	public Loginpage singOutApplication() {
		signout.click();
		logger.log(Status.PASS, "Click the Sing-Out Link");
		Loginpage loginpage = new Loginpage(driver, logger);
		PageFactory.initElements(driver, loginpage);
		return loginpage;
	}
	public Homepage hompage() {
		driver.navigate().refresh();
		homepage.click();
		logger.log(Status.PASS, "Click the hompage Link");
		Homepage homepage = new Homepage(driver, logger);
		PageFactory.initElements(driver, homepage);
		return homepage;
	}
	public Sendpage sendpage() {
		driver.navigate().refresh();
		sendpage.click();
		logger.log(Status.PASS, "Click the sendpage Link");
		Sendpage sendpage = new Sendpage(driver, logger);
		PageFactory.initElements(driver, sendpage);
		return sendpage;
	}
	public Templatespage templatespage() {
		driver.navigate().refresh();
		templatespage.click();
		logger.log(Status.PASS, "Click the templatespage Link");
		Templatespage templatespage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatespage);
		return templatespage;
	}
	public Envelopespage envelopespage() {
		driver.navigate().refresh();
		envelopespage.click();
		logger.log(Status.PASS, "Click the envelopespage Link");
		Envelopespage envelopespage = new Envelopespage(driver, logger);
		PageFactory.initElements(driver, envelopespage);
		return envelopespage;
	}
	public Settingspage settingspage() {
		driver.navigate().refresh();
		settingspage.click();
		logger.log(Status.PASS, "Click the settingspage Link");
		Settingspage settingspage = new Settingspage(driver, logger);
		PageFactory.initElements(driver, settingspage);
		return settingspage;
	}
	public Settingspage personalsettings() {
		driver.navigate().refresh();
		personalsettings.click();
		logger.log(Status.PASS, "Click the settingspage Link");
		Settingspage settingspage = new Settingspage(driver, logger);
		PageFactory.initElements(driver, settingspage);
		return settingspage;
		
	}
}
