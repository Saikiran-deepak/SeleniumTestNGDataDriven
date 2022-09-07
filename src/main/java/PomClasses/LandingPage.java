package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;

public class LandingPage extends PageBaseClass1 {
	public ExtentTest logger;

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
	}

	@FindBy(xpath = "//a[@class=\"moneyicon relative\"]")
	public WebElement moneylink;

	public MoneyPage clickMoneyLink() {
	//	logger.log(Status.INFO, "Clicking the money link");
		moneylink.click();
		MoneyPage moneypage = new MoneyPage(driver,logger);
		PageFactory.initElements(driver, moneypage);
		return moneypage;
	}

	public LoginPage clickSignIn() {
		// TODO Auto-generated method stub
		LoginPage login= new LoginPage(driver,logger);
		
		PageFactory.initElements(driver, login);
		return login;
	}

}
