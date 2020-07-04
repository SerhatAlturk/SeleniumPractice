package PersonalPractice;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P01_GoogleSearch
{
	WebDriver driver;

	@BeforeClass
	public void setUp()
	{
		driver = WebDriverFactory.getDriver("chrome");
		System.out.println("driver set up completed.");
	}

	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://www.google.com");
		System.out.println("Google is accessible");
	}

	@AfterMethod
	public void afterMethod()
	{
		driver.close();
		System.out.println("Browser closed.");
	}

	@Test(priority = 1)
	public void test1()
	{
		driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
		String currentTitle = driver.getTitle();

		Assert.assertTrue(currentTitle.contains("apple"), "Test 1 -- FAIL!");
		if (currentTitle.contains("apple"))
		{
			System.out.println("Test2 -- PASS!");
		}
	}

}
