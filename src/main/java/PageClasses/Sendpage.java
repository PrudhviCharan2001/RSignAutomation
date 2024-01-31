package PageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class Sendpage extends PageBaseClass{
	public TopMenuClass topmenu;

	public Sendpage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	@FindBy(xpath = "/html/body/div[1]/div[1]/form/ul/li[2]/div/div[2]/a[1]")
	public static WebElement addrecipient;
	@FindBy(xpath = "(//*[contains(@class,'reciptName ')])")
	public static WebElement recipientname;
	@FindBy(xpath = "(//*[contains(@class,'reciptEmail')])")
	public static WebElement recipientemail;
	@FindBy(xpath = "(//*[contains(@for,'chbSequence')])")
	public static WebElement signinsequence;
	@FindBy(xpath = "//*[@id='btnNext']")
	public static WebElement next;
	@FindBy(xpath = "/html/body/header/div[2]/div[2]/a")
	public static WebElement saveasdraft;
	@FindBy(xpath = "/html/body/div[1]/div[1]/form/ul/li[1]/div/div[1]/a[2]")
	public static WebElement addtemplate;
	@FindBy(xpath = "/html/body/div[1]/div[1]/form/ul/li[1]/div/div[1]/a[4]")
	public static WebElement addrule;
	@FindBy(xpath = "/html/body/div[1]/div[1]/form/ul/li[1]/div/div[1]/a[4]")
	public static WebElement addtemplategroup;

	public static void addrecipientdetails(String name,String email) {
		recipientname.sendKeys(email);
		recipientemail.sendKeys(name);
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/ul/li[2]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/span/input")).sendKeys("7032997552");
	}
public TopMenuClass topmenu() {
		return topmenu;
	}
	public static void next() throws InterruptedException {
		//driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/span")).click();
		next.click();
	}
	public static Step2 step1() throws Exception{
		adddocument("C:\\Users\\RPLPT\\OneDrive\\Desktop\\RPost\\RSign\\API contract &.pdf");
		addrecipientdetails("prudhvicharanv@hotmail.com","prudhvicharanv");
		subject("signing document","test");
		Thread.sleep(3000);
		next();
		Step2 step2 = new Step2(driver,logger);
		PageFactory.initElements(driver, step2);
		return step2;
	}
}
