package Day2_Day3_Handson;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGdependsOnMethods {
  @Test
  public void testLogin() {
	  System.out.println("login");
	  //Assert.fail();
  }
  @Test(dependsOnMethods = {"testLogin"})
   public void testAddToCart() {
	  System.out.println("add");
	  //Assert.fail();
  }
  @Test(dependsOnMethods = {"testAddToCart"})
  public void testCheckout() {
	  System.out.println("checkout");
	  //Assert.fail();
  }
}
