package TeacherTasks;

import Utilities.ColorClass;
import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T12_Dropdown5 extends ColorClass
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println(ANSI_GREEN + "Environment setup complete." + ANSI_RESET);
		//1. Open Chrome browser
		driver = WebDriverFactory.getDriver("chrome");

		//2. Go to http://practice.cybertekschool.com/dropdown
		driver.get("http://practice.cybertekschool.com/dropdown");

	}

	@AfterMethod
	public void afterMethod()
	{
		driver.close();
		System.out.println(ANSI_GREEN + "Environment tear down complete." + ANSI_RESET);
	}

	@Test
	public void test1()
	{
		//3. Click to non-select dropdown
		driver.findElement(By.xpath("//div[@class='dropdown']/a")).click();

		//4. Select Facebook from dropdown
		driver.findElement(By.xpath("//a[@class='dropdown-item'][4]")).click();

		//5. Verify title is “Facebook - Log In or Sign Up”
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Facebook - Log In or Sign Up", "Title does NOT match.");
		System.out.println(ANSI_GREEN + "Test Successful" + ANSI_RESET);

	}

}
