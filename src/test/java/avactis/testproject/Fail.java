package avactis.testproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




@Listeners(avactis.testproject.Listeners.class)
@Test
		
public class Fail extends BaseClass{
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	public void failtest()
	  {
		  
		log.info("this test will fail");
		System.out.println("test failed");
		Assert.assertTrue(false);
	  }


}
