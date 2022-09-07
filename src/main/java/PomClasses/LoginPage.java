package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseClass.BaseTestClass;
import BaseClass.PageBaseClass1;
import BaseClass.TopMenuBase;

public class LoginPage extends PageBaseClass1{

	public TopMenuBase topmenu;  // to make TopMenuBase available for all classes
	public LoginPage(WebDriver driver, ExtentTest logger) {
		super(driver,logger);
		topmenu= new TopMenuBase(driver,logger);
		PageFactory.initElements(driver,topmenu);
		
	}
	public redIfMailPage doLogin() {
		// TODO Auto-generated method stub
		redIfMailPage redif= new redIfMailPage(driver,logger);
		PageFactory.initElements(driver, redif);  // we are returning to avoid nullpointer exception
		return redif;
	}
	public void getTitle() {
		// TODO Auto-generated method stub

	}
	
}
