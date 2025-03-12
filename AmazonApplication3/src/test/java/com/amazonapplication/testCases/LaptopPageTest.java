package com.amazonapplication.testCases;

import org.testng.annotations.Test;

import com.amazonapplication.pageObjects.HomePage;
import com.amazonapplication.pageObjects.LaptopPage;
import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.FileInputStream;
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
import org.testng.annotations.BeforeTest;

public class LaptopPageTest extends BaseExtentTest {
	
	
  @Test
  public void displayLaptops(Method method) throws InterruptedException, IOException {
	  //WebDriver driver=HomePageTest.driver;
	  test=extent.createTest("Testcase 3-Laptop Page Test",method.getName());
	  System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
	  final Logger logger=LogManager.getLogger(LaptopPageTest.class);
	  logger.info("Display Laptops");
	  PageFactory.initElements(DriverClass.getdriver(),LaptopPage.class);
	  Thread.sleep(3000);
	  LaptopPage.SearchBox.sendKeys("Gaming Laptop");
	  LaptopPage.SearchBox.sendKeys(Keys.ENTER);
	  Thread.sleep(3000);
	  JavascriptExecutor js=(JavascriptExecutor)DriverClass.getdriver();
	  js.executeScript("arguments[0].scrollIntoView(true);",LaptopPage.LaptopTitleFirst);
	  Thread.sleep(2000);
	  String Expected=js.executeScript("return arguments[0].innerText;",LaptopPage.LaptopTitleFirst).toString();
	  Thread.sleep(2000);
	  js.executeScript("arguments[0].scrollIntoView(true);",LaptopPage.FirstGamingLaptop);
	  Thread.sleep(3000);
	  
	  LaptopPage.FirstGamingLaptop.click();
	  Thread.sleep(3000);
	  Set<String> w=DriverClass.getdriver().getWindowHandles();
			  Iterator<String> i=w.iterator();
			  String AllLaptopPage=i.next();
			  String FirstLaptopPage=i.next();
			  System.out.println("Title of All Laptop Page: "+DriverClass.getdriver().getTitle());
			  DriverClass.getdriver().switchTo().window(FirstLaptopPage);
			  Thread.sleep(3000);
			  System.out.println("Title of First Laptop Page: "+DriverClass.getdriver().getTitle());
			  String Actual=js.executeScript("return arguments[0].innerText;",LaptopPage.LaptopTitleNext).toString().trim();
			  Assert.assertEquals(Actual,Expected);
		//	  Assert.assertEquals(DriverClass.getdriver().getTitle(),"Dell {Smartchoice} G15-5530 Core i5-13450HX| NVIDIA RTX 3050, 6GB (16GB RAM|1TB SSD, FHD|Window 11|MS Office' 21|15.6\" (39.62cm)|Dark Shadow Grey|2.65Kg|Gaming Laptop : Amazon.in: Electronics");
			  System.out.println("Validation passed- navigating to next page");
			  js.executeScript("arguments[0].scrollIntoView(true);",LaptopPage.Quantity);
			  Thread.sleep(3000);
			  String quantity=LaptopPage.Quantity.getText();
			  Assert.assertTrue(Integer.parseInt(quantity) >= 1);
			  System.out.println("Validation passed-product Qty greater than or equal to 1");
			  test.log(Status.PASS,"Testcase Passed "+"Laptop Validation Passed");
			  
}
  
  }
