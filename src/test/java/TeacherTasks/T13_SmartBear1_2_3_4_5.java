package TeacherTasks;

import Utilities.ColorClass;
import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class T13_SmartBear1_2_3_4_5 extends ColorClass
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println(ANSI_GREEN + "Environment setup complete." + ANSI_RESET);
		driver = WebDriverFactory.getDriver("chrome");
		SmartBearUtilities.login(driver);
	}

	@AfterMethod
	public void afterMethod()
	{
		driver.close();
		System.out.println(ANSI_GREEN + "Environment tear down complete." + ANSI_RESET);
	}

	@Test(priority = 0)
	public void test1()
	{
		System.out.println(ANSI_GREEN + "Test 1 running." + ANSI_RESET);
		//6. Print out count of all the links on landing page
		List<WebElement> links = driver.findElements(By.xpath("//body//a"));

		//7. Print out each link text on this page
		for (WebElement each : links)
		{
			System.out.println(each.getText());
		}
	}

	@Test(priority = 1)
	public void test2()
	{
		System.out.println(ANSI_GREEN + "Test 2 running." + ANSI_RESET);
		//6. Click on Order
		driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();

		//7. Select familyAlbum from product, set quantity to 2
		Select product = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		product.selectByVisibleText("FamilyAlbum");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.DELETE + "2");

		//8. Click to “Calculate” button
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();

		//9. Fill address Info with JavaFaker
		//• Generate: name, street, city, state, zip code
		Faker faker = new Faker();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetName());
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.address().zipCode().replaceAll("-", ""));

		//10. Click on “visa” radio button
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

		//11. Generate card number using JavaFaker
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.finance().creditCard().replaceAll("-", ""));

		//12. Click on “Process”
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/32");

		//13. Verify success message “New order has been successfully added.”
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='buttons_process']//strong")).isDisplayed());
	}

	@Test(priority = 2)
	public void test3()
	{
		System.out.println(ANSI_GREEN + "Test 3 running." + ANSI_RESET);
		//Verify Susan McLaren has order on date “01/05/2010”
		String actualDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]")).getText();
		Assert.assertEquals(actualDate, "01/05/2010");

	}

	@Test(priority = 3)
	public void test4()
	{
		System.out.println(ANSI_GREEN + "Test 4 running." + ANSI_RESET);
		SmartBearUtilities.verifyOrder(driver, "Susan McLarn");
	}

	@Test(priority = 4)
	public void test5()
	{
		SmartBearUtilities.printNamesAndCities(driver);
	}
}
