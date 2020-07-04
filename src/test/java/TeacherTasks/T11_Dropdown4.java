package TeacherTasks;

import Utilities.ColorClass;
import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class T11_Dropdown4 extends ColorClass
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println(ANSI_GREEN + "Environment setup complete." + ANSI_RESET);
		//1. Open Chrome browser
		driver = WebDriverFactory.getDriver("chrome");
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
		//2. Go to http://practice.cybertekschool.com/dropdown
		driver.get("http://practice.cybertekschool.com/dropdown");

		//3. Select all the options from multiple select dropdown.
		Select multipleDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
		List<WebElement> choices = multipleDropdown.getOptions();

		for (WebElement each : choices)
		{
			each.click();

			//4. Print out all selected values.
			System.out.println("Selected Option-> " + each.getText());
			Assert.assertTrue(each.isSelected());
		}

		//5. Deselect all values.
		multipleDropdown.deselectAll();
	}

}
