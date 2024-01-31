package TestCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import PageClasses.Envelopespage;
import PageClasses.Homepage;
import PageClasses.Loginpage;
import PageClasses.Sendpage;
import PageClasses.Settingspage;
import PageClasses.Step2;
import PageClasses.Templatespage;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;
import signingpage.yahoosign;
import utilities.TestDataProvider;

public class RSignMain extends BaseTestClass {
	
	ExtentTest logger;
	TopMenuClass topmenu;
	Homepage homepage;
	Sendpage sendpage;
	Envelopespage envelopespage;
	Settingspage settingspage;
	Step2 step2;
	yahoosign yahoo;
	Templatespage templatepage;
	static int i=2;
	
	@Test(dataProvider = "getDatadoRsignLanguagesTest")
	public void rsignimanagegerman(Hashtable<String, String> dataTable) throws Exception {
		logger = report.createTest("create RSign Test : ");
		invokeBrowser("chrome");
		Loginpage loginpage = new Loginpage(driver, logger);
	homepage = loginpage.sso();
		topmenu = homepage.topmenu();
//		templatepage = topmenu.templatespage();
		//templatepage = templatepage.createmultistatictemp(dataTable.get("MultiSignerStaticTemplatename"));
		//templatepage.consumemultisignerstatictemplate(dataTable.get("MultiSignerStaticTemplatename"));
		 //templatepage=templatepage.createstatictemplate(dataTable.get("StaticTemplatename"));
		// Thread.sleep(15000);
		//templatepage.consumestatictemplate(dataTable.get("StaticTemplatename"));
		//templatepage=templatepage.createtemplate(dataTable.get("NonStaticTemplatename"));
		//envelopespage=templatepage.consumetemplate(dataTable.get("NonStaticTemplatename"));
		//templatepage=templatepage.createrule(dataTable.get("Rulename"));
		//envelopespage=templatepage.consumerule(dataTable.get("Rulename"));
		sendpage=topmenu.sendpage();
		System.out.println("start step-1");
		step2=Sendpage.step1();
		System.out.println("start step-2");
		step2.allcontrols();
		System.out.println("envelope sent");
		envelopespage=step2.sendbutton();
		yahoosign yahoo=new yahoosign(driver,logger);
		System.out.println("yahoo login");
		yahoo.recipientsigninyahoo();
		System.out.println("Signing completed");
		//yahoo.reverifysigner();
		topmenu=envelopespage.topmenu();
		// topmenu = templatepage.topmenu();
		System.out.println("Click on settings");
		settingspage = topmenu.personalsettings();
		System.out.println("clicked");
		settingspage.changelanguage(i);
		System.out.println("Language changed");
		i++;
	}
	
	@DataProvider
	public Object[][] getDatadoRsignLanguagesTest() {
		return TestDataProvider.getTestData("TestData_Testmanagement.xlsx", "Feature 1", "Test Three");
	}
}