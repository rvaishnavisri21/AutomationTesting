package day4_handson;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Checkboxes {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/checkbox.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  //Basic Checkbox  -- to enable checkbox of basic
	  WebElement w=driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt89\"]/div[2]"));
	  w.click();
	  System.out.println("Is enabled:"+w.isEnabled());
	  Thread.sleep(2000);
	  //Choose your favorite language(s)- all five checkbox should be selected
	  List<WebElement> l=driver.findElements(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td/div/div[2]"));
	  
	  for(WebElement e:l) {
		  e.click();
	  }
	  Thread.sleep(2000);
	  driver.quit();
  }
}
