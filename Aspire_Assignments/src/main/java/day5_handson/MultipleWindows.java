package day5_handson;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultipleWindows {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/window.xhtml;jsessionid=node0jz54y4bb417j153z2crbuubp27747005.node0");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  // a)Click and Confirm new Window Opens

	  //b)Find the number of opened tabs


	  WebElement e=driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]/span"));
	  e.click();
	  Set<String> w=driver.getWindowHandles();
	 
			  Iterator<String> i=w.iterator();
			  String parent=i.next();
			  String child=i.next();
			  driver.switchTo().window(child);
			  System.out.println("New window opened: "+driver.getTitle());
			  System.out.println("Number of opened tabs:"+w.size());
			  Thread.sleep(2000);
			  driver.switchTo().window(parent);
			  System.out.println("Parent window: "+driver.getTitle());
			  
	  Thread.sleep(2000);
	  driver.quit();
	  
  }
}
