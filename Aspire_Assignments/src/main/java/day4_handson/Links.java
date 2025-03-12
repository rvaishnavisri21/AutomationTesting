package day4_handson;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Links {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/link.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  //--Count Layout Links
	  //--Count Links

	  List<WebElement> l=driver.findElements(By.tagName("a"));
	  System.out.println("Total no of Links:"+l.size());
	  List<WebElement> l1=driver.findElements(By.xpath("//a[starts-with(@href,'/')]"));
	  System.out.println("Total no of Layout Links:"+l1.size());
	  Thread.sleep(2000);
	  driver.quit();
  }
}
