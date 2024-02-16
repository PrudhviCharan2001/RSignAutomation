package signingpage;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import PageClasses.Loginpage;
import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class Signing extends PageBaseClass {
	Loginpage loginpage;
	TopMenuClass topmenu;

	public Signing(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}

	public void recipientsigninoutlook(String email, String password) throws InterruptedException, AWTException {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=18&ct=1702203337&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26deeplink%3dowa%252f%253frealm%253dhotmail.com%26RpsCsrfState%3d6a2a7847-ad0f-6eae-3c15-fb950763897d&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		Thread.sleep(2000);
		yahooemail.sendKeys(email);
		Thread.sleep(2000);
		emailnextbtn.click();
		Thread.sleep(2000);
		yahoopassword.sendKeys(password);
		Thread.sleep(2000);
		yahoologinbtn.click();
		Thread.sleep(1000);
		staysignedin.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(7000);
		openmail.click();
		Thread.sleep(3000);
		viewandsigndocument.click();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(2));
		waitForPageLoad();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", termsandservice);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", acceptclicktosigncheckbox);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", acceptclicktosign);
		clickonsignature.click();
		js.executeScript("arguments[0].click();", clickoninitial);
		js.executeScript("arguments[0].click();", namecontrol);
		driver.findElement(
				By.xpath("//*[contains(@id,'control_nameControl')]"))
				.sendKeys("prudhvi");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_titleControl')]"))
				.sendKeys("rpo");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_companyControl')]"))
				.sendKeys("RPOST");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_emailControl')]"))
				.sendKeys("prudhvicharanv@yahoo.com");
		driver.findElement(By.xpath(
				"//*[contains(@id,'control_checkboxControl')]"))
				.click();
		driver.findElement(
				By.xpath("//*[contains(@id,'control_radioControl')]"))
				.click();
		driver.findElement(
				By.xpath("//*[contains(@id,'control_dateControl')]"))
				.click();
		selectDateIncalendar("11/09/2019");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_textControl')]"))
				.sendKeys("Please sign the document");
		driver.findElement(By.xpath("//*[@id='btnSubmitEnvelope']")).click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.close()");
		driver.switchTo().window(tab.get(1));
		((JavascriptExecutor) driver).executeScript("window.close()");
		driver.switchTo().window(tab.get(0));
		Thread.sleep(5000);
	}

	public void recipientsigninoutlookwithoutlogin() throws InterruptedException, AWTException {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=18&ct=1702203337&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26deeplink%3dowa%252f%253frealm%253dhotmail.com%26RpsCsrfState%3d6a2a7847-ad0f-6eae-3c15-fb950763897d&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(7000);
		openmail.click();
		viewandsigndocument.click();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(2));
		waitForPageLoad();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", termsandservice);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", acceptclicktosigncheckbox);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", acceptclicktosign);
		clickonsignature.click();
		js.executeScript("arguments[0].click();", clickoninitial);
		js.executeScript("arguments[0].click();", namecontrol);
		driver.findElement(
				By.xpath("//*[contains(@id,'control_nameControl')]"))
				.sendKeys("prudhvi");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_titleControl')]"))
				.sendKeys("rpo");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_companyControl')]"))
				.sendKeys("RPOST");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_emailControl')]"))
				.sendKeys("prudhvicharanv@yahoo.com");
		driver.findElement(By.xpath(
				"//*[contains(@id,'control_checkboxControl')]"))
				.click();
		driver.findElement(
				By.xpath("//*[contains(@id,'control_radioControl')]"))
				.click();
		driver.findElement(
				By.xpath("//*[contains(@id,'control_dateControl')]"))
				.click();
		selectDateIncalendar("11/09/2019");
		driver.findElement(
				By.xpath("//*[contains(@id,'control_textControl')]"))
				.sendKeys("Please sign the document");
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
		String code = driver
				.findElement(By.xpath(
						"//*[text()='Verification Code:']//parent::b//parent::p//parent::td//parent::tr/td[2]/span"))
				.getText();
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