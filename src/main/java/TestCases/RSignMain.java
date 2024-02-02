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
		System.out.println("Execution started");
		invokeBrowser("chrome");
		System.out.println("Chrome opened");
		Loginpage loginpage = new Loginpage(driver, logger);
		homepage = loginpage.sso();
		System.out.println("Login completed");
		topmenu = homepage.topmenu();
		//------------------------------------Multi signer static template-------------------------------------------------------------
		templatepage = topmenu.templatespage();
		templatepage = templatepage.createmultistatictemp(dataTable.get("MultiSignerStaticTemplatename"));
		System.out.println("Multi signer static Template created");
		templatepage.consumemultisignerstatictemplate(dataTable.get("MultiSignerStaticTemplatename"));
		System.out.println("Multi signer static Template consumed");
		//-------------------------------------Single signer static template------------------------------------------------------------
		templatepage = topmenu.templatespage(); 
		templatepage=templatepage.createstatictemplate(dataTable.get("StaticTemplatename"));
		 System.out.println("single signer static Template created");
		templatepage.consumestatictemplate(dataTable.get("StaticTemplatename"));
		System.out.println("single signer static Template consumed");
		//--------------------------------------Template------------------------------------------------------------
		driver.navigate().refresh();
		templatepage = topmenu.templatespage();
		templatepage=templatepage.createtemplate(dataTable.get("NonStaticTemplatename"));
		System.out.println("Template created");
		envelopespage=templatepage.consumetemplate(dataTable.get("NonStaticTemplatename"));
		System.out.println("Template sended");
		yahoosign yahoo=new yahoosign(driver,logger);
		System.out.println("hotmail login");
		yahoo.recipientsigninoutlook();
		System.out.println("Signing completed");
		topmenu=envelopespage.topmenu();
	//	---------------------------------------Rule------------------------------------------------------------
		driver.navigate().refresh();
		templatepage = topmenu.templatespage();
		templatepage=templatepage.createrule(dataTable.get("Rulename"));
		System.out.println("Rule created");
		envelopespage=templatepage.consumerule(dataTable.get("Rulename"));
		System.out.println("Rule sended");
		topmenu=envelopespage.topmenu();
		yahoosign yahoo1=new yahoosign(driver,logger);
		System.out.println("yahoo login");
		yahoo1.recipientsigninoutlookwithoutlogin();
		System.out.println("Signing completed");
	//---------------------------------------Envelope-----------------------------------------------------------
		sendpage=topmenu.sendpage();
		driver.navigate().refresh();
		System.out.println("start step-1");
		step2=Sendpage.step1(dataTable.get("EnvelopeSubject"),dataTable.get("EnvelopeBody"));
		System.out.println("start step-2");
		step2.allcontrols();
		System.out.println("envelope sent");
		envelopespage=step2.sendbutton();
		yahoosign yahoo2=new yahoosign(driver,logger);
		System.out.println("yahoo login");
		yahoo2.recipientsigninoutlookwithoutlogin();
		System.out.println("Signing completed");
		//yahoo2.reverifysigner();
		//-----------------------------------------Changing language-----------------------------------------------------------
		topmenu=envelopespage.topmenu();
		System.out.println("Click on settings");
		settingspage = topmenu.personalsettings();
		settingspage.changelanguage(i);
		System.out.println("Language changed");
		i++;
	}
	
	@DataProvider
	public Object[][] getDatadoRsignLanguagesTest() {
		return TestDataProvider.getTestData("TestData_Testmanagement.xlsx", "Feature 1", "Test Three");
	}
}