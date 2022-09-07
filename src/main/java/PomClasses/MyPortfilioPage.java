package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;

public class MyPortfilioPage extends PageBaseClass1 {
	public TopMenuBase topmenu; // to make TopMenuBase available for all classes

	public MyPortfilioPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		topmenu = new TopMenuBase(driver, logger);
		PageFactory.initElements(driver, topmenu);
	}

	public TopMenuBase getTopmenu() {
		return topmenu; // it is optional we can directly use it explanation in part5 it is good
						// practice
	}
}
