package day5_handson;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHovering2 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/drag.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 /* a)Draggable
	  b)Droppable
	  c)Range Slider*/
WebElement e=driver.findElement(By.xpath("//*[@id=\"form:conpnl\"]"));
	  Actions a=new Actions(driver);
	  a.dragAndDropBy(e,250,0).build().perform();
	  Thread.sleep(2000);
	  
	  WebElement e1=driver.findElement(By.xpath("//*[@id=\"form:drag_content\"]"));
	  WebElement e2=driver.findElement(By.xpath("//*[@id=\"form:drop\"]"));
	  a.dragAndDrop(e1,e2).build().perform();
	  Thread.sleep(2000);
	  
	  JavascriptExecutor j=(JavascriptExecutor)driver;
	  j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	  
	  WebElement r1=driver.findElement(By.xpath("//*[@id=\"form:j_idt125\"]/span[1]"));
	  a.clickAndHold(r1).moveByOffset(80, 0).release().build().perform();
	  WebElement r2=driver.findElement(By.xpath("//*[@id=\"form:j_idt125\"]/span[2]"));
	  a.clickAndHold(r2).moveByOffset(-40, 0).release().build().perform();
	  Thread.sleep(5000);
	  driver.quit();
	  
  }
}
