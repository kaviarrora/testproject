package avactis.testproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	WebDriver driver;
	MyAccountPage myaccountpageobject;
		
		private String avactisSignInPage="http://localhost/Avactis/sign-in.php";
		
		
		@FindBy (xpath="//*[contains(text(),'Register')]")
		private WebElement register;
		
		@FindBy (id="account_sign_in_form_email_id")
		private WebElement email;
		
		@FindBy (id="account_sign_in_form_passwd_id")
		private WebElement password;
		
		@FindBy (css="[value='Sign In']")
		private WebElement signin;
		
		
		
				
		public SignInPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}

	
		public RegistrationPage openavactisregistrationform()
		{
			driver.get(avactisSignInPage);
			register.click();
			return new RegistrationPage(driver);
		}
		
		public SignInPage opensigninpage()
		{
			driver.get(avactisSignInPage);
			return new SignInPage(driver);
		}
		
		
		
					
public void signinpagetitle()
		
		{
			String signinpagetitle=driver.getTitle();
			System.out.println(signinpagetitle);
		}
		
public MyAccountPage userlogin (String username,String userpassword) throws IOException

{
		
	email.sendKeys(username);
	password.sendKeys(userpassword);
	signin.click();
	driver.manage().window().maximize();
	return new MyAccountPage(driver);
	
	
	
}

	}



