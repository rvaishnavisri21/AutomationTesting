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

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	  public static WebElement SigninLink;
  
	@FindBy(xpath="//input[@name='email']")
	public static WebElement EmailId;
	
	@FindBy(xpath="//*[@id=\"continue\"]/span/input")
	public static WebElement ContinueButton;
	
	@FindBy(xpath="//*[@id=\"ap_password\"]")
	  public static WebElement Password;
	
	@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	  public static WebElement SigninButton;
	
	
}
	


//Mobiles & Accessories
//span/h2[contains(text(),"Mobiles & Accessories")]/../../following-sibling::li/span/a/span

//*[@class="a-size-base a-color-base a-text-bold"][position()>1] | //span[text()="Electronics"] | //span/h2[contains(text(),"Mobiles & Accessories")]