package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T09_Dropdown2
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

		driver.get("https://practice.cybertekschool.com/dropdown");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//3. Select Illinois

		Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));
		select.selectByVisibleText("Illinois");

		//4. Select Virginia

		select.selectByVisibleText("Virginia");

		//5. Select California

		select.selectByVisibleText("California");

		//6. Verify final selected option is California.

		if (select.getFirstSelectedOption().getText().equals("California"))
		{
			System.out.println("California Verification : PASS!");
		}
		else System.out.println("California Verification : FAIL!");

		//Use all Select options. (visible text, value, index)

	}
}
