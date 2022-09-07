package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import PomClasses.LogOutPage;

public class TopMenuBase extends PageBaseClass1 {
// Which is common for most of the classes

	public TopMenuBase(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//a[@href=\"/portfolio\"]")
	public WebElement myPortfolioLink;

	@FindBy(xpath = "//a[@href=\"//portfolio.rediff.com/portfolio-logout\"]")
	public WebElement signoutLink;

	public LogOutPage singOutApplication() {
		signoutLink.click();
		LogOutPage logoutpage = new PomClasses.LogOutPage(driver, logger);
		PageFactory.initElements(driver, logoutpage);
		return logoutpage;

	}

}
