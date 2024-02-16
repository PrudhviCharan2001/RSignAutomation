package TestCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import PageClasses.Envelopespage;
import PageClasses.Homepage;
import PageClasses.Loginpage;
import PageClasses.Sendpage;
import PageClasses.Settingspage;
import PageClasses.Step2;
import PageClasses.Templatespage;
import baseClasses.BaseTestClass;
import baseClasses.TopMenuClass;
import signingpage.Signing;
import utilities.TestDataProvider;

public class RSignMain extends BaseTestClass {

	ExtentTest logger;
	TopMenuClass topmenu;
	Homepage homepage;
	Sendpage sendpage;
	Envelopespage envelopespage;
	Settingspage settingspage;
	Step2 step2;
	Signing yahoo;
	Templatespage templatepage;
	static int i = 1, aa=2;
	

	@Test(dataProvider = "RsignLanguagesTest")
	public void rsignimanagegerman(Hashtable<String, String> dataTable) throws Exception {
		logger = report.createTest("RSign Test for"+dataTable.get("language"));
		invokeBrowser("chrome");
		logger.log(Status.INFO, "Chrome opened");
		Loginpage loginpage = new Loginpage(driver, logger);
		homepage = loginpage.sso("prudhvi.vu@rpostlabs.com", "Ch@ran142!");
		topmenu = homepage.topmenu();
		/* ---------------------------------------Multi signer static template-----------------------------------------------------------*/
		logger.log(Status.INFO,MarkupHelper.createLabel("Creating multi signer static template", ExtentColor.GREEN));
		templatepage = topmenu.templatespage();
		templatepage = templatepage.createmultistatictemp(dataTable.get("MultiSignerStaticTemplatename"));
		logger.log(Status.INFO,MarkupHelper.createLabel("Signing multi signer static template", ExtentColor.GREEN));
		templatepage.consumemultisignerstatictemplate(dataTable.get("MultiSignerStaticTemplatename"));
		/* ---------------------------------------Single signer static template-----------------------------------------------------------*/
		templatepage = topmenu.templatespage();
		logger.log(Status.INFO,MarkupHelper.createLabel("Creating Single signer static template", ExtentColor.GREEN));
		templatepage = templatepage.createstatictemplate(dataTable.get("StaticTemplatename"));
		logger.log(Status.INFO,MarkupHelper.createLabel("Consuming single signer static template", ExtentColor.GREEN));
		templatepage.consumestatictemplate(dataTable.get("StaticTemplatename"));
		/* ---------------------------------------Template-----------------------------------------------------------*/
		templatepage = topmenu.templatespage();
		logger.log(Status.INFO,MarkupHelper.createLabel("Creating template", ExtentColor.GREEN));
		templatepage = templatepage.createtemplate(dataTable.get("NonStaticTemplatename"));
		logger.log(Status.INFO,MarkupHelper.createLabel("Consuming template", ExtentColor.GREEN));
		envelopespage = templatepage.consumetemplate(dataTable.get("NonStaticTemplatename"));
		Signing yahoo = new Signing(driver, logger);
		logger.log(Status.INFO,MarkupHelper.createLabel("Logged and signing", ExtentColor.GREEN));
		yahoo.recipientsigninoutlook("prudhvicharanv@hotmail.com", "Charan@2001");
		topmenu = envelopespage.topmenu();
		/* ---------------------------------------Rule-----------------------------------------------------------*/
		templatepage = topmenu.templatespage();
		logger.log(Status.INFO,MarkupHelper.createLabel("Creating Rule", ExtentColor.RED));
		templatepage = templatepage.createrule(dataTable.get("Rulename"));
		logger.log(Status.PASS,MarkupHelper.createLabel("Consuming Rule", ExtentColor.GREEN));
		envelopespage = templatepage.consumerule(dataTable.get("Rulename" ),aa);
		Signing yahoo1 = new Signing(driver, logger);
		logger.log(Status.INFO,MarkupHelper.createLabel("Login to mail and signing the rule", ExtentColor.GREEN));
		yahoo1.recipientsigninoutlookwithoutlogin(aa);
		topmenu = envelopespage.topmenu();
		/* ---------------------------------------Envelope-----------------------------------------------------------*/
		sendpage = topmenu.sendpage();
		logger.log(Status.INFO,MarkupHelper.createLabel("Step-1 completed", ExtentColor.GREEN));
		step2 = Sendpage.step1(dataTable.get("EnvelopeSubject"), dataTable.get("EnvelopeBody"), aa);
		logger.log(Status.INFO,MarkupHelper.createLabel("Step-1 completed", ExtentColor.GREEN));
		step2.allcontrols();
		envelopespage = step2.sendbutton();
		logger.log(Status.INFO,MarkupHelper.createLabel("Envelope sent", ExtentColor.GREEN));
		envelopespage.resend();
		logger.log(Status.INFO,MarkupHelper.createLabel("Envelope resend", ExtentColor.GREEN));
		envelopespage.updateandresend();
		logger.log(Status.INFO,MarkupHelper.createLabel("Envelope update and resend", ExtentColor.GREEN));
		envelopespage.copy();
		logger.log(Status.INFO,MarkupHelper.createLabel("Envelope copy", ExtentColor.GREEN));
		Signing yahoo2 = new Signing(driver, logger);
		logger.log(Status.INFO,MarkupHelper.createLabel("Login to mail and signing the rule", ExtentColor.GREEN));
		yahoo2.recipientsigninoutlookwithoutlogin(aa);
		// yahoo2.reverifysigner();
		/* ---------------------------------------Change language-----------------------------------------------------------*/
		topmenu = envelopespage.topmenu();
		System.out.println("Click on settings");
		settingspage = topmenu.personalsettings();
		settingspage.changelanguage(i);
		System.out.println("Language changed");
		i++;
	}
	@DataProvider
	public Object[][] RsignLanguagesTest() {
		return TestDataProvider.getTestData("TestData_Testmanagement.xlsx", "Feature 1", "Test Three");
	}
}
