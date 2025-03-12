package com.amazonapplication.testCases;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseExtentTest {
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentUtil.getInstance();
    }

  /* @BeforeMethod
    public void setupTest(Method method) {
        test = extent.createTest(method.getName());
    }*/
 /* @BeforeMethod
    public void setupTest(ITestResult result) throws InterruptedException {
    	
        test = extent.createTest(result.getTestClass().getName()+" - "+result.getMethod().getMethodName());
        
    }*/
    

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
