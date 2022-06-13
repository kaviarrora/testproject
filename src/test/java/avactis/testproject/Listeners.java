package avactis.testproject;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


public class Listeners extends BaseClass implements ITestListener {

	
	
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;

		String TestCaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			System.out.println(driver);
		}

		catch (Exception e) {
			e.printStackTrace();

		}

		try {
			screenshotpath(TestCaseName, driver);
			System.out.println("The failed test name is " + TestCaseName);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}