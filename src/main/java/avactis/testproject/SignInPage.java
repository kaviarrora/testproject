package avactis.testproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	
		
		private String avactisSignInPage="http://localhost/Avactis/sign-in.php";
		private WebDriver driver;
		
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
		
		public MyAccountPage userlogin (String useremail, String userpassword)
		
		{
			email.sendKeys(useremail);
			password.sendKeys(userpassword);
			signin.click();
			return new MyAccountPage(driver);
			
		}
		
public void signinpagetitle()
		
		{
			String signinpagetitle=driver.getTitle();
			System.out.println(signinpagetitle);
		}
		
		
	/*	public void signin(String useremail,String userpassword)
		{
			String[] data=new String[2];
				data[0]="kavi.arrora@gmail.com";
				data[1]="sakina81#";
			email.sendKeys(data[0]);
			password.sendKeys(data[1]);
		}
		*/

	}



