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

	@FindBy(xpath = "/html/body/header/nav/div/ul/li[2]/a/span")
	public WebElement sendpage;

	@FindBy(xpath = "/html/body/header/nav/div/div/div/span")
	public WebElement signout;
	
	@FindBy(xpath = "/html/body/header/nav/div/ul/li[3]/a/span")
	public WebElement envelopespage;
	
	@FindBy(xpath = "/html/body/header/nav/div/ul/li[4]/a")
	public WebElement templatespage;
	
	@FindBy(xpath = "/html/body/header/nav/div/ul/li[5]/a")
	public WebElement settingspage;
	
	@FindBy(xpath = "/html/body/header/nav/div/ul/li[1]/a/span")
	public WebElement homepage;
	
	@FindBy(xpath = "/html/body/header/nav/div/div/div/a[1]/span[1]/strong")
	public WebElement personalsettings;
	
	public Loginpage singOutApplication() {
		logger.log(Status.INFO, "Clicking the Sing-Out Link");
		signout.click();
		logger.log(Status.PASS, "Clicked the Sing-Out Link");
		Loginpage loginpage = new Loginpage(driver, logger);
		PageFactory.initElements(driver, loginpage);
		return loginpage;
	}
	public Homepage hompage() {
		logger.log(Status.INFO, "Clicking the hompage Link");
		homepage.click();
		logger.log(Status.PASS, "Clicked the hompage Link");
		Homepage homepage = new Homepage(driver, logger);
		PageFactory.initElements(driver, homepage);
		return homepage;
	}
	public Sendpage sendpage() {
		//logger.log(Status.INFO, "Clicking the sendpage Link");
		sendpage.click();
		//logger.log(Status.PASS, "Clicked the sendpage Link");
		Sendpage sendpage = new Sendpage(driver, logger);
		PageFactory.initElements(driver, sendpage);
		return sendpage;
	}
	public Templatespage templatespage() {
		logger.log(Status.INFO, "Clicking the templatespage Link");
		templatespage.click();
		logger.log(Status.PASS, "Clicked the templatespage Link");
		Templatespage templatespage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatespage);
		return templatespage;
	}
	public Envelopespage envelopespage() {
		logger.log(Status.INFO, "Clicking the envelopespage Link");
		envelopespage.click();
		logger.log(Status.PASS, "Clicked the envelopespage Link");
		Envelopespage envelopespage = new Envelopespage(driver, logger);
		PageFactory.initElements(driver, envelopespage);
		return envelopespage;
	}
	public Settingspage settingspage() {
		logger.log(Status.INFO, "Clicking the settingspage Link");
		settingspage.click();
		logger.log(Status.PASS, "Clicked the settingspage Link");
		Settingspage settingspage = new Settingspage(driver, logger);
		PageFactory.initElements(driver, settingspage);
		return settingspage;
	}
	public Settingspage personalsettings() {
		logger.log(Status.INFO, "Clicking the settingspage Link");
		personalsettings.click();
		logger.log(Status.PASS, "Clicked the settingspage Link");
		Settingspage settingspage = new Settingspage(driver, logger);
		PageFactory.initElements(driver, settingspage);
		return settingspage;
		
	}
}
