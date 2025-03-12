package day4_handson;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadiobuttonValidation {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/radio.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  //---Find the default select radio button  (Chrome radio button click)
	  driver.findElement(By.xpath("//*[@id=\"j_idt87:console2\"]/tbody/tr/td[1]/div/div[2]/span")).click();
	  //---Select the age group (only if not selected) (select the radio button 41-60) years
	  driver.findElement(By.xpath("//*[@id=\"j_idt87:age\"]/div/div[3]/div/div[2]/span")).click();
	  Thread.sleep(2000);
	  driver.quit();
	  
	  
	  
  }
}
