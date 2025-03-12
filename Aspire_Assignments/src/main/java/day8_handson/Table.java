package day8_handson;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

public class Table {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/table.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  // - get row count	 
	  Thread.sleep(2000);
	  List<WebElement> r=driver.findElements(By.xpath("//*[@id=\"form:j_idt89_data\"]/tr/td[1]"));
	  System.out.println("Row count: "+r.size());
	  
	//- get column count
	  List<WebElement> c=driver.findElements(By.xpath("//thead[@id=\"form:j_idt89_head\"]/tr/th"));
	  System.out.println("Column count: "+c.size());
	  
	  //- get name and date of join value
	  System.out.println("Name and DOJ: ");
	  List<WebElement> Name_DateofJoin=driver.findElements(By.xpath("//*[@id=\"form:j_idt89_data\"]/tr/td[1] | //*[@id=\"form:j_idt89_data\"]/tr/td[4]"));
	  for(WebElement e:Name_DateofJoin) {
			  System.out.println(e.getText());
	  }
	  Thread.sleep(3000);
	 driver.quit();
	  
  }
}
