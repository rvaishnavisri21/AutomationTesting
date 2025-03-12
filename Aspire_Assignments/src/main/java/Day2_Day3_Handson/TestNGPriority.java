package Day2_Day3_Handson;

import org.testng.annotations.Test;

public class TestNGPriority {
  @Test(priority = 1)
  public void testA() {
	  System.out.println("a");
  }
  
  @Test(priority = 2)
  public void testB() {
	  System.out.println("b");
  }
  
  @Test(priority = 0)
  public void testC() {
	  System.out.println("c");
  }
}
