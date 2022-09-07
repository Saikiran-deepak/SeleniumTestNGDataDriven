package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;


public class LogOutPage extends PageBaseClass1{
	public TopMenuBase topmenu; 	 // to make TopMenuBase available for all classes

	public LogOutPage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
		 topmenu = new TopMenuBase(driver, logger);
		PageFactory.initElements(driver,topmenu);
	}

	@FindBy(xpath = "//a[@href=\"/portfolio-login\"]")
	public WebElement loginAgainLink;

	public LoginPage clickLoginAgain() {
		//logger.log(Status.INFO, "Clicking the Login-Again Link");
		loginAgainLink.click();
		LoginPage login = new LoginPage(driver,logger);
		PageFactory.initElements(driver, login);
		return login;
	}

}
