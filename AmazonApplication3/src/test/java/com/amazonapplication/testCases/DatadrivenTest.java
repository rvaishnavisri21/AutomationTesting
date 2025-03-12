package com.amazonapplication.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazonapplication.pageObjects.HomePage;
import com.amazonapplication.pageObjects.RegisterPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.TakesScreenshot;

public class DatadrivenTest extends BaseExtentTest {
	WebDriver driver;
	
	
	
  @Test
  public void datadriven(Method method) throws InterruptedException, IOException, AWTException {
	  test=extent.createTest("Testcase 5-Data Driven Test",method.getName());
	  System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
	  final Logger logger=LogManager.getLogger(DatadrivenTest.class);
	  logger.info("Amazon Registeration tried for 5 invalid users");
	  
	  if(DriverClass.browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",".\\Drivers\\msedgedriver.exe");
			  driver=new EdgeDriver();
	  }
	  else {
		  
	  
	  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	  
		 driver=new ChromeDriver();
	  }
	  
	  
		  FileInputStream fs=new FileInputStream(".\\Config.properties");
		  Properties pro=new Properties();
		  pro.load(fs);
		  driver.get(pro.getProperty("RegisterURL"));
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  PageFactory.initElements(driver,RegisterPage.class);
	  
	  // Amazon invalid registration  scenario for 5 sets of users 
	  //(keep the data in excel sheet and perform data driven testing using poi) 	 
	  FileInputStream f=new FileInputStream(".\\Datadriven.xlsx");
	  XSSFWorkbook wb=new XSSFWorkbook(f);
	  XSSFSheet xsh=wb.getSheetAt(0);
	  int lastrow=xsh.getLastRowNum();
	  System.out.println("No of rows with data: "+lastrow);
	  for(int i=1;i<=lastrow;i++){
		  XSSFRow row=xsh.getRow(i);
		  /*String email=row.getCell(0).getStringCellValue();
		  String mobile=row.getCell(1).getNumericCellValue();
		  String password=row.getCell(2).getStringCellValue();*/
		  DataFormatter formatter = new DataFormatter();
		  String name=formatter.formatCellValue(row.getCell(0));
		  String emailid=formatter.formatCellValue(row.getCell(1));
		  String password=formatter.formatCellValue(row.getCell(2));
		  RegisterPage.Name.clear();
		  RegisterPage.Name.sendKeys(name);
		  Thread.sleep(1000);
		  RegisterPage.RegisterEmail.clear();
		  RegisterPage.RegisterEmail.sendKeys(emailid); 
		  Thread.sleep(1000);
		 RegisterPage.RegisterPassword.sendKeys(password);
		  Thread.sleep(1000);
		  RegisterPage.ReenterPassword.sendKeys(password);
		  Thread.sleep(1000);
		  RegisterPage.ContinueButton.click();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000); 
		  }
	  test.log(Status.PASS,"Testcase Passed "+"Data driven testing done");
	 driver.quit();
	  
  }
  
}
