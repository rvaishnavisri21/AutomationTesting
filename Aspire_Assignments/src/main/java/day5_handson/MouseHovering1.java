package day5_handson;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHovering1 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/hovers");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  //Image 3- Mouse hovering
	  //a)to retrive name: User3 and Viewprofile

	  WebElement w=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
	  
	  Actions a=new Actions(driver);
	  a.moveToElement(w).build().perform();
	  Thread.sleep(2000);
	  WebElement w1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
	  WebElement w2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"));
	  System.out.println(w1.getText()+" link:"+w2.getText());
	  Thread.sleep(2000);
	  driver.quit();
	  
  }
}
