package BaseClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PomClasses.LandingPage;
import utilities.DateUtils;

public class PageBaseClass1 extends BaseTestClass {
	public ExtentTest logger;

	public PageBaseClass1(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.driver = driver;
	}

	public LandingPage openApplication() {

		driver.get("https://www.rediff.com/");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;

	}

	public void verifyPageTitle(String pageTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), pageTitle);
			reportPass("actual " + driver.getTitle() + " equals to expected" + pageTitle);

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "\\Screenshot" + DateUtils.getTimeStamp() + ".png");
		// We use above line to convert binary format to file format
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\Screenshot" + DateUtils.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
