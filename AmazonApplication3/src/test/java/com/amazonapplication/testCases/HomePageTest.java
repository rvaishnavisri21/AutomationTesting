package com.amazonapplication.testCases;

import org.testng.annotations.Test;


import com.amazonapplication.pageObjects.HomePage;
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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HomePageTest extends BaseExtentTest {
	
	
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
	
	
	/*public static ExtentSparkReporter exspre;
	public static ExtentReports reporter;
	public static ExtentTest test;
	@BeforeTest
	  public void beforeTest() {
		exspre=new ExtentSparkReporter(".\\target\\ExtentReport\\extent.html");
		reporter=new ExtentReports();
		reporter.attachReporter(exspre);
	}*/
	
  @Test
  public void displayMenuAndCaptureScreenshot(Method method) throws InterruptedException, WebDriverException, IOException {
	 // BaseExtentClass.test=BaseExtentClass.reporter.createTest("Testcase2a","Home Page Test");
	  test=extent.createTest("Testcase 2a-Home Page Test",method.getName());
	  System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
	  final Logger logger=LogManager.getLogger(HomePageTest.class);
	  logger.info("Display Menu and Capture Screenshot");
	  PageFactory.initElements(DriverClass.getdriver(),HomePage.class);
	  Thread.sleep(10000);
	  Actions a=new Actions(DriverClass.getdriver());
	  a.click(HomePage.Mobiles).build().perform();
	  //Thread.sleep(1000);
	  
	//Thread.sleep(25000);
	try {
	 WebDriverWait wait = new WebDriverWait(DriverClass.getdriver(), Duration.ofSeconds(7));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span/h2[contains(text(),'Mobiles & Accessories')]/../../following-sibling::li/span/a/span)[1]")));
	  }
	  catch(Exception e) {
		  System.out.println(e.getStackTrace());
	  }
	(DriverClass.getdriver()).navigate().to("about:blank");
	 Thread.sleep(1000);
	  (DriverClass.getdriver()).navigate().back();
	  Thread.sleep(1000);
	  
	/* JavascriptExecutor js = (JavascriptExecutor)((DriverClass.getdriver()));
	  js.executeScript("window.stop();");
	  Thread.sleep(1000);*/
	  System.out.println("List of Category Items: ");
	  for(WebElement e:HomePage.CategoryItems) {
		  System.out.println(e.getText());
	  }
	  System.out.println("Count of Category Items: "+HomePage.CategoryItems.size());
	  System.out.println("List of Mobile and Accessories Items: ");
	  for(WebElement e1:HomePage.MobileAccessoriesItems) {
		  System.out.println(e1.getText());
	  }
	  System.out.println("Count of Mobile and Accessories Items: "+HomePage.MobileAccessoriesItems.size());
	  
  
  File src=((TakesScreenshot)DriverClass.getdriver()).getScreenshotAs(OutputType.FILE);
	 File des=new File(".\\Screenshots\\AmazonMobilesPage.png");
	 try {
	 FileHandler.copy(src,des);
	 }
	 catch (IOException e) {
		 System.out.println("exception occurred");
	    }
	Thread.sleep(2000);
	System.out.println("Screenshot is captured successfully");
	 test.log(Status.PASS,"Testcase Passed "+"Display Menu and Capture Screenshot done");
}
  @Test
  public void selectShopByDell(Method method) throws InterruptedException, IOException {
	  //BaseExtentClass.test=BaseExtentClass.reporter.createTest("Testcase2b","Home Page Test");
	  test=extent.createTest("Testcase 2b-Home Page Test",method.getName());
	  System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
	  final Logger logger=LogManager.getLogger(HomePageTest.class);
	  logger.info("Select Shop by Dell");
	  PageFactory.initElements(DriverClass.getdriver(),HomePage.class);
	  Actions a=new Actions(DriverClass.getdriver());
	  a.moveToElement(HomePage.LaptopsAccessoriesLink).build().perform();
	  Thread.sleep(1000);
	  a.click(HomePage.DellLink).build().perform();
	  Thread.sleep(3000);
	 test.log(Status.PASS,"Testcase Passed "+"Select Shop by Dell done");
  }
 
  }
