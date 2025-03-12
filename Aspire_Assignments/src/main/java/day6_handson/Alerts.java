package day6_handson;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Alerts {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://demo.automationtesting.in/Alerts.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  // - Alerts - 3 Popup to be handled
	 
	  Thread.sleep(2000);
	  WebElement w=driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button"));
	 w.click();
	 Thread.sleep(2000);
	 System.out.println(driver.switchTo().alert().getText());
	 driver.switchTo().alert().accept();
	 Thread.sleep(2000);
	 WebElement w1=driver.findElement(By.linkText("Alert with OK & Cancel"));
	 w1.click();
	 Thread.sleep(2000);
	 WebElement w2=driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button"));
	 w2.click();
	 Thread.sleep(2000);
	 System.out.println(driver.switchTo().alert().getText());
	 driver.switchTo().alert().accept();
	 Thread.sleep(2000);
	 w2.click();
	 Thread.sleep(2000);
	 driver.switchTo().alert().dismiss();
	 Thread.sleep(2000);
	  WebElement w3=driver.findElement(By.linkText("Alert with Textbox"));
	  w3.click();
	  Thread.sleep(2000);
	  WebElement w4=driver.findElement(By.xpath("//*[@id='Textbox']/button"));
	  w4.click();
	  Thread.sleep(2000);
	  System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().sendKeys("Vaishnavi");
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  
	  
	Thread.sleep(2000);
	 driver.quit();
	  
  }
}
