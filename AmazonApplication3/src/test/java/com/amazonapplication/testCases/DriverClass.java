package com.amazonapplication.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverClass {
	public static WebDriver driver;
	public static String browser;
	public static WebDriver getdriver() throws IOException{
		
		
		if (driver == null){
			String sysdir=System.getProperty("user.dir");
			  System.out.println("current directory:"+sysdir);
			  Scanner sc = new Scanner(System.in);
				System.out.println("Enter Browser name:");
				browser = sc.nextLine();
			  System.out.println("Browser:"+browser);
			if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",".\\Drivers\\msedgedriver.exe");
				  driver=new EdgeDriver();
				  FileInputStream fs=new FileInputStream(".\\Config.properties");
				  Properties pro=new Properties();
				  pro.load(fs);
				  driver.get(pro.getProperty("URL"));
				  driver.manage().window().maximize();
				  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				return driver;
		 
		}
			else {
				 System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
				
				 driver=new ChromeDriver();
				  FileInputStream fs=new FileInputStream(".\\Config.properties");
				  Properties pro=new Properties();
				  pro.load(fs);
				  driver.get(pro.getProperty("URL"));
				  driver.manage().window().maximize();
				  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				  
				return driver;
			}
			
		}
		else {
			return driver;
		}
	}
}
