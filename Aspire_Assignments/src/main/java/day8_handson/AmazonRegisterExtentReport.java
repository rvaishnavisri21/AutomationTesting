package day8_handson;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.TakesScreenshot;

public class AmazonRegisterExtentReport {
	WebDriver driver;
	public static ExtentSparkReporter exspre;
	public static ExtentReports reporter;
	public static ExtentTest test;
	
	@BeforeTest
	  public void beforeTest() {
		exspre=new ExtentSparkReporter(".\\target\\ExtentReport\\extent.html");
		reporter=new ExtentReports();
		reporter.attachReporter(exspre);
	}
  @Test
  public void f() throws InterruptedException, IOException, AWTException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.amazon.com/ap/register?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=T0VWC0XNY27TRZ76BJPS&openid.assoc_handle=usflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&webAuthnChallengeIdForAutofill=QOBWuq6L7ix6Uh3pUCMyCBX1M69O3eCo%3ANA&webAuthnGetParametersForAutofill=eyJycElkIjoiYW1hem9uLmNvbSIsImNoYWxsZW5nZSI6IlFPQld1cTZMN2l4NlVoM3BVQ015Q0JYMU02OU8zZUNvIiwidGltZW91dCI6MzI0NDQxLCJhbGxvd0NyZWRlbnRpYWxzIjpudWxsLCJtZWRpYXRpb24iOiJjb25kaXRpb25hbCIsInVzZXJWZXJpZmljYXRpb24iOiJwcmVmZXJyZWQifQ%3D%3D&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  // To implement extent report for amazon registration  	 
	  Thread.sleep(2000);
	  test=reporter.createTest("Testcase1","AmazonRegister");
	  Thread.sleep(3000);
	  test.log(Status.INFO,"Passing my Name "+"Vaishnavi");
	  driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("Vaishnavi");
	  Thread.sleep(1000);
	  test.log(Status.INFO,"Passing my Email "+"testingnewabc@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("testingnewabc@gmail.com");
	  Thread.sleep(1000);
	  test.log(Status.INFO,"Passing my Password ");
	  driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Happy21work!");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys("Happy21work!");
	  Thread.sleep(1000);
	  test.log(Status.INFO,"Clicking on Continue");
	  
	  driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	  Thread.sleep(2000);
	  test.log(Status.PASS,"Testcase Passed "+"Entered successfully");
	
	
	 driver.quit();
	  
  }
  @AfterTest
  public void afterTest() {
	  reporter.flush();
}
}
