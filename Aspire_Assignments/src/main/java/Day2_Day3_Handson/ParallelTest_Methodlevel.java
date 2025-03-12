package Day2_Day3_Handson;

import org.testng.annotations.Test;

public class ParallelTest_Methodlevel {
	@Test
	  public void testA() {
		  System.out.println("a"+Thread.currentThread().threadId());
	  }
	  @Test
	  public void testB() {
		  System.out.println("b"+Thread.currentThread().threadId());
	  }
	  
	  @Test
	  public void testC() {
		  System.out.println("c"+Thread.currentThread().threadId());
	  }
}
