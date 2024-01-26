package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class Settingspage extends PageBaseClass {
	public TopMenuClass topmenu;
	@FindBy(xpath = "/html/body/div[1]/div[1]/main/div[2]/div/div[3]/div[2]/div[1]/form/ul/li[6]/div/div[1]/select")
	public WebElement languagedropdown;
		@FindBy(xpath = "//*[@id='btnSaveAdvanceSettings']")
		public WebElement savesettings;
	public Settingspage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	public void changelanguage(int languagenumber) throws InterruptedException {
		Thread.sleep(2000);
		languagedropdown.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='LanguageCode']/option["+languagenumber+"]")).click();
		Thread.sleep(2000);
		savesettings.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='done btn'])[2]")).click();
		Thread.sleep(2000);
	driver.close();
	}
	public TopMenuClass topmenu() {
		return topmenu;
	}
}
