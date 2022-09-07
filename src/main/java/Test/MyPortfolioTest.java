package Test;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;
import PomClasses.LandingPage;
import PomClasses.MoneyPage;
import PomClasses.MyPortfilioPage;
import PomClasses.PortFolioLoginPage;
import utilities.TestDataProvider;

public class MyPortfolioTest extends BaseTestClass {


	LandingPage landing ;
	MoneyPage money;
	PortFolioLoginPage portfoliologin;
	MyPortfilioPage myportfolio;
	TopMenuBase topmenu;

	@Test(dataProvider="getOpenPortfolioTestData")
	public void openApplication(Hashtable<String, String> testData) {	
		logger = report.createTest("Create Porfolio Test : " + testData.get("Comment"));
		inokeBrowser("chrome");
		PageBaseClass1 baseclass = new PageBaseClass1(driver, logger);
		PageFactory.initElements(driver, baseclass);
		landing=baseclass.openApplication();
		money = landing.clickMoneyLink();
		portfoliologin = money.signIn();
		myportfolio = portfoliologin.doLogin(testData.get("UserName"), testData.get("Password"));


	}
	@Test(dataProvider="getOpenPortfolioTestDataValid")
	public void openApplicationSignIn(Hashtable<String, String> testData) {	
		logger = report.createTest("Create Porfolio Test : " + testData.get("Comment"));
		inokeBrowser(testData.get("browser"));
		PageBaseClass1 baseclass = new PageBaseClass1(driver, logger);
		PageFactory.initElements(driver, baseclass);
		landing=baseclass.openApplication();
		money = landing.clickMoneyLink();
		portfoliologin = money.signIn();
		myportfolio = portfoliologin.doLogin(testData.get("UserName"), testData.get("Password"));
		topmenu = myportfolio.getTopmenu();		
		topmenu.singOutApplication();
		
	}
	
	@DataProvider
	public Object[][] getOpenPortfolioTestData(){
		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffLoginTest", "openPorfolio");
	}
	@DataProvider
	public Object[][] getOpenPortfolioTestDataValid(){
		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffLoginTest", "Valid");
	}
//	@DataProvider
//	public Object[][] getOpenPortfolioTestDataValid(){
//		return TestDataProvider.getTestData("RediffPortFolioLaunch.xlsx", "RediffLoginTest", "Type");
//	}

}
