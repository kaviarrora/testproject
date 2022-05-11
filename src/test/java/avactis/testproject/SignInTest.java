package avactis.testproject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseClass

{
	SignInPage signinpageobject;
	
	//public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	
	public void setup() throws IOException
	
	{
		driver=selectbrowser();
		driver=selecturl();
	    signinpageobject=new SignInPage(driver);
	    
	}
	
	@Test(dataProvider="getdata")
	
	public void logintest (String username,String userpassword) throws IOException
	
	{
		
		MyAccountPage myaccountpageobject=new MyAccountPage(driver);
		System.out.println(username);
		System.out.println(userpassword);
	    signinpageobject.userlogin(username, userpassword);        
	     
		   
	   // Assert.assertFalse(myaccountpageobject.welcometext.isDisplayed(), "Login Failed");
	    	
	    
	    //log.info("signin successfull");
	    
	   	    	
	    myaccountpageobject.signout.click();
   
		
	}


	
	@DataProvider
	
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="kavi.arrora@gmail.com";
		data[0][1]="hello123";
		
		data[1][0]="user1@gmail.com";
		data[1][1]="hello123";	
	
		return data;

}
	@AfterTest
	
	 public void close()
	  {
	  driver= closebrowser();

	  }
	
}