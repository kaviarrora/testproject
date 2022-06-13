package avactis.testproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage  {
	
	WebDriver driver;
	
	
		
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//*[contains (text(),'Sign Out')]")
	public WebElement signout;	
	
	@FindBy (xpath="//a[contains(text(),'Apparel')]")
	public WebElement apparel;
	
	@FindBy (xpath="//a[contains(text(),'Furniture')]")
	public WebElement Furniture;
	
	@FindBy (xpath="//a[contains(text(),'Sport')]")
	public WebElement Sport;
	
	@FindBy (xpath="//*[contains (text(),'Welcome')]")
	public WebElement welcometext;
	
	
	

	public SignInPage signout()
	{
		signout.click();
		return new SignInPage(driver);
	}
	
	public String myaccountpagetitle()
	
	{
		String myaccountpagetitle=driver.getTitle();
		System.out.println(myaccountpagetitle);
		return myaccountpagetitle;
	}
	
	public void orderproducts()
	{
		Furniture.click();
		List <WebElement> furniturelist=driver.findElements(By.cssSelector("[class='img-responsive']"));
		
		
		
			
	}
}

