//package PageClasses;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.aventstack.extentreports.ExtentTest;
//
//import baseClasses.PageBaseClass;
//import baseClasses.TopMenuClass;
//
//public class AttachSignedPdfForThoseReceipients extends PageBaseClass {
//	public TopMenuClass topmenu;
//	@FindBy(xpath = "//*[@id='nav-advanced-tab']")
//	public WebElement Advancedsettings;
//	@FindBy(xpath = "//*[@id='AttachSignedPdfID']")
//	public WebElement attachsignedpdfdropdown;
//	@FindBy(xpath = "//*[@id='nav-advanced-tab']")
//	public WebElement Advancedsettings;
//	@FindBy(xpath = "//*[@id='nav-advanced-tab']")
//	public WebElement Advancedsettings;
//	@FindBy(xpath = "//*[@id='nav-advanced-tab']")
//	public WebElement Advancedsettings;
//	@FindBy(xpath = "//*[@id='nav-advanced-tab']")
//	public WebElement Advancedsettings;
//
//	public AttachSignedPdfForThoseReceipients(WebDriver driver, ExtentTest logger) {
//		super(driver, logger);
//		topmenu = new TopMenuClass(driver, logger);
//		PageFactory.initElements(driver, topmenu);
//	}
//	public void Senderonly() {
//		
//	}
//	public TopMenuClass topmenu() {
//		return topmenu;
//	}
//	
//}
