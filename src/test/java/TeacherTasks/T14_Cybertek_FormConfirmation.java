package TeacherTasks;

import Utilities.ColorClass;
import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class T14_Cybertek_FormConfirmation extends ColorClass
{
	WebDriver driver;
	Faker faker;

	@BeforeMethod
	public void beforeMethod()
	{
		//1. Open browser
		System.out.println(ANSI_GREEN + "Environment setup complete." + ANSI_RESET);
		driver = WebDriverFactory.getDriver("chrome");
		SmartBearUtilities.login(driver);
		faker = new Faker();
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
		//2. Go to website: http://practice.cybertekschool.com/registration_form
		driver.get("http://practice.cybertekschool.com/registration_form");

		//3. Enter first name
		driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());

		//4. Enter last name
		driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());

		//5. Enter username
		driver.findElement(By.name("username")).sendKeys(faker.name().firstName() + "" + faker.name().lastName());

		//6. Enter email address
		driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());

		//7. Enter password
		driver.findElement(By.name("password")).sendKeys(faker.internet().password());

		//8. Enter phone number
		driver.findElement(By.name("phone")).sendKeys("720-945-8754");

		//9. Select a gender from radio buttons
		driver.findElement(By.xpath("//input[@value='male']")).click();

		//10. Enter date of birth
		driver.findElement(By.name("birthday")).sendKeys("11/11/1990");

		//11. Select Department/Office
		Select select1 = new Select(driver.findElement(By.name("department")));
		select1.selectByVisibleText("Department of Engineering");

		//12. Select Job Title
		Select select2 = new Select(driver.findElement(By.name("job_title")));
		select2.selectByVisibleText("SDET");

		//13. Select programming language from checkboxes
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@class='col-sm-5']"));
		for (WebElement each : checkBoxes)
		{
			each.click();
		}

		//14. Click to sign up button
		driver.findElement(By.id("wooden_spoon")).click();

		//15. Verify success message “You’ve successfully completed registration.” is displayed.
		String hello = driver.findElement(By.xpath("//div[@class='alert alert-success']/p")).getText();
		Assert.assertEquals(hello, "You've successfully completed registration!");
	}
}
