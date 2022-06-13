package avactis.testproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

	WebDriver driver;
	Select s;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@href,'Apparel')]")
	private WebElement apparel;

	@FindBy(xpath = "//a[contains(@href,'Sport')]")
	private WebElement sport;

	@FindBy(xpath = "//a[contains(@href,'Furniture')]")
	private WebElement furniture;

	@FindBy(xpath = "//a[contains(@href,'Computers')]")
	private WebElement computers;

	@FindBy(xpath = "//a[contains(@href,'DVD')]")
	private WebElement dvd;

	@FindBy(xpath = "//a[contains(@href,'Digital')]")
	private WebElement digitaldistribution;

	@FindBy(xpath = "//a[contains(@href,'checkout')]")
	private WebElement clickcheckout;

	@FindBy(xpath = "//a[contains(@href,'product-list')]")
	private List<WebElement> productlist;

	@FindBy(css = ".product_name")
	private List<WebElement> productname;

	@FindBy(xpath = "//select[contains(@name,'po')]")
	private WebElement sizeDropdown;

	@FindBy(xpath = "//select[@name='quantity_in_cart']")
	private WebElement quantityDropdown;

	@FindBy(xpath = "//input[@value='Add To Cart']")
	private WebElement addtocart;

	@FindBy(xpath = "//i[contains(@class,'cart')]")
	private WebElement carticon;

	@FindBy(xpath = "//*[@name='billingInfo[Firstname]']")
	private WebElement BillingfirstName;

	@FindBy(xpath = "//*[@name='billingInfo[Lastname]']")
	private WebElement BillinglasttName;

	@FindBy(xpath = "//*[@name='billingInfo[Email]']")
	private WebElement BillingEmail;

	@FindBy(xpath = "//*[@name='billingInfo[Country]']")
	private WebElement BillingCountry;

	@FindBy(xpath = "//*[@name='billingInfo[Postcode]']")
	private WebElement Billingpostcode;

	@FindBy(xpath = "//*[@name='billingInfo[Statemenu]']")
	private WebElement Billingstatemenu;

	@FindBy(xpath = "//*[@name='billingInfo[City]']")
	private WebElement Billingcity;

	@FindBy(xpath = "//*[@name='billingInfo[Phone]']")
	private WebElement Billingphone;

	@FindBy(xpath = "//*[@name='checkbox_shipping_same_as_billing']")
	private WebElement CheckboxsameBillingandShippingaddress;

	@FindBy(xpath = "//*[contains(@value,'Checkout')]")
	private WebElement ContinueCheckout;

	@FindBy(xpath = "//a[contains(text(),'Checkout')]")
	private WebElement checkout;

	@FindBy(xpath = "//input[@name='shippingModuleAndMethod[method_code]']")
	private WebElement shippingoption;

	@FindBy(xpath = "//*[@value='BCE5D24D-666C-43CA-94A0-D6F775903BE2_2']")
	private WebElement groundshipping;

	@FindBy(xpath = "//*[contains(@onclick,'submitStep(2)')]")
	private WebElement continuecheckout;

	@FindBy(xpath = "//*[@value='Place Order']")
	private WebElement placeorder;

	@FindBy(xpath = "//*[contains(text(),'Thank you for your order!')]")
	public WebElement orderplaced;

	@FindBy(xpath = "//a[contains(@href,'cart')]")
	private WebElement mycart;

	@FindBy(xpath = "//*[contains(text(),'Sign In')]")
	public WebElement signin;

	public void placeordernew() throws IOException, Exception {
		driver.get("http://localhost/Avactis/");

		try {
			FileInputStream input = new FileInputStream(
					"C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\src\\test\\resources\\config.properties");
			prop.load(input);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		WebElement[] totalcategory = new WebElement[] { apparel, sport, computers, furniture, dvd,
				digitaldistribution };
		for (WebElement selectcategory : totalcategory) {
			if (selectcategory.getText().contains(prop.getProperty("ProductCategory"))) {
				selectcategory.click();

				for (WebElement orderproduct : productname)

				{

					if (orderproduct.getText().contains(prop.getProperty("ProductOrdered"))) {
						orderproduct.click();
						s = new Select(quantityDropdown);
						s.selectByIndex(0);
						addtocart.click();
						mycart.click();
						checkout.click();

						BillingfirstName.sendKeys("Test");
						BillinglasttName.sendKeys("Test");
						BillingEmail.sendKeys("test@gmail.com");
						BillingCountry.sendKeys("india");
						Billingpostcode.sendKeys("411027");
						Billingstatemenu.sendKeys("pune");
						Billingcity.sendKeys("pune");
						Billingphone.sendKeys("02222222");
						CheckboxsameBillingandShippingaddress.click();
						ContinueCheckout.click();

						// JavascriptExecutor js = (JavascriptExecutor) driver;
						// js.executeScript("window.scrollBy(0,1000)");
						// Actions a=new Actions(driver);
						// a.moveToElement(groundshipping).click(groundshipping).perform();

						WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
						wait.until(ExpectedConditions.visibilityOf(groundshipping));

						groundshipping.click();
						continuecheckout.click();
						wait.until(ExpectedConditions.visibilityOf(placeorder));
						placeorder.click();

					}
				}

			}
		}

	}

	public void placeorder() throws IOException, Exception {
		driver.get("http://localhost/Avactis/");

		try {
			FileInputStream input = new FileInputStream(
					"C:\\Users\\Lenovo\\eclipse-workspace\\testproject\\src\\test\\resources\\config.properties");
			prop.load(input);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		WebElement[] totalcategory = new WebElement[] { apparel, sport, computers, furniture, dvd,
				digitaldistribution };
		for (WebElement selectcategory : totalcategory) {
			if (selectcategory.getText().contains(prop.getProperty("ProductCategory"))) {
				selectcategory.click();

				for (WebElement orderproduct : productname)

				{

					if (orderproduct.getText().contains(prop.getProperty("ProductOrdered"))) {
						orderproduct.click();
						s = new Select(quantityDropdown);
						s.selectByIndex(0);
						addtocart.click();
						mycart.click();
						checkout.click();

						CheckboxsameBillingandShippingaddress.click();
						ContinueCheckout.click();

						// JavascriptExecutor js = (JavascriptExecutor) driver;
						// js.executeScript("window.scrollBy(0,1000)");
						// Actions a=new Actions(driver);
						// a.moveToElement(groundshipping).click(groundshipping).perform();

						WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
						wait.until(ExpectedConditions.visibilityOf(groundshipping));

						groundshipping.click();
						continuecheckout.click();
						wait.until(ExpectedConditions.visibilityOf(placeorder));
						placeorder.click();

					}
				}

			}
		}

	}
}
