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
	
	@FindBy (name="customer_info[Customer][Password]")
	private WebElement password;
	
	@FindBy (name="customer_info[Customer][RePassword]")
	private WebElement retypepassword;
	
	@FindBy (name="customer_info[Customer][FirstName]")
	private WebElement firstname;
	
	@FindBy (name="customer_info[Customer][LastName]")
	private WebElement lasttname;
	
	@FindBy (id="customer_info_Customer_Country")
	private WebElement country;	

	@FindBy (id="customer_info_Customer_State")
	private WebElement state;
	
	@FindBy (name="customer_info[Customer][ZipCode]")
	private WebElement zipcode;
	
	@FindBy (name="customer_info[Customer][City]")
	private WebElement city;
	
	@FindBy (name="customer_info[Customer][Streetline1]")
	private WebElement addressline1;
	
	@FindBy (name="customer_info[Customer][Streetline2]")
	private WebElement addressline2;
	
	@FindBy (name="customer_info[Customer][Phone]")
	private WebElement phone;
	
	@FindBy (css="[value='Register']")
	private WebElement registerbutton;		
	
	public WebElement enteremail()
	{		
		email.sendKeys("kavi.arrora@gmail.com");
		return email;
	}	


}

