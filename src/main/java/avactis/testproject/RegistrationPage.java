package avactis.testproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class RegistrationPage 
{

 WebDriver driver;


{

	Properties prop=new Properties();
	String user;

	{

		try {
			FileInputStream input=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\src\\main\\java\\avactis\\testproject\\config.properties");
			prop.load(input);
			user=prop.getProperty("email");
			



		}


		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
	}

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
	private WebElement lastname;

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
	
	@FindBy (xpath="//*[contains (text(),'Sign Out')]")
	public WebElement signout;	
	
	

	public MyAccountPage newregistration()
	{		
		try {
			String filelocation="C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\Testdata\\New_Registration.xlsx";
			FileInputStream file=new FileInputStream(filelocation);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheet("Sheet1");
			//int rowcount=sheet.getPhysicalNumberOfRows();
			//System.out.println("total number of rows are" + rowcount);
			
			String useremailid,userpassword,userretypepassword,userfirstname,userlastname,usercountry,userstate,
			usercity,useraddress1,useraddress2,userzipcode,userphone;
			
			int lastrow=sheet.getLastRowNum();
			int firstrow=sheet.getFirstRowNum();
			
			
			int numberofrows=lastrow-firstrow;
			System.out.println(numberofrows);
			
			for(int i=1;i<=numberofrows;i++)
									
			{
			for (int j=0;j<=11;j++)
			{
				
			useremailid=sheet.getRow(i).getCell(j).getStringCellValue();
			userpassword=sheet.getRow(i).getCell(j).getStringCellValue();
			userretypepassword=sheet.getRow(i).getCell(j).getStringCellValue();
			userfirstname=sheet.getRow(i).getCell(j).getStringCellValue();
			userlastname=sheet.getRow(i).getCell(j).getStringCellValue();
			usercountry=sheet.getRow(i).getCell(j).getStringCellValue();
			userstate=sheet.getRow(i).getCell(j).getStringCellValue();
			userzipcode=sheet.getRow(i).getCell(j).getStringCellValue();
			usercity=sheet.getRow(i).getCell(j).getStringCellValue();
			useraddress1=sheet.getRow(i).getCell(j).getStringCellValue();
			useraddress2=sheet.getRow(i).getCell(j).getStringCellValue();
			userphone=sheet.getRow(i).getCell(j).getStringCellValue();
						
				
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
			signout.click();
			
			
			}
			
			
			}
			
			
			
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return new MyAccountPage(driver);
		
	}
		
			
		public void registrationpagetitle()
		
		{
			String registrationpagetitle=driver.getTitle();
			System.out.println(registrationpagetitle);
		}
			
			
			
	}
		



