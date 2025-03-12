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

public class RegisterPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id='ap_customer_name']")
	  public static WebElement Name;
  
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	  public static WebElement RegisterEmail;
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	public static WebElement RegisterPassword;
	
	@FindBy(xpath="//*[@id=\"ap_password_check\"]")
	public static WebElement ReenterPassword;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	  public static WebElement ContinueButton;
	
	
	
	
}
	


//Mobiles & Accessories
//span/h2[contains(text(),"Mobiles & Accessories")]/../../following-sibling::li/span/a/span

//*[@class="a-size-base a-color-base a-text-bold"][position()>1] | //span[text()="Electronics"] | //span/h2[contains(text(),"Mobiles & Accessories")]