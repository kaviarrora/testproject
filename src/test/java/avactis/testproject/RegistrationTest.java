package avactis.testproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationTest {
	


	  @Test
	  public void register()
	  	  
	  { 
		  System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");				
			WebDriver driver=new ChromeDriver();
			SignInPage opensigninpage=new SignInPage(driver);
		opensigninpage.openavactisregistrationform();
		RegistrationPage enterdetails=new RegistrationPage(driver);
		enterdetails.enteremail();
				
	
	

}
	  }
