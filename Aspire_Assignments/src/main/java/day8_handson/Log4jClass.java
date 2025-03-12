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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

public class Log4jClass {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException, AWTException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
	  final Logger logger=LogManager.getLogger(Log4jClass.class);
	  
	  driver.get("https://leafground.com/dashboard.xhtml;jsessionid=node0vvkqhnhws6mj1dosovjjke8fd8811352.node0");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  // Try to implement log4j for Email Address and message validation for the leafground application 
	  logger.info("Leafground dashboard title: "+driver.getTitle());
	  Thread.sleep(2000);
	  logger.info("Passing email");
	  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testingnewabc@gmail.com");
	  Thread.sleep(1000);
	  logger.info("Passing message");
	  driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("text message");
	  Thread.sleep(1000);
	  logger.info("Clicking Send");
	  driver.findElement(By.xpath("//*[@id=\"j_idt130\"]")).click();
	  Thread.sleep(1000);
	  logger.debug("Email and Message Sent");
	  Thread.sleep(3000);
	 driver.quit();
	  
  }
}
