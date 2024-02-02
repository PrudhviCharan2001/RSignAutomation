package signingpage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import PageClasses.Loginpage;
import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class yahoosign extends PageBaseClass {
	Loginpage loginpage;
	TopMenuClass topmenu;
	public yahoosign(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	
	public void recipientsigninoutlook() throws InterruptedException, AWTException
	{
	((JavascriptExecutor) driver).executeScript("window.open()");
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=18&ct=1702203337&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26deeplink%3dowa%252f%253frealm%253dhotmail.com%26RpsCsrfState%3d6a2a7847-ad0f-6eae-3c15-fb950763897d&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
	Thread.sleep(2000);
	yahooemail.sendKeys("prudhvicharanv@hotmail.com");
	emailnextbtn.click();
	Thread.sleep(2000);
	yahoopassword.sendKeys("Charan@2001");
	yahoologinbtn.click();
	Thread.sleep(1000);
	staysignedin.click();
	Thread.sleep(1000);
	driver.navigate().refresh();
	driver.navigate().refresh();
	Thread.sleep(7000);
	openmail.click();
	viewandsigndocument.click();
	ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(2));
	waitForPageLoad();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",termsandservice);
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();",acceptclicktosigncheckbox);
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();",acceptclicktosign);
	clickonsignature.click();
	js.executeScript("arguments[0].click();",clickoninitial);
	js.executeScript("arguments[0].click();",namecontrol);
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[4]/div/div[1]/input")).sendKeys("prudhvi");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[5]/div/div[1]/input")).sendKeys("rpo");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[6]/div/div[1]/input")).sendKeys("RPOST");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[7]/div/div[1]/input")).sendKeys("prudhvicharanv@yahoo.com");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[9]/div/div[1]/span[1]/input")).click();
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[10]/div/div[1]/input")).click();
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[11]/div/div[1]/input")).click();
	selectDateIncalendar("11/09/2019");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[12]/div/div[1]/textarea")).sendKeys("hello");
	driver.findElement(By.xpath("//*[@id='btnSubmitEnvelope']")).click();
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("window.close()");
	driver.switchTo().window(tab.get(1));
	((JavascriptExecutor) driver).executeScript("window.close()");
	driver.switchTo().window(tab.get(0));
	Thread.sleep(5000);
	}
	public void recipientsigninoutlookwithoutlogin() throws InterruptedException, AWTException
	{
	((JavascriptExecutor) driver).executeScript("window.open()");
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=18&ct=1702203337&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26deeplink%3dowa%252f%253frealm%253dhotmail.com%26RpsCsrfState%3d6a2a7847-ad0f-6eae-3c15-fb950763897d&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
	Thread.sleep(3000);
	driver.navigate().refresh();
	driver.navigate().refresh();
	Thread.sleep(7000);
	openmail.click();
	viewandsigndocument.click();
	ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(2));
	waitForPageLoad();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",termsandservice);
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();",acceptclicktosigncheckbox);
	Thread.sleep(2000);
	js.executeScript("arguments[0].click();",acceptclicktosign);
	clickonsignature.click();
	js.executeScript("arguments[0].click();",clickoninitial);
	js.executeScript("arguments[0].click();",namecontrol);
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[4]/div/div[1]/input")).sendKeys("prudhvi");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[5]/div/div[1]/input")).sendKeys("rpo");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[6]/div/div[1]/input")).sendKeys("RPOST");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[7]/div/div[1]/input")).sendKeys("prudhvicharanv@yahoo.com");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[9]/div/div[1]/span[1]/input")).click();
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[10]/div/div[1]/input")).click();
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[11]/div/div[1]/input")).click();
	selectDateIncalendar("11/09/2019");
	driver.findElement(By.xpath("/html/body/div[1]/main/div/div[3]/div/div/div/div/div[1]/div[1]/div[12]/div/div[1]/textarea")).sendKeys("hello");
	driver.findElement(By.xpath("//*[@id='btnSubmitEnvelope']")).click();
	Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("window.close()");
	driver.switchTo().window(tab.get(1));
	((JavascriptExecutor) driver).executeScript("window.close()");
	driver.switchTo().window(tab.get(0));
	Thread.sleep(5000);
	}
	
public void reverifysigner() throws InterruptedException, AWTException {
	ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(1));
	Thread.sleep(10000);
	driver.navigate().refresh();
	openmail.click();
	String code=driver.findElement(By.xpath("//*[text()='Verification Code:']//parent::b//parent::p//parent::td//parent::tr/td[2]/span")).getText();
	driver.switchTo().window(tab.get(2));
	driver.findElement(By.xpath("//*[@id='ConfirmSubmitVerificationCode']")).sendKeys(code);
	driver.findElement(By.xpath("//*[@id='btnValidateConfirmCode']")).click();
	Thread.sleep(5000);
	((JavascriptExecutor) driver).executeScript("window.close()");
	driver.switchTo().window(tab.get(1));
	((JavascriptExecutor) driver).executeScript("window.close()");
	driver.switchTo().window(tab.get(0));
}

}