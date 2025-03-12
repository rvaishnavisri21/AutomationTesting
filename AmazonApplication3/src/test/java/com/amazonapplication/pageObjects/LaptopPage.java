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

public class LaptopPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	  public static WebElement SearchBox;
  
	@FindBy(xpath="(//img[@class='s-image'])[1]")
	public static WebElement FirstGamingLaptop;
	
	
	@FindBy(xpath="//*[@id=\"a-autoid-6-announce\"]/span[2]")
	public static WebElement Quantity;
	
	@FindBy(xpath="//*[contains(@id,'customer_review')]")
	public static List<WebElement> CustomerReviews;
	
	@FindBy(xpath="(//a/h2/span)[1]")
	public static WebElement LaptopTitleFirst;
	
	@FindBy(xpath="//span[@id=\"productTitle\"]")
	public static WebElement LaptopTitleNext;
}
	


//Mobiles & Accessories
//span/h2[contains(text(),"Mobiles & Accessories")]/../../following-sibling::li/span/a/span

//*[@class="a-size-base a-color-base a-text-bold"][position()>1] | //span[text()="Electronics"] | //span/h2[contains(text(),"Mobiles & Accessories")]