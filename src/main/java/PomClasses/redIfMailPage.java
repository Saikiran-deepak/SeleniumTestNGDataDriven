package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;

public class redIfMailPage extends PageBaseClass1{
	public TopMenuBase topmenu;  // to make TopMenuBase available for all classes
	
	public redIfMailPage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
		TopMenuBase topmenu = new TopMenuBase(driver,logger);
		PageFactory.initElements(driver, topmenu);
	}
	public void clickWriteEmail() {
		// TODO Auto-generated method stub

	}
	
	public void typeMail() {
		// TODO Auto-generated method stub

	}
	public void getTitle() {
		// TODO Auto-generated method stub

	}
}
