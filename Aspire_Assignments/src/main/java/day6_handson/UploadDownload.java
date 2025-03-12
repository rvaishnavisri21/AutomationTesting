package day6_handson;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadDownload {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  String sysdir=System.getProperty("user.dir");
	  System.out.println("current directory:"+sysdir);
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://leafground.com/file.xhtml;jsessionid=node03aeevoepm6451mpaqfw4ky1zp7733421.node0");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  // - Basic Upload 
	 
	  Thread.sleep(3000);
	  WebElement w=driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt89_input\"]"));
	 
	  
	  w.sendKeys("C:\\Users\\rvaishnavi.sri\\Documents\\Java Installation_OneConnect.docx");
	  
	  Thread.sleep(2000);
	//- Advanced Upload - Only Pictures
	  WebElement w1=driver.findElement(By.xpath("//*[@id='j_idt97:j_idt98_input']"));
	  w1.sendKeys("C:\\Users\\rvaishnavi.sri\\OneDrive - HCL TECHNOLOGIES LIMITED\\Pictures\\citrix.png");
	  Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='j_idt97:j_idt98']/div[1]/button[1]")).click();
	//  - Basic Download
	
	driver.findElement(By.xpath("//*[@id='j_idt93:j_idt95']")).click();
	Thread.sleep(2000);
	File file=new File("C:\\Users\\rvaishnavi.sri\\Downloads");
	File[] fa=file.listFiles();
	for(File f:fa) {
		
		if(f.getName().contains("TestLeaf Logo")) {
			Thread.sleep(7000);
			System.out.println("file download success: "+f.getName());
		}
	}
	Thread.sleep(2000);
	 driver.quit();
	  
  }
}
