package Day2_Day3_Handson;

import org.testng.annotations.Test;

public class TestAClass {
  @Test
  public void test1() {
	  System.out.println("Testing A"+Thread.currentThread().threadId());
  }
  @Test
  public void test2() {
	  System.out.println("Testing AA"+Thread.currentThread().threadId());
  }
  @Test
  public void test3() {
	  System.out.println("Testing AAA"+Thread.currentThread().threadId());
  }
}
