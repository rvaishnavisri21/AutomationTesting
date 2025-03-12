package Day2_Day3_Handson;

import org.testng.annotations.Test;

public class TestBClass {
  @Test
  public void test4() {
	  System.out.println("Testing B"+Thread.currentThread().threadId());
  }
  @Test
  public void test5() {
	  System.out.println("Testing BB"+Thread.currentThread().threadId());
  }
  
}
