package Day2_Day3_Handson;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAssertions {
	TestClass tc=new TestClass();
	TestClass tn=null;
String message="hai";
	
  @Test
  public void f() {
	  Assert.assertEquals(tc.add(4,5),9);
	System.out.println("assertEquals");
	Assert.assertEquals(message,"hai"); 
	System.out.println("assertEqualsText");
	/*Assert.assertEquals(tc.add(4,5),10,"not equal");
	 */
	
	  Assert.assertNotEquals(tc.add(4,5),10);
	  System.out.println("assertNotEquals");
	  Assert.assertTrue(4<5);
	  
	  System.out.println("assertTrue");
	  
	  /*Assert.assertTrue(5<4);
	  System.out.println("assertTrue");*/
	  Assert.assertFalse(5<4);
	  System.out.println("assertFalse");
	  Assert.assertNotNull(tc);
	  System.out.println("assertNotNull");
	  Assert.assertNull(tn);
	  System.out.println("assertNull");
	  Assert.assertNotSame(tc, tn);
	  System.out.println("assertNotsame");
	  /*Assert.assertSame(tc, tn);
	  System.out.println("assertsame");
	  */
	  
  }
  
}
