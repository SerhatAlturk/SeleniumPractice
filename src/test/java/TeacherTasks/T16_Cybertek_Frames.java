package TeacherTasks;

import Utilities.ColorClass;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T16_Cybertek_Frames extends ColorClass
{
	WebDriver driver;
	Faker faker;

	@BeforeMethod
	public void beforeMethod()
	{
		//1. Open browser
		driver = WebDriverFactory.getDriver("chrome");
		faker = new Faker();
		System.out.println(ANSI_GREEN + "Environment setup complete." + ANSI_RESET);
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
		//2. Go to website: http://practice.cybertekschool.com/javascript_alerts
		driver.get("http://practice.cybertekschool.com/javascript_alerts");

		//3. Click to “Click for JS Alert” button
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		//4. Click to OK button from the alert
		

		//5. Verify “You successfuly clicked an alert” text is displayed.
	}
}
