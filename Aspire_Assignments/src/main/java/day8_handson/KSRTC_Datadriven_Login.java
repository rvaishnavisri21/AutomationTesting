package day8_handson;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

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

public class KSRTC_Datadriven_Login {
	WebDriver driver;
	
	
	
  @Test
  public void f() throws InterruptedException, IOException, AWTException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://ksrtc.in/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  // KSRTC invalid registration  scenario for 5 sets of users 
	  //(keep the data in excel sheet and perform data driven testing using poi) 	 
	  FileInputStream fs=new FileInputStream(".\\Datadriven.xlsx");
	  XSSFWorkbook wb=new XSSFWorkbook(fs);
	  XSSFSheet xsh=wb.getSheetAt(0);
	  int lastrow=xsh.getLastRowNum();
	  System.out.println(lastrow);
	  for(int i=1;i<=lastrow;i++){
		  XSSFRow row=xsh.getRow(i);
		  /*String email=row.getCell(0).getStringCellValue();
		  String mobile=row.getCell(1).getNumericCellValue();
		  String password=row.getCell(2).getStringCellValue();*/
		  DataFormatter formatter = new DataFormatter();
		  String email=formatter.formatCellValue(row.getCell(0));
		  String mobile=formatter.formatCellValue(row.getCell(1));
		  String password=formatter.formatCellValue(row.getCell(2));
		  driver.findElement(By.xpath("//label[contains(text(),'Email ID')]/preceding-sibling::input")).sendKeys(email);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//label[contains(text(),'Mobile Number')]/preceding-sibling::input")).sendKeys(mobile);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//label[contains(text(),'Password')]/preceding-sibling::input")).sendKeys(password);
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[contains(@class,'checkbox')]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[@class=\"btn payee\"]")).click();
		  Thread.sleep(3000);
		 // driver.switchTo().alert().accept();
		  driver.findElement(By.xpath("//*[@id=\"okayButton\"]")).click();
		  Thread.sleep(3000);  
		  driver.navigate().refresh();
		  Thread.sleep(3000); 
		  }
	 driver.quit();
	  
  }
  
}
