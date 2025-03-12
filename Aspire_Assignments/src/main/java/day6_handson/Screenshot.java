package day6_handson;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/charts.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  // - take the screen print
	 
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File des=new File(".\\screenshot\\charts.png");
	 try {
	 FileHandler.copy(src,des);
	 }
	 catch (IOException e) {
		 System.out.println("exception occurred");
	    }
	Thread.sleep(2000);
	 driver.quit();
	  
  }
}
