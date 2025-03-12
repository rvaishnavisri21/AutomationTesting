package day8_handson;

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

public class JavascriptExecutorTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/input.xhtml;jsessionid=node01xiupbs5d9n7wasvo4r0d2gci7736835.node0");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  // - Type your DOB (mm/dd/yyyy) and confirm date chosen

	 
	  Thread.sleep(2000);
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("document.getElementById('j_idt106:j_idt116_input').value='09/21/1996'");
	  Thread.sleep(3000);
	  //- enter text in two text boxes
	  driver.navigate().to("https://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");  
	  Thread.sleep(2000);
	  WebElement e=driver.findElement(By.xpath("//*[@id='mCSB_3_container']/p[2]/input"));
	  js.executeScript("arguments[0].scrollIntoView(true);",e);
	  Thread.sleep(1000);
	  e.clear();
	  Thread.sleep(2000);
	  e.sendKeys("testing1");
	  Thread.sleep(2000);
	  WebElement e1=driver.findElement(By.xpath("//*[@id='mCSB_3_container']/p[6]/input"));
	  js.executeScript("arguments[0].scrollIntoView(true);",e1);
	  Thread.sleep(1000);
	  e1.clear();
	  Thread.sleep(2000);
	  e1.sendKeys("testing2");
	  Thread.sleep(3000);
	 driver.quit();
	  
  }
}
