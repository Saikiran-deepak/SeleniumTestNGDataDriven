package PomClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;

public class PortFolioLoginPage extends PageBaseClass1{
	public TopMenuBase topmenu;  // to make TopMenuBase available for all classes
	 public PortFolioLoginPage(WebDriver driver, ExtentTest logger) {
			super(driver,logger);
			TopMenuBase topmenu=new TopMenuBase(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	@FindBy(xpath="//input[@id=\"useremail\"]")
	public WebElement mailid;
	
	@FindBy(xpath="//input[@id=\"userpass\"]")
	public WebElement password;
	@FindBy(xpath="//input[@id=\"loginsubmit\"]")
	public WebElement signup;
	
	public MyPortfilioPage doLogin(String Username, String pass) {
		mailid.sendKeys(Username);
		password.sendKeys(pass);
		signup.click();
		MyPortfilioPage portfolio=new MyPortfilioPage(driver,logger);
		PageFactory.initElements(driver, portfolio);
		return portfolio;
	}
//	public afterLoginPage doLogin(String Username, String pass) {
//		mailid.sendKeys(Username);
//		password.sendKeys(pass);
//		signup.click();
//		return PageFactory.initElements(driver, afterLoginPage.class);
//	}

	
}
