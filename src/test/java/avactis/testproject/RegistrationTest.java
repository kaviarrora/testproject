package avactis.testproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest {
	


	  @Test
	  public void register() throws IOException 
	  	  
	  { 
		 System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");				
			WebDriver driver=new ChromeDriver();
			SignInPage signinpageobject=new SignInPage(driver);
		signinpageobject.opensigninpage();
		RegistrationPage registrationpageobject=new RegistrationPage(driver);
		registrationpageobject.newregistration();
		MyAccountPage myaccountpageobject=new MyAccountPage(driver);
			signinpageobject.userlogin("kavi.arrora@gmail.com", "hello123");
			myaccountpageobject.orderproducts();
			
		
		
		// positive scenario- new registration validation
		
	
			
		// negative scenario - try to re register with same details
		

				
		
		
	  }


	  }

