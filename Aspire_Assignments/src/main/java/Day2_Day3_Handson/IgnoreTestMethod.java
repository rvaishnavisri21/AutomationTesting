package Day2_Day3_Handson;

import org.testng.annotations.Test;

public class IgnoreTestMethod {
  @Test
  public void testC() {
	  System.out.println("c");
  }
  @Test(enabled = false)
  public void testD() {
	  System.out.println("d");
  }
 @Test(enabled = true)
  public void testE() {
	  System.out.println("e");
  }
  
}
