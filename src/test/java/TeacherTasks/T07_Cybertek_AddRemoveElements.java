package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class T07_Cybertek_AddRemoveElements
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
		//2. Go to http://practice.cybertekschool.com/add_remove_elements/

		driver.get("http://practice.cybertekschool.com/add_remove_elements/");

		//3. Click to “Add Element” button 50 times

		for (int i = 0; i < 50; i++)
		{
			driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		}

		//4. Verify 50 “Delete” button is displayed after clicking.

		List<WebElement> deleteList = driver.findElements(By.xpath("//button[@class='added-manually']"));
		int count = 0;
		for (WebElement each : deleteList)
		{
			if (each.getText().equals("Delete"))
			{
				count++;
			}
		}
		if (count == 50)
		{
			System.out.println("50 Delete : PASS!");
		}
		else System.out.println("50 Delete : FAIL!");

		//5. Click to ALL “Delete” buttons to delete them.

		for (WebElement each : deleteList)
		{
			each.click();
		}


		//6. Verify “Delete” button is NOT displayed after clicking.

		List<WebElement> deleteList2 = driver.findElements(By.xpath("//button[@class='added-manually']"));
		if (deleteList2.size() == 0)
		{
			System.out.println("Delete 50 Display : PASS!");
		}
		else System.out.println("Delete 50 Display : FAIL!");
	}
}
