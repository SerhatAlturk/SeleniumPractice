package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T08_Dropdown1
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod()
	{
		//1. Open Chrome browser
		driver = WebDriverFactory.getDriver("chrome");
	}

	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}

	@Test
	public void test1()
	{
		//2. Go to http://practice.cybertekschool.com/dropdown

		driver.get("http://practice.cybertekschool.com/dropdown");

		//3. Verify “Simple dropdown” default selected value is correct
		//Expected: “Please select an option”

		Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		if (select.getFirstSelectedOption().getText().equals("Please select an option"))
		{
			System.out.println("Simple Dropdown Verification : PASS!");
		}
		else System.out.println("Simple Dropdown Verification : FAIL!");

		//4. Verify “State selection” default selected value is correct
		//Expected: “Select a State”

		Select select2 = new Select(driver.findElement(By.xpath("//select[@id='state']")));
		if (select2.getFirstSelectedOption().getText().equals("Select a State"))
		{
			System.out.println("State Selection Verification : PASS!");
		}
		else System.out.println("State Selection Verification : FAIL!");
	}
}
