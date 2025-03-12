package com.amazonapplication.testCases;

import org.testng.annotations.Test;

import com.amazonapplication.pageObjects.HomePage;
import com.amazonapplication.pageObjects.LaptopPage;
import com.aventstack.extentreports.Status;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ReadCustomerReviewTest extends BaseExtentTest{
	
	
  @Test
  public void WritetoFile(Method method) throws IOException, InterruptedException {
	  test=extent.createTest("Testcase 4-Read Customer Review Test",method.getName());
	  System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
	  final Logger logger=LogManager.getLogger(ReadCustomerReviewTest.class);
	  logger.info("Write Review and embed to file");
	  JavascriptExecutor js=(JavascriptExecutor)DriverClass.getdriver();
	  
	  Thread.sleep(2000);
	File fs=new File("C:\\Users\\rvaishnavi.sri\\eclipse-workspace\\AmazonApplication3\\data.txt");
	//fs.createNewFile();
	FileWriter fw=new FileWriter(fs);
	BufferedWriter bw=new BufferedWriter(fw);
	
	for(WebElement e:LaptopPage.CustomerReviews)
	{
	js.executeScript("arguments[0].scrollIntoView(true);",e);
	Thread.sleep(10000);
	bw.write(e.getText());
	bw.newLine();
	}

	bw.close();
	 test.log(Status.PASS,"Testcase Passed "+"Review Embedded into File Successfully");
			  
}
  @AfterTest
  public void afterTest() throws IOException {
  DriverClass.getdriver().quit();
  }
  }
