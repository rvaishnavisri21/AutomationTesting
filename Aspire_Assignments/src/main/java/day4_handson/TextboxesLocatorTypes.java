package day4_handson;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TextboxesLocatorTypes {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/input.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  //text boxes- all the locator type you have implement in the code(id,name,xpath....)
	  /*Type your name
	  Append Country to this City.
	  Clear the typed text.
	  Type about yourself*/

	  driver.findElement(By.id("j_idt88:name")).sendKeys("Vaishnavi");
	  driver.findElement(By.name("j_idt88:j_idt91")).sendKeys(",India");
	  driver.findElement(By.cssSelector("input[id='j_idt88:j_idt95']")).clear();
	  Thread.sleep(5000);
	  driver.findElement(By.cssSelector("input[id='j_idt88:j_idt95']")).sendKeys("entered after clear");
	  driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt101\"]")).sendKeys("I am Engineer");
	  Thread.sleep(2000);
	  driver.quit();
	  
  }
}
