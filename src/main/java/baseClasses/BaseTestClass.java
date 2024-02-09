package baseClasses;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClasses.Envelopespage;
import utilities.ExtentReportManager;
import utilities.GetLinkStatus;

public class BaseTestClass {

	public static WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) throws AWTException {

		try {

			if (browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-infobars");
				chromeOptions.addArguments("--disable-notifications");
				driver = new ChromeDriver(chromeOptions);

//			} else if (browserName.equalsIgnoreCase("Mozila")) {
//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
//				driver = new FirefoxDriver();
//			} else if (browserName.equalsIgnoreCase("Opera")) {
				// System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") +
				// "\\RSignautomation\\src\\main\\java\\operadriver.exe");
				// driver = new OperaDriver();
//			} else if (browserName.equalsIgnoreCase("IE")) {
//				System.setProperty("webdriver.ie.driver",
//						System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
//				driver = new InternetExplorerDriver();
//			}
			}
		} catch (Exception e) {
			// reportFail(e.getMessage());
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void flushReports() {
		report.flush();
		//driver.close();
	}
	public static void invalidlinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		 
		System.out.println("Number of Links are : " + links.size());
 
		for (WebElement link : links) {
			String URL = link.getAttribute("href");
			GetLinkStatus.verifyLink(URL);
		}
		System.out.println("Total Number of Broken Links :");
		GetLinkStatus.getInvalidLinkCount();
	}

	public Envelopespage sendbutton() throws InterruptedException {
		driver.findElement(By.xpath("(//*[@id='btnSend'])")).click();
		Thread.sleep(6000);
		Envelopespage envelopestab = new Envelopespage(driver, logger);
		PageFactory.initElements(driver, envelopestab);
		return envelopestab;
	}

	/***************** Select Date From Calendar *****************/
	public void selectDateIncalendar(String date) {

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date expectedDate = dateFormat.parse(date);

			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);

			String expectedMonthYear = month + " " + year;

			while (true) {
				String displayMonth = driver
						.findElement(By
								.xpath("(//*[@id='ui-datepicker-div']/div/div/select/option[@selected='selected'])[1]"))
						.getText();
				String displayyear = driver
						.findElement(By
								.xpath("(//*[@id='ui-datepicker-div']/div/div/select/option[@selected='selected'])[2]"))
						.getText();
				String displayDate = displayMonth + " " + displayyear;
				if (expectedMonthYear.equals(displayDate)) {

					driver.findElement(By.xpath("//*[text()= '" + day + "']")).click();
					break;
				} else if (expectedDate.compareTo(currentDate) > 0) {
					driver.findElement(By.xpath("//*[text()='Next']")).click();
				} else {
					driver.findElement(By.xpath("//*[text()='Prev']")).click();
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/***************** Wait Functions in Framework *****************/
	public static void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int i = 0;
		while (i != 180) {
			String pageState = (String) js.executeScript("return document.readyState;");
			if (pageState.equals("complete")) {
				break;
			} else {
				waitLoad(1);
			}
		}

		waitLoad(2);

		i = 0;
		while (i != 180) {
			Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			if (jsState) {
				break;
			} else {
				waitLoad(1);
			}
		}
	}

	public static void waitLoad(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}