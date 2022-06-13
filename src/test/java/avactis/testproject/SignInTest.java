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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


public class SignInTest extends BaseClass

{
	SignInPage signinpageobject;
	
	//public static Logger log=LogManager.getLogger(SignInTest.class);
	@BeforeMethod
	
	public void setup() throws IOException
	
	{
		//log.info("select browser");
		driver=selectbrowser();
		driver=selecturl();
	    signinpageobject=new SignInPage(driver);
	    
	}
	
	@Test(dataProvider="getdata")
	@Description("This test takes two user credentials from data provider")
	@Step("First user {0} Second user{0}")
	@Severity(SeverityLevel.BLOCKER)
	@Epic("This belongs to main epic")
	@Attachment
	@Story("multiple login")
	
	
	public void logintest (String username,String userpassword) throws IOException
	
	{
		
		MyAccountPage myaccountpageobject=new MyAccountPage(driver);
		System.out.println(username);
		System.out.println(userpassword);
	    signinpageobject.userlogin(username, userpassword);  
	    String actual=myaccountpageobject.myaccountpagetitle();
	    String expected="My Account";
	    String message="Test case failed";
	    Assert.assertEquals(actual, expected, message);
		
	 
	    
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
	@AfterMethod
	
	 public void close()
	  {
	  driver= closebrowser();

	  }
	
	
}