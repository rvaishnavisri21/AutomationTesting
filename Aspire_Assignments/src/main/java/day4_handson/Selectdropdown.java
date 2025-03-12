package day4_handson;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selectdropdown {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/select.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  // - Which is your favorite UI Automation tool?
	  //--- select dropdown implementation for selectByVisibleTest(),selectByindex() and SelectByValue()
	  Select s=new Select(driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")));
	  //selecting selenium
	  s.selectByVisibleText("Selenium");
	  Thread.sleep(2000);
	  //selecting playwright
	  s.selectByIndex(2);
	  Thread.sleep(2000);
	  //Value is not present for this select class so SelectByValue() cannot be done
	  driver.quit();
	  
  }
}
