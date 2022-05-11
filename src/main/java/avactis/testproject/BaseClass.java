package avactis.testproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass  {
	
	public WebDriver driver;
	Properties prop=new Properties();
	XSSFWorkbook wb;
		
	public WebDriver refreshpage()
	{
		
		driver.navigate().refresh();
		
		return driver;
	
	}
	
	public WebDriver readexcel()
	{
		try
		{	
			
			FileInputStream input=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\src\\test\\resources\\config.properties");
			prop.load(input);
			String datalocation=prop.getProperty("filelocation");
			FileInputStream file=new FileInputStream(datalocation);
			wb = new XSSFWorkbook(file);
				
		
		}
		
		catch (Exception e)
		{
			e.getStackTrace();
		}
		
			
		
		return driver;
	}
	
	
	
	
	public WebDriver selecturl() throws IOException
	
	
	{
		FileInputStream input=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\src\\test\\resources\\config.properties");
		
		prop.load(input);
			String signinurl=prop.getProperty("signinurl");
			driver.get(signinurl);
			return driver;
	}
	
	public WebDriver selectbrowser() throws IOException
	{

		
		  FileInputStream input=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\src\\test\\resources\\config.properties");
			prop.load(input);
			String browserName=	prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");				
				driver=new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver.exe");				
				driver=new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver","src\\test\\resources\\msedgedriver.exe");				
				driver=new EdgeDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
	}
	
	public WebDriver closebrowser()
	{
		driver.close();
		return driver;
	}

}
