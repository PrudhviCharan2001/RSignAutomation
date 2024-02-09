package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class Envelopespage extends PageBaseClass{
	
	@FindBy(xpath = "(//*[@class='openDetails'])[1]")
	public static WebElement expandenvelope;
	@FindBy(xpath = "(//*[@class='manage-envelope'])[1]")
	public static WebElement manageenvelope;
	@FindBy(xpath = "(//div[@class='popover fade left in']/div/div/a[contains(@href,'/DocumentPackage/SendmailReminder')])")
	public static WebElement resendbutton;
	@FindBy(xpath = "(//*[contains(@class,'pencil')])[1]")
	public static WebElement editrecipient;
	@FindBy(xpath = "(//*[contains(@class,'ditEmailRec')])[1]")
	public static WebElement newemail;
	@FindBy(xpath = "(//*[contains(@class,'editNameRec')])[1]")
	public static WebElement newname;
	@FindBy(xpath = "(//*[contains(@class,'saveFunc')])[1]")
	public static WebElement saverecipient;
	@FindBy(xpath = "(//*[contains(@class,'modalResendToAll')])[1]")
	public static WebElement resendtoall;
	@FindBy(xpath = "(//div[@class='popover fade left in']/div/div/a[contains(@href,'/Envelope/UpdateResendEnvelope')])")
	public static WebElement updateandresend;
	@FindBy(xpath = "(//div[@class='popover fade left in']/div/div/a[contains(@href,'/Envelope/CopyEnvelope')])")
	public static WebElement copy;
	@FindBy(xpath = "//div[@class='popover fade left in']/div/div/a[contains(@id,'ankManageEnvelope')]")
	public static WebElement moreactions;
	@FindBy(xpath = "//*[@class='regenerateFinalContract']")
	public static WebElement managefinalsigneddocument;
	@FindBy(xpath = "(//*[@class='tdContactCheck'])[1]")
	public static WebElement regeneratetofirstsigner;
	@FindBy(xpath = "(//*[@class='tdContactCheck'])[2]")
	public static WebElement regeneratetosecondsigner;
	@FindBy(xpath = "(//*[@id='BtnRegenerate'])]")
	public static WebElement regeneratesubmit;
	@FindBy(xpath = "(//*[@class='close closeRegenerateModal'])")
	public static WebElement closeregeneratepopup;
	
	public TopMenuClass topmenu;

	public Envelopespage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	public void resend() throws InterruptedException {
		//invalidlinks();
		waitForPageLoad();
		expandenvelope.click();
		waitForPageLoad();
		manageenvelope.click();
		waitForPageLoad();
		resendbutton.click();
		waitForPageLoad();
		editrecipient.click();
		waitForPageLoad();
		saverecipient.click();
		waitForPageLoad();
		resendtoall.click();
	}
	public void updateandresend() throws InterruptedException {
		waitForPageLoad();
		expandenvelope.click();
		waitForPageLoad();
		manageenvelope.click();
		waitForPageLoad();
		updateandresend.click();
		waitForPageLoad();
		next();
		waitForPageLoad();
		sendbutton();
	}
	public void copy() throws InterruptedException {
		waitForPageLoad();
		expandenvelope.click();
		waitForPageLoad();
		manageenvelope.click();
		waitForPageLoad();
		copy.click();
		waitForPageLoad();
		next();
		waitForPageLoad();
		sendbutton();
	}
	public TopMenuClass topmenu() {
		return topmenu;
	}
	

}
