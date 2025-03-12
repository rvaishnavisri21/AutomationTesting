package Day2_Day3_Handson;

import org.testng.annotations.Test;

public class Grouping {
  @Test(groups ="smoke")
  public void testA() {
	  System.out.println("a");
  }
  @Test(groups ="regression")
  public void testB() {
	  System.out.println("b");
  }
  
  @Test(groups ="smoke")
  public void testC() {
	  System.out.println("c");
  }
  
}
