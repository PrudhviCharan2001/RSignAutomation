package PageClasses;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import utilities.TestDataProvider;

public class Loginpage extends PageBaseClass {

	public Loginpage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
public Sendpage imanagelogin() {
	driver.get("https://cloudimanage.com/auth?auto_submit=false&remember_email=false#/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("/html/body/im-app/im-login/im-layout/section/section/section[1]/im-content/form/im-email/section/input")).sendKeys("prudhvi.vu@rpostlabs.com");
	driver.findElement(By.xpath("/html/body/im-app/im-login/im-layout/section/section/section[1]/im-content/form/button/span")).click();
	driver.findElement(By.xpath("/html/body/im-app/im-login/im-layout/section/section/section[1]/im-content/form/im-password/section/div/input")).sendKeys("VulliCharan@2001");
	driver.findElement(By.xpath("/html/body/im-app/im-login/im-layout/section/section/section[1]/im-content/form/button")).click();
	driver.findElement(By.xpath("//*[@id=\"ws-tree-panel\"]/im-tree/tree-root/tree-viewport/div/div/tree-node-collection/div/tree-node[6]/div/tree-node-wrapper/div[1]/tree-node-expander/span")).click();
	driver.findElement(By.xpath("//*[@id=\"ws-tree-panel\"]/im-tree/tree-root/tree-viewport/div/div/tree-node-collection/div/tree-node[6]/div/tree-node-children/div/tree-node-collection/div/tree-node/div/tree-node-wrapper/div/tree-node-expander/span")).click();
	driver.findElement(By.xpath("//*[@id=\"ws-tree-panel\"]/im-tree/tree-root/tree-viewport/div/div/tree-node-collection/div/tree-node[6]/div/tree-node-children/div/tree-node-collection/div/tree-node/div/tree-node-children/div/tree-node-collection/div/tree-node/div/tree-node-wrapper/div/tree-node-expander/span")).click();
	driver.findElement(By.xpath("//*[@id=\"ACTIVE!408_ACTIVE!406_ACTIVE!405_my-matters\"]/span[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"ws-name-ACTIVE!1668.1\"]/span")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/ws-toolbar/div/div[2]/button[12]/i/img")).click();
	driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys("deeparpost@yahoo.com");
	driver.findElement(By.xpath("//*[@id=\"btnEmailNext\"]")).click();
	waitForPageLoad();
	driver.findElement(By.xpath("//*[@id=\"password-login\"]")).sendKeys("Test@123");
	driver.findElement(By.xpath("//*[@id=\"btnEmailLogin\"]")).click();
	Sendpage sendpage=new Sendpage(driver,logger);
	PageFactory.initElements(driver, sendpage);
	return sendpage;
}
public Homepage sso() throws InterruptedException {
	driver.get("https://app3.use.rsign.com/Account/LogOn");
	driver.findElement(By.id("spnSingleSignIn")).click();
	waitForPageLoad();
	driver.findElement(By.xpath("//*[text()='Continue with Microsoft']")).click();
	//Thread.sleep(4000);
	//driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[3]/div/div/div[2]/div")).click();
	ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(1));
	driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]")).sendKeys("prudhvi.vu@rpostlabs.com");
	driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[4]/div/div/div/div[2]/input")).click();
	driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input")).sendKeys("Ch@ran142!");
	driver.findElement(By.id("idSIButton9")).click();
	driver.findElement(By.xpath("/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/input")).click();
	driver.switchTo().window(tab.get(0));
	waitForPageLoad();
	Homepage sendpage=new Homepage(driver,logger);
	PageFactory.initElements(driver, sendpage);
	return sendpage;
}
public void application() {
	driver.get("https://app3.use.rsign.com/Account/LogOn");
}
public void enteremail(String email) {
	driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[1]/div[1]/input")).sendKeys(email);
}
public void enterpassword(String password) {
	driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[1]/div[2]/input")).sendKeys(password);
}
public Homepage rsignlogin(String email,String password) {
	driver.get("https://app3.use.rsign.com/Account/LogOn");
	driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[1]/div[1]/input")).sendKeys(email);
	driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[1]/div[2]/input")).sendKeys(password);
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")).click();
	driver.switchTo().parentFrame();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[4]/button"))));
	driver.findElement(By.xpath("/html/body/main/div/div/div/div[1]/form/div[4]/button")).click();
	Homepage homepage=new Homepage(driver,logger);
	PageFactory.initElements(driver, homepage);
	return homepage;
}
}