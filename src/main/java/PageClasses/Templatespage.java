package PageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;
import baseClasses.TopMenuClass;

public class Templatespage extends PageBaseClass {
	public TopMenuClass topmenu;
	public static String tempnametext;
	@FindBy(xpath = "/html/body/div[1]/div[1]/form/div[2]/a[1]")
	public static WebElement createtemplatenbtn;
	@FindBy(xpath = "//*[@id='AddRoles']")
	public static WebElement addrole;
	@FindBy(xpath = "(//*[contains(@class,'roleName')])[1]")
	public static WebElement rolename;
	@FindBy(xpath = "//*[contains(@class,'custom dropdown deliveryMode')]")
	public static WebElement deliverymode;
	@FindBy(xpath = "//*[contains(@class,'custom dropdown deliveryMode')]/ul/li[2]")
	public static WebElement emaildeliverymode;
	@FindBy(xpath = "//*[contains(@class,'custom dropdown deliveryMode')]/ul/li[3]")
	public static WebElement emailandmobiledeliverymode;
	@FindBy(xpath = "//*[contains(@class,'custom dropdown deliveryMode')]/ul/li[4]")
	public static WebElement mobiledeliverymode;
	@FindBy(xpath = "//*[@class='choice staticLink']/a[2]")
	public static WebElement enablestatictemplate;
	@FindBy(xpath = "//*[@class='choice staticLink']/a[1]")
	public static WebElement disablestatictemplate;
	@FindBy(xpath = "//*[@id='btnTemplateRules']")
	public static WebElement saveasrule;
	@FindBy(xpath = "//*[@id='btnSave']")
	public static WebElement saveastemplate;
	@FindBy(xpath = "//*[@class='sendDropdown']")
	public static WebElement saveas;
	@FindBy(xpath = "//*[@class='form-control templateNameD']")
	public static WebElement templatename;
	@FindBy(xpath = "//*[@class='form-control templateDescD']")
	public static WebElement templatedescription;
	@FindBy(xpath = "(//*[@class='templateName'])[1]")
	public static WebElement templatenametext;
	@FindBy(xpath = "//*[@id='templateButton']")
	public static WebElement addtemplatebtn;
	@FindBy(xpath = "//*[@id='txtTempsearch']")
	public static WebElement templatesearch;
	@FindBy(xpath = "(//*[@id='chkTemplate'])[1]")
	public static WebElement selecttemplateorrule;
	@FindBy(xpath = "(//*[@class='done btn'])[2]")
	public static WebElement templatedonebtn;
	@FindBy(xpath = "(//*[@class='done btn'])[2]")
	public static WebElement ruledonebtn;
	@FindBy(xpath = "//*[@id='btnSendEnvelopeFromTemplate']")
	public static WebElement sendtemplate;
	@FindBy(xpath = "//*[@id='ruleButton']")
	public static WebElement addrule;
	@FindBy(xpath = "//*[@id='txtsearch']")
	public static WebElement searchrule;
	@FindBy(xpath = "//*[@class='templateListTBody']/tr/td[@class='templateName']/div[text()='template_7/12/23']//parent::div//parent::td//parent::tr/td[8]/a")
	public static WebElement staticlink;
	@FindBy(xpath = "(//*[@id='dialog-message'])[3]")
	public static WebElement copystaticlink;
	@FindBy(xpath = "//*[@id='txtFirstSignerEmail']")
	public static WebElement ss_ctb_email;
	@FindBy(xpath = "//*[@id='txtConfirmSignerMobileNumber']")
	public static WebElement ss_ctb_mobile;
	@FindBy(xpath = "//*[@id='chkFirsrtterms']")
	public static WebElement ss_ctb_acceptterms;
	@FindBy(xpath = "//*[@id='btnFirstAccept']")
	public static WebElement ss_ctb_nextbtn;
	@FindBy(xpath = "//*[@id='btnContinueTermsAndService']")
	public static WebElement accepttermsinsigningpage;
	@FindBy(xpath = "//*[@id='btnSendConfirmEmailSend']")
	public static WebElement sendconfirmationbtn;
	@FindBy(xpath = "(//*[contains(@href,'https://sign.use.rsign.com//SignDocument/SubmitEnvByConfirmationLink')])[1]")
	public static WebElement confirmemailbtn;
	@FindBy(xpath = "//*[@class='templateListTBody']/tr/td[@class='templateName']/div[text()='multisigner static template-1']//parent::div//parent::td//parent::tr/td[8]/a")
	public static WebElement multistaticlink;
	@FindBy(xpath = "//*[@id='RolsTypesInfo']")
	public static WebElement selectrole;
	@FindBy(xpath = "//*[@id='btnInviteSigner']")
	public static WebElement invitesigner;
	@FindBy(xpath = "//*[@id='txtInvSignName_1']")
	public static WebElement invitesignername;
	@FindBy(xpath = "//*[@id='txtInvSignEmail_1']")
	public static WebElement invitesigneremail;
	@FindBy(xpath = "//*[@id='txtInvSignMobile_1']")
	public static WebElement invitesignermobile;
	@FindBy(xpath = "//*[@id='iMydetails']")
	public static WebElement invitesignermydetails;
	@FindBy(xpath = "//*[@id='txtmyName']")
	public static WebElement invitesignermyname;
	@FindBy(xpath = "//*[@id='1_ddrRolesTypes']")
	public static WebElement invitesignersselectrole;
	@FindBy(xpath = "//*[@id='btnInvitesignerSave']")
	public static WebElement invitesignersubmit;
	public static String tempname;
	public static String rulename;

	public Templatespage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuClass(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}

	public Templatespage createtemplate(String temp) throws AWTException, InterruptedException {
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);
	       tempname=temp+ " "+formattedDateTime;
		createtemplatenbtn.click();
		Thread.sleep(2000);
		addrole.click();
		Thread.sleep(2000);
		rolename.sendKeys("QA");
		//	deliverymode.click();
		//emailandmobiledeliverymode.click();
		//adddocument("C:\\Users\\RPLPT\\OneDrive\\Desktop\\RPost\\RSign\\API contract &.pdf");
		adddoc();
		Sendpage.subject(tempname, tempname);
		templatename.sendKeys(tempname);
		templatedescription.sendKeys(tempname);
		disablestatictemplate.click();
		driver.findElement(By.xpath("//*[@id='btnNext']")).click();
		allcontrols();
		saveas.click();
		saveastemplate.click();
		waitForPageLoad();
		Templatespage templatepage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatepage);
		return templatepage;
	}

	public Envelopespage consumetemplate(String temp) throws AWTException, InterruptedException {
		tempnametext = templatenametext.getText();
		topmenu.sendpage();
		addtemplatebtn.click();
		templatesearch.sendKeys(tempname);
		Thread.sleep(2000);
		waitForPageLoad();
		selecttemplateorrule.click();
		templatedonebtn.click();
		Thread.sleep(1000);
		waitForPageLoad();
		addrecipientdetails("prudhvicharanv@hotmail.com", "prudhvi");
		sendtemplate.click();
//		driver.findElement(By.id("step1NextButton")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("btnSend")).click();
		Thread.sleep(5000);
		Envelopespage envelopespage = new Envelopespage(driver, logger);
		PageFactory.initElements(driver, envelopespage);
		return envelopespage;
	}

	public Templatespage createrule(String rule) throws AWTException, InterruptedException {
		createtemplatenbtn.click();
		Thread.sleep(1000);
		addrole.click();
		rolename.sendKeys("QA");
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);
	       rulename=rule+ " "+formattedDateTime;
		//deliverymode.click();
		//emailandmobiledeliverymode.click();
		//adddocument("C:\\Users\\RPLPT\\OneDrive\\Desktop\\RPost\\RSign\\API contract &.pdf");
		adddoc();
		Sendpage.subject(rulename, rulename);
		templatename.sendKeys(rulename);
		templatedescription.sendKeys(rulename);
		disablestatictemplate.click();
		driver.findElement(By.xpath("//*[@id='btnNext']")).click();
		allcontrols();
		saveas.click();
		saveasrule.click();
		Thread.sleep(6000);
		waitForPageLoad();
		Templatespage templatepage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatepage);
		return templatepage;
	}

	public Envelopespage consumerule(String rule) throws Exception {
		topmenu().sendpage();
		addrule.click();
		searchrule.sendKeys(rulename);
		Thread.sleep(2000);
		waitForPageLoad();
		selecttemplateorrule.click();
		ruledonebtn.click();
		Thread.sleep(5000);
		waitForPageLoad();
		//adddocument("C:\\Users\\RPLPT\\OneDrive\\Desktop\\RPost\\RSign\\API contract &.pdf");
		adddoc();
		addrecipientdetails("prudhvicharanv@hotmail.com", "prudhvi");
		Thread.sleep(5000);
		//next();
		driver.findElement(By.xpath("//*[@id='step1NextButton']")).click();
		Thread.sleep(3000);
		sendbutton();
		Envelopespage envelopespage = new Envelopespage(driver, logger);
		PageFactory.initElements(driver, envelopespage);
		return envelopespage;
	}
	public static String statictemplate;
	public Templatespage createstatictemplate(String templatenametable) throws AWTException, InterruptedException {
		createtemplatenbtn.click();
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);
	       statictemplate=templatenametable+ " "+formattedDateTime;
		Thread.sleep(1000);
		addrole.click();
		Thread.sleep(1000);
		rolename.sendKeys("QA");
		Thread.sleep(1000);
		Thread.sleep(1000);
		//deliverymode.click();
		//emailandmobiledeliverymode.click();
		//adddocument("C:\\Users\\RPLPT\\OneDrive\\Desktop\\RPost\\RSign\\API contract &.pdf");
		adddoc();
		Thread.sleep(1000);
		Sendpage.subject(statictemplate, statictemplate);
		Thread.sleep(1000);
		templatename.sendKeys(statictemplate);
		templatedescription.sendKeys(statictemplate);
		enablestatictemplate.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='btnNext']")).click();
		Thread.sleep(7000);
		allcontrols();
		saveas.click();
		saveastemplate.click();
		waitForPageLoad();
		Thread.sleep(10000);
		Templatespage templatepage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatepage);
		return templatepage;
	}

	public Templatespage consumestatictemplate(String templatenametable) throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//*[@class='templateListTBody']/tr/td[@class='templateName']/div[text()='"
				+ statictemplate + "']//parent::div//parent::td//parent::tr/td[8]/a")).click();
		String staticlinktext = copystaticlink.getText();
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(staticlinktext);
		waitForPageLoad();
		ss_ctb_email.sendKeys("prudhvicharanv@hotmail.com");
		//ss_ctb_mobile.sendKeys("7032997552");
		ss_ctb_acceptterms.click();
		ss_ctb_nextbtn.click();
		waitForPageLoad();
		termsandservice.click();
		acceptclicktosigncheckbox.click();
		Thread.sleep(2000);
		acceptclicktosign.click();
		clickonsignature.click();
		clickoninitial.click();
		namecontrol.sendKeys("prudhvi");
		titlecontrol.sendKeys("QA");
		companycontrol.sendKeys("RPOST");
		// emailcontrol.sendKeys("prudhvicharanv@yahoo.com");
		dropdowncontrol.click();
		checkboxcontrol.click();
		radiobuttoncontrol.click();
		datecontrol.click();
		selectDateIncalendar("11/09/2019");
		textcontrol.sendKeys("signing");
		finishbtn.click();
		Thread.sleep(3000);
//		sendconfirmationbtn.click();
//		((JavascriptExecutor) driver).executeScript("window.open()");
//			driver.switchTo().window(tabs.get(1));
//			driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=18&ct=1702203337&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26deeplink%3dowa%252f%253frealm%253dhotmail.com%26RpsCsrfState%3d6a2a7847-ad0f-6eae-3c15-fb950763897d&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
//			yahooemail.sendKeys("prudhvicharanv@hotmail.com");
//			emailnextbtn.click();
//			yahoopassword.sendKeys("Charan@2001");
//			yahoologinbtn.click();
//			openmail.click();
//			confirmemailbtn.click();
		((JavascriptExecutor) driver).executeScript("window.close()");
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='cancel btn'])[4]")).click();
		Templatespage templatepage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatepage);
		return templatepage;
	}

	static int count = 2;
	public static String multistatictemplate;
	public Templatespage createmultistatictemp(String templatenametable) throws Exception {
		createtemplatenbtn.click();
		LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
       multistatictemplate=templatenametable+ " "+formattedDateTime;
		Thread.sleep(1000);
		for (int i = 1; i <= count; i++) {
			addrole.click();
			driver.findElement(By.xpath("(//*[contains(@class,'roleName')])[" + i + "]")).sendKeys("QA" + i);
			//driver.findElement(By.xpath("(//*[contains(@class,'custom dropdown deliveryMode')])[" + i + "]")).click();
			//driver.findElement(By.xpath("(//*[contains(@class,'custom dropdown deliveryMode')]/ul/li[3])[" + i + "]"))
					//.click();
		}
		//adddocument("C:\\Users\\RPLPT\\OneDrive\\Desktop\\RPost\\RSign\\API contract &.pdf");
		waitForPageLoad();
		adddoc();
		waitForPageLoad();
		subject(multistatictemplate, multistatictemplate);
		templatename.sendKeys(multistatictemplate);
		templatedescription.sendKeys(multistatictemplate);
		enablestatictemplate.click();
		driver.findElement(By.xpath("//*[@id='btnNext']")).click();
		waitForPageLoad();
		for (int i = 1; i <= 2; i++) {
			allcontrols(i);
		}
		saveas.click();
		saveastemplate.click();
		waitForPageLoad();
		Templatespage templatepage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatepage);
		return templatepage;
	}

	public Templatespage consumemultisignerstatictemplate(String templatenametable)
			throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//*[@class='templateListTBody']/tr/td[@class='templateName']/div[text()='"
				+ multistatictemplate + "']//parent::div//parent::td//parent::tr/td[8]/a")).click();
		String multistaticlinktext = copystaticlink.getText();
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(multistaticlinktext);
		waitForPageLoad();
		Select select = new Select(selectrole);
		select.selectByIndex(1);
		ss_ctb_email.sendKeys("prudhvicharanv@hotmail.com");
		//ss_ctb_mobile.sendKeys("7032997552");
		ss_ctb_acceptterms.click();
		ss_ctb_nextbtn.click();
		waitForPageLoad();
		termsandservice.click();
		invitesigner.click();
		Thread.sleep(1500);
		Select sel = new Select(invitesignersselectrole);
		sel.selectByIndex(1);
		invitesignername.sendKeys("prudhvi");
		invitesigneremail.sendKeys("vulliprudhvicharan@yahoo.com");
		//invitesignermobile.sendKeys("6300431674");
		invitesignermydetails.click();
		invitesignermyname.sendKeys("charan");
		invitesignersubmit.click();
		for (int i = 1; i <= count; i++) {
			signersignature(i);
			signerinitial(i);
			signername(i);
			signertitle(i);
			signercompany(i);
			signercheckbox(i);
			signerradiobutton(i);
			signerdate(i);
			signertext(i);
		}
		finishbtn.click();
		Thread.sleep(2000);
//		sendconfirmationbtn.click();
//		((JavascriptExecutor) driver).executeScript("window.open()");
//		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tab.get(2));
//			driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=18&ct=1702203337&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fcobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26nlp%3d1%26deeplink%3dowa%252f%253frealm%253dhotmail.com%26RpsCsrfState%3d6a2a7847-ad0f-6eae-3c15-fb950763897d&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
//			yahooemail.sendKeys("prudhvicharanv@hotmail.com");
//			emailnextbtn.click();
//			yahoopassword.sendKeys("Charan@2001");
//			yahoologinbtn.click();
//			staysignedin.click();
//			driver.navigate().refresh();
//			openmail.click();
//			confirmemailbtn.click();
//			((JavascriptExecutor) driver).executeScript("window.close()");
//			driver.switchTo().window(tab.get(1));
		((JavascriptExecutor) driver).executeScript("window.close()");
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='cancel btn'])[4]")).click();
		Templatespage templatepage = new Templatespage(driver, logger);
		PageFactory.initElements(driver, templatepage);
		return templatepage;
	}


	public TopMenuClass topmenu() {
		return topmenu;
	}
}
