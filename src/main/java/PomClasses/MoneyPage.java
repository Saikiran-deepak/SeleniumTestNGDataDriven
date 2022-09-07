package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;

public class MoneyPage extends PageBaseClass1 {
	public TopMenuBase topmenu;  // to make TopMenuBase available for all classes
	public MoneyPage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
		topmenu=new TopMenuBase(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}
	
	
	@FindBy(xpath="//a[@title=\"Already a user? Sign in\"]")
	public WebElement signin;
	public PortFolioLoginPage signIn() {
		signin.click();
		PortFolioLoginPage portfolio= new PortFolioLoginPage(driver,logger);
		
		PageFactory.initElements(driver, portfolio);
		return portfolio;
		
	}
	
}
