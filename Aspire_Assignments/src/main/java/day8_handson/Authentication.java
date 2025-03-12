package day8_handson;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

public class Authentication {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException, AWTException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/auth.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  // - using robot class complete the authentication 	 
	  Thread.sleep(2000);
	  WebElement BasicAuth=driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt90\"]"));
	  Actions a =new Actions(driver);
	  
	  WebElement un=driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div/div/h5[2]"));
	  String[] una=un.getText().split(":");
	  String user=una[1].trim();
	  
	  StringSelection str=new StringSelection(user);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);
	 // a.moveToElement(un).doubleClick().build().perform();
	  
	 /* r.keyPress(KeyEvent.VK_CONTROL);
	  r.keyPress(KeyEvent.VK_C);

	  r.keyRelease(KeyEvent.VK_CONTROL);
	  r.keyRelease(KeyEvent.VK_C);*/
	  
	  a.click(BasicAuth).build().perform();
	  
Set<String> w=driver.getWindowHandles();
			  Iterator<String> i=w.iterator();
			  String parent=i.next();
			  String child=i.next();
			  driver.switchTo().window(child);
			  //Thread.sleep(3000);
			  Robot r=new Robot();
			  Thread.sleep(3000);
			  r.keyPress(KeyEvent.VK_CONTROL);
			  r.keyPress(KeyEvent.VK_V);

			  r.keyRelease(KeyEvent.VK_CONTROL);
			  r.keyRelease(KeyEvent.VK_V);
			  Thread.sleep(3000);
			  driver.switchTo().window(parent);
			  Thread.sleep(3000);
			  WebElement pwd=driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div/div/h5[3]"));
			  String[] pwda=pwd.getText().split(":");
			  String pass=pwda[1].trim();
			  StringSelection str1=new StringSelection(pass);
			  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1,null);
			  driver.switchTo().window(child);
			  Thread.sleep(3000);
			  r.keyPress(KeyEvent.VK_TAB);
			  r.keyRelease(KeyEvent.VK_TAB);
			  Thread.sleep(2000);
			  r.keyPress(KeyEvent.VK_CONTROL);
			  r.keyPress(KeyEvent.VK_V);

			  r.keyRelease(KeyEvent.VK_CONTROL);
			  r.keyRelease(KeyEvent.VK_V);
			  Thread.sleep(2000);
			  r.keyPress(KeyEvent.VK_ENTER);
			  r.keyRelease(KeyEvent.VK_ENTER);
			  WebElement success=driver.findElement(By.xpath("//body[contains(text(),'Your authentication is successful')]"));
			  Assert.assertEquals(success.getText(), "Your authentication is successful");
			  System.out.println("Assert Validation Passed");
	  Thread.sleep(3000);
	 driver.quit();
	  
  }
}
