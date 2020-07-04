package Project;

import Utilities.ColorClass;
import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P8_87_Automation extends ColorClass
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod()
	{
		//1. Open browser
		driver = WebDriverFactory.getDriver("chrome");

		System.out.println(ANSI_GREEN + "Environment setup complete." + ANSI_RESET);

	}

	@AfterMethod
	public void afterMethod()
	{
		driver.close();
		System.out.println(ANSI_GREEN + "Environment tear down complete." + ANSI_RESET);
	}

	@Test
	public void test() throws InterruptedException
	{
		String password = "UserUser123";
		ArrayList<String> authorizedUserNames = new ArrayList<>(Arrays.asList("storemanager215", "storemanager216", "salesmanager272", "salesmanager273", "salesmanager274"));
		ArrayList<String> unAuthorizedUsernames = new ArrayList<>(Arrays.asList("user172", "user173", "user174"));

		driver.get("https://qa2.vytrack.com/user/login");

		System.out.println(ANSI_GREEN + "Authorized User Test Start" + ANSI_RESET);

		for (int i = 0; i < 5; i++)
		{
			driver.findElement(By.id("prependedInput")).sendKeys(authorizedUserNames.get(i));
			driver.findElement(By.id("prependedInput2")).sendKeys(password);
			driver.findElement(By.id("_submit")).click();
			Thread.sleep(1000);

			List<WebElement> temp = driver.findElements(By.xpath("//span[@class='title title-level-1']"));

			temp.get(1).click();
			Thread.sleep(1000);

			List<WebElement> temp2 = driver.findElements(By.xpath("//span[@class='title title-level-2']"));
			temp2.get(6).click();
			Thread.sleep(1000);

			String actualTitle = driver.getTitle();
			String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";

			Assert.assertEquals(actualTitle, expectedTitle, "Problem at username " + 1);
			System.out.println("Username " + authorizedUserNames.get(i) + "->" + ANSI_GREEN + " PASS!" + ANSI_RESET);

			driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//a[@class='no-hash']")).click();
			Thread.sleep(1000);
		}

		System.out.println(ANSI_GREEN + "Authorized User Test End" + ANSI_RESET);

		System.out.println("-------------------------------------------------------");

		System.out.println(ANSI_RED + "Unauthorized User Test Start" + ANSI_RESET);

		for (int i = 0; i < 3; i++)
		{
			driver.findElement(By.id("prependedInput")).sendKeys(unAuthorizedUsernames.get(i));
			driver.findElement(By.id("prependedInput2")).sendKeys(password);
			driver.findElement(By.id("_submit")).click();
			Thread.sleep(1000);

			List<WebElement> temp = driver.findElements(By.xpath("//span[@class='title title-level-1']"));

			temp.get(0).click();
			Thread.sleep(1000);

			List<WebElement> temp2 = driver.findElements(By.xpath("//span[@class='title title-level-2']"));
			temp2.get(3).click();
			Thread.sleep(1000);

			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message']")).isDisplayed());

			System.out.println("Username " + unAuthorizedUsernames.get(i) + "->" + ANSI_GREEN + " PASS!" + ANSI_RESET);

			driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//a[@class='no-hash']")).click();
			Thread.sleep(1000);
		}

		System.out.println(ANSI_RED + "Unauthorized User Test End" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Automation Test Complete: No Bugs found");
	}
}
