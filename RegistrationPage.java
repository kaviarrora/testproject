package avactis.testproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class RegistrationPage {
	
	private WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy (name="customer_info[Customer][Email]")
	private WebElement email;


public WebElement enteremail()
{
	email.sendKeys("kavi.arrora@gmail.com");
	return email;
}
}