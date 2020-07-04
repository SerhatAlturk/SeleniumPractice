package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class T06_Cybertek_CheckboxVerification2
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

	@Test(priority = 0)
	public void test1()
	{
		//2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html

		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		//3. Verify “Check All” button text is “Check All”

		if (driver.findElement(By.xpath("//input[@id='check1']")).getAttribute("value").equals("Check All"))
		{
			System.out.println("Check All Verification (1): PASS!");
		}
		else System.out.println("Check All Verification (1): FAIL!");

		//4. Click to “Check All” button

		driver.findElement(By.xpath("//input[@id='check1']")).click();

		//5. Verify all check boxes are checked

		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='checkbox']"));
		checkboxes.remove(0);
		int count = 0;
		for (WebElement each : checkboxes)
		{
			if (each.isEnabled())
			{
				count++;
			}
		}
		if (count == 4)
		{
			System.out.println("Checkboxes are checked : PASS!");
		}
		else System.out.println("Checkboxes are NOT checked : FAIL!");

		//6. Verify button text changed to “Uncheck All”

		if (driver.findElement(By.xpath("//input[@id='check1']")).getAttribute("value").equals("Uncheck All"))
		{
			System.out.println("Check All Verification (2): PASS!");
		}
		else System.out.println("Check All Verification (2): FAIL!");
	}
}
