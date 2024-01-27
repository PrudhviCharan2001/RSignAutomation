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
		System.out.println("Hiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		homepage = loginpage.sso();
		topmenu = homepage.topmenu();
		templatepage = topmenu.templatespage();
		templatepage = templatepage.createmultistatictemp(dataTable.get("MultiSignerStaticTemplatename"));
		templatepage.consumemultisignerstatictemplate(dataTable.get("MultiSignerStaticTemplatename"));
		// templatepage=templatepage.createstatictemplate(dataTable.get("StaticTemplatename"));
		//templatepage.consumestatictemplate(dataTable.get("StaticTemplatename"));
		//templatepage=templatepage.createtemplate(dataTable.get("NonStaticTemplatename"));
		//envelopespage=templatepage.consumetemplate(dataTable.get("NonStaticTemplatename"));
		//templatepage=templatepage.createrule(dataTable.get("Rulename"));
		//envelopespage=templatepage.consumerule(dataTable.get("Rulename"));
		//sendpage=topmenu.sendpage();
		//step2=Sendpage.step1();
		//step2.allcontrols();
		//envelopespage=step2.sendbutton();
		//yahoosign yahoo=new yahoosign(driver,logger);
		//yahoo.recipientsigninyahoo();
		//yahoo.reverifysigner();
		//topmenu=envelopespage.topmenu();
		//topmenu = templatepage.topmenu();
		//settingspage = topmenu.personalsettings();
		//settingspage.changelanguage(i);
		//i++;
	}
	
	@DataProvider
	public Object[][] getDatadoRsignLanguagesTest() {
		return TestDataProvider.getTestData("TestData_Testmanagement.xlsx", "Feature 1", "Test Three");
	}
}