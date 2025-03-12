package com.amazonapplication.testCases;

import org.testng.annotations.Test;

import com.amazonapplication.pageObjects.HomePage;
import com.amazonapplication.pageObjects.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class LoginPageTest extends BaseExtentTest {
	
	
	/*@BeforeTest
	  public void beforeTest() throws IOException {
		String sysdir=System.getProperty("user.dir");
		  System.out.println("current directory:"+sysdir);
		  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  FileInputStream fs=new FileInputStream(".\\Config.properties");
		  Properties pro=new Properties();
		  pro.load(fs);
		  
		  driver.get(pro.getProperty("URL"));
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  }*/
	
	
	
  @Test
  public void login(Method method) throws InterruptedException, WebDriverException, IOException {
	 //BaseExtentClass.test=BaseExtentClass.getreport().createTest("Testcase1","Login Page Test");
	  test=extent.createTest("Testcase 1-Login Page Test",method.getName());
	  PageFactory.initElements(DriverClass.getdriver(),LoginPage.class);
	  System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
	  final Logger logger=LogManager.getLogger(LoginPageTest.class);
	  logger.info("User Login to Amazon");
	  FileInputStream fs=new FileInputStream(".\\Config.properties");
	  Properties pro=new Properties();
	  pro.load(fs);
	  LoginPage.SigninLink.click();
	  LoginPage.EmailId.sendKeys(pro.getProperty("EmailId"));
	  LoginPage.ContinueButton.click();
	  LoginPage.Password.sendKeys(pro.getProperty("Password"));
	  LoginPage.SigninButton.click();
	 test.log(Status.PASS,"Testcase Passed "+"Logged In successfully");

}
 

  }
