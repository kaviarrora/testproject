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

	}



