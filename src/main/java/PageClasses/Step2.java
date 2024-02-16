package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class Step2 extends PageBaseClass{
	public TopMenuClass topmenu;
	
	  
	public Step2(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
		
	
	public void allcontrols() throws InterruptedException {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='linkGetEnvelopeSettings']"))));
		Thread.sleep(2000);
		
driver.findElement(By.xpath("//*[@id='linkGetEnvelopeSettings']")).click();
Thread.sleep(15000);
driver.findElement(By.xpath("//*[contains(@class,'viewSettingsClose')]")).click();
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
		 catch(Exception e) {
				reportFail(e.getMessage());
			}
}}
