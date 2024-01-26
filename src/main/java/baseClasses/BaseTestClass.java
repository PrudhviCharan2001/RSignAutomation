package baseClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import utilities.ExtentReportManager;

public class BaseTestClass {

	public static WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {

		try {

			if (browserName.equalsIgnoreCase("chrome")) {
			
				driver = new ChromeDriver();
//			} else if (browserName.equalsIgnoreCase("Mozila")) {
//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
//				driver = new FirefoxDriver();
//			} else if (browserName.equalsIgnoreCase("Opera")) {
			//System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\RSignautomation\\src\\main\\java\\operadriver.exe");
			//driver = new OperaDriver();
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


	public void flushReports() {
		report.flush();
		driver.close();
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
				String displayMonth = driver.findElement(By.xpath("(//*[@id='ui-datepicker-div']/div/div/select/option[@selected='selected'])[1]")).getText();
				String displayyear = driver.findElement(By.xpath("(//*[@id='ui-datepicker-div']/div/div/select/option[@selected='selected'])[2]")).getText();
				String displayDate=displayMonth+" "+displayyear;
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