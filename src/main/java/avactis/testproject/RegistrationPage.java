package avactis.testproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BaseClass {

	WebDriver driver;
	

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "customer_info[Customer][Email]")
	private WebElement email;

	@FindBy(name = "customer_info[Customer][Password]")
	private WebElement password;

	@FindBy(name = "customer_info[Customer][RePassword]")
	private WebElement retypepassword;

	@FindBy(name = "customer_info[Customer][FirstName]")
	private WebElement firstname;

	@FindBy(name = "customer_info[Customer][LastName]")
	private WebElement lastname;

	@FindBy(id = "customer_info_Customer_Country")
	private WebElement country;

	@FindBy(id = "customer_info_Customer_State")
	private WebElement state;

	@FindBy(name = "customer_info[Customer][ZipCode]")
	private WebElement zipcode;

	@FindBy(name = "customer_info[Customer][City]")
	private WebElement city;

	@FindBy(name = "customer_info[Customer][Streetline1]")
	private WebElement addressline1;

	@FindBy(name = "customer_info[Customer][Streetline2]")
	private WebElement addressline2;

	@FindBy(name = "customer_info[Customer][Phone]")
	private WebElement phone;

	@FindBy(css = "[value='Register']")
	private WebElement registerbutton;

	@FindBy(xpath = "//*[contains (text(),'Sign Out')]")
	public WebElement signout;

	@FindBy(xpath = "//a[contains(text(),'Sign')]")
	private WebElement signinlink;

	@FindBy(xpath = "//*[contains(text(),'Create new account')]")
	public WebElement createnewaccount;

	@FindBy(xpath = "//*[contains(text(),'Register')]")
	private WebElement registerclick;

	public MyAccountPage newregistration() {

		driver = readexcel();
		XSSFSheet sheet = wb.getSheet("Sheet1");

		String useremailid, userpassword, userretypepassword, userfirstname, userlastname, usercountry, userstate,
				usercity, useraddress1, useraddress2, userzipcode, userphone;

		int lastrow = sheet.getLastRowNum();
		int firstrow = sheet.getFirstRowNum();

		int numberofrows = lastrow - firstrow;
		System.out.println(numberofrows);

		for (int i = 1; i <= numberofrows; i++)

		{
			int j = 0;

			useremailid = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(useremailid);
			userpassword = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(userpassword);
			userretypepassword = sheet.getRow(i).getCell(2).getStringCellValue();
			System.out.println(userretypepassword);
			userfirstname = sheet.getRow(i).getCell(3).getStringCellValue();
			userlastname = sheet.getRow(i).getCell(4).getStringCellValue();
			usercountry = sheet.getRow(i).getCell(5).getStringCellValue();
			userstate = sheet.getRow(i).getCell(6).getStringCellValue();
			userzipcode = sheet.getRow(i).getCell(7).getStringCellValue();
			usercity = sheet.getRow(i).getCell(8).getStringCellValue();
			useraddress1 = sheet.getRow(i).getCell(9).getStringCellValue();
			useraddress2 = sheet.getRow(i).getCell(10).getStringCellValue();
			userphone = sheet.getRow(i).getCell(11).getStringCellValue();

			email.sendKeys(useremailid);
			password.sendKeys(userpassword);
			retypepassword.sendKeys(userretypepassword);
			firstname.sendKeys(userfirstname);
			lastname.sendKeys(userlastname);
			country.sendKeys(usercountry);
			state.sendKeys(userstate);
			zipcode.sendKeys(userzipcode);
			city.sendKeys(usercity);
			addressline1.sendKeys(useraddress1);
			addressline2.sendKeys(useraddress2);
			phone.sendKeys(userphone);
			registerbutton.click();
			signinlink.click();
			registerclick.click();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// wait=new WebDriverWait(driver,Duration.ofSeconds(7));
			System.out.println("wait 7 sec");

		}

		return new MyAccountPage(driver);

	}

	public void registrationpagetitle()

	{
		String registrationpagetitle = driver.getTitle();
		System.out.println(registrationpagetitle);
	}

	

}
