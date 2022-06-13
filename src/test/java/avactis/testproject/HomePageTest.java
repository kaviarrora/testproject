package avactis.testproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class HomePageTest extends BaseClass


{
	

public static Logger log=LogManager.getLogger(HomePageTest.class.getName());



WebDriverWait wait;

	RegistrationPage registrationpageobject;
	SignInPage signinpageobject;
	MyAccountPage myaccountpageobject;
	HomePage homepageobject;

	@BeforeMethod
	
	public void setup() throws IOException {
		

		log.info("select browser and url");

		
		driver=selectbrowser();
		driver=selecturl();
		registrationpageobject = new RegistrationPage(driver);
		signinpageobject = new SignInPage(driver);
		myaccountpageobject = new MyAccountPage(driver);
		homepageobject = new HomePage(driver);

	}

	@Test
	public void guestusershopping() throws Exception

	{
		
		homepageobject.placeordernew();
		
		log.info("assertion started");
		Assert.assertTrue(homepageobject.orderplaced.isDisplayed(), "Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'KARLSTAD modular sofa')]"))
				.isDisplayed(), "Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'pune')]")).isDisplayed(),
				"Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'Order ID')]")).isDisplayed(),
				"Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'$24.84')]")).isDisplayed(),
				"Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'$828.00')]")).isDisplayed(),
				"Test case passed");

	}
	
	@Test
	public void loggedinusershopping() throws Exception
	{
		
		
		homepageobject.signin.click();
		signinpageobject.userlogin("kavi.arrora@gmail.com", "hello123");
		homepageobject.placeorder();
		Assert.assertTrue(homepageobject.orderplaced.isDisplayed(), "Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'KARLSTAD modular sofa')]"))
				.isDisplayed(), "Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'pune')]")).isDisplayed(),
				"Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'Order ID')]")).isDisplayed(),
				"Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'$24.84')]")).isDisplayed(),
				"Test case passed");
		Assert.assertTrue(homepageobject.driver.findElement(By.xpath("//*[contains(text(),'$828.00')]")).isDisplayed(),
				"Test case passed");

	}

	@AfterTest(enabled=false)

	public void close() {
		driver = closebrowser();

	}

}
