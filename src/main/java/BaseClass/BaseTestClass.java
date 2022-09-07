package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PomClasses.LandingPage;
import utilities.ExtentReport;

public class BaseTestClass {
	public WebDriver driver;
	public ExtentReports report = ExtentReport.getReportInstance();
	public ExtentTest logger;

	public void inokeBrowser(String browser) {

		try {
//			if (browser.equalsIgnoreCase("firefox")) {
//
//				System.setProperty("webdriver.gecko.driver",
//						System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\geckodriver.exe");
//				driver = new FirefoxDriver();
//
//			} else 
			if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"E:\\JAVA Files Dont delete\\Drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod()
	public void flushReports() {
		report.flush();
		driver.close();
	}
//	@AfterMethod
//	public void CloseBrowser() {
//		driver.quit();
//	}
}
