package day7_handson;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot_ThirdImage {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/charts.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  // - for third image of chart(Radar Chart,Bubble Chart and 
	  //Scatter Chart)

	 
	  Thread.sleep(2000);
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("scroll(0,1200)");
	  File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File desc=new File(".\\screenshot\\third_image.png");//for report generation we need to keep in same project folder
	  FileHandler.copy(f1,desc);
	  
	Thread.sleep(2000);
	 driver.quit();
	  
  }
}
