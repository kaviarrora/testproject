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

import io.qameta.allure.Description;

@Listeners(avactis.testproject.Listeners.class)

public class RegistrationTest extends BaseClass

{
	WebDriverWait wait;

	RegistrationPage registrationpageobject;
	SignInPage signinpageobject;
	MyAccountPage myaccountpageobject;

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest

	public void setup() throws IOException {
		driver = selectbrowser();
		driver = selecturl();
		registrationpageobject = new RegistrationPage(driver);
		signinpageobject = new SignInPage(driver);
		myaccountpageobject = new MyAccountPage(driver);

	}

	@Test
	@Description("This test will register new users by reading data from excel")
	public void newregistration()

	{

		signinpageobject.openavactisregistrationform();
		readexcel();
		registrationpageobject.newregistration();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		Assert.assertTrue(registrationpageobject.createnewaccount.isDisplayed(), "Registration failed");
		Assert.assertFalse(registrationpageobject.createnewaccount.isDisplayed(), "Registration passed");

	}

	@AfterTest(enabled = false)

	public void close() {
		driver = closebrowser();

	}

}
