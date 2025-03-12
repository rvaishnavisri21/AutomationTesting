package day5_handson;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NestedFrames {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/frame.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 /* - Click Me (Inside Nested frame)
- How many frames in this page?
*/
	  driver.switchTo().frame(2);
	  driver.switchTo().frame("frame2");
	  
WebElement e=driver.findElement(By.xpath("//button[contains(@style,'4b7ecf')]"));
e.click();
Thread.sleep(3000);
driver.switchTo().defaultContent();
List<WebElement> l=driver.findElements(By.tagName("iframe"));
System.out.println("No of frames: "+l.size());
	  for(int i=0;i<l.size();i++) {
		  driver.switchTo().frame(i);
		  List<WebElement> l1=driver.findElements(By.tagName("iframe"));
		  System.out.println("No of inner frames for frame "+(i+1)+":"+l1.size());
		  driver.switchTo().defaultContent();
	  }
	  Thread.sleep(3000);
	  driver.quit();
	  
  }
}
