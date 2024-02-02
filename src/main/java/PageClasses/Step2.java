package PageClasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class Step2 extends PageBaseClass{
	public TopMenuClass topmenu;
	
	  
	public Step2(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	public  Envelopespage sendbutton() {
		sendbutton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Envelopespage envelopestab = new Envelopespage(driver,logger);
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
		//hyperlink();
		radiobutton();	
		date();		
		text();	
		//label();	
	}
}
