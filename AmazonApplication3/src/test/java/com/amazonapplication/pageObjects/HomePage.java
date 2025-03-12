package com.amazonapplication.pageObjects;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.BeforeTest;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),\"Mobiles\")]")
	  public static WebElement Mobiles;
  
	@FindBy(xpath="//*[@id='n-title']/h1")
	  public static WebElement Category;
	
	@FindBy(xpath="(//*[@class='a-size-base a-color-base a-text-bold'])[position()>1] | //span[text()='Electronics'] | //span/h2[contains(text(),'Mobiles & Accessories')]")
	public static List<WebElement> CategoryItems;
	
	@FindBy(xpath="//span/h2[contains(text(),'Mobiles & Accessories')]/../../following-sibling::li/span/a/span")
	public static List<WebElement> MobileAccessoriesItems;
	
	@FindBy(xpath="//*[@id=\"nav-subnav\"]/a[3]/span[1]")
	  public static WebElement LaptopsAccessoriesLink;
	
	@FindBy(xpath="//a[contains(text(),'Dell')]")
	  public static WebElement DellLink;
	
	
}
	


//Mobiles & Accessories
//span/h2[contains(text(),"Mobiles & Accessories")]/../../following-sibling::li/span/a/span

//*[@class="a-size-base a-color-base a-text-bold"][position()>1] | //span[text()="Electronics"] | //span/h2[contains(text(),"Mobiles & Accessories")]