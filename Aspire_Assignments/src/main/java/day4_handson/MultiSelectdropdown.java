package day4_handson;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiSelectdropdown {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://demoqa.com/select-menu");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  //-Standard multi select
	  //----implement IsMultiple(),DeSelectAll(),DeSelectByVisibleText(),DeselectByValue() and DeselectByIndex()
	  Select s=new Select(driver.findElement(By.xpath("//select[@id='cars']")));	
	  System.out.println("Is multiple:"+s.isMultiple());
	  s.selectByValue("volvo");
	  s.selectByValue("saab");
	  Thread.sleep(2000);
	  s.deselectAll();
	  Thread.sleep(2000);
	  s.selectByValue("opel");
	  s.selectByVisibleText("Audi");
	  s.selectByIndex(0);
	  Thread.sleep(2000);
	  s.deselectByValue("opel");
	  s.deselectByVisibleText("Audi");
	  s.deselectByIndex(0);
	  Thread.sleep(2000);
	  
	  driver.quit();
	  
  }
}
