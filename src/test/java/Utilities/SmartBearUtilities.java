package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SmartBearUtilities
{
	public static void login(WebDriver driver)
	{
		//2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

		//3. Enter username: “Tester”
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

		//4. Enter password: “test”
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

		//5. Click to Login button
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}

	public static void verifyOrder(WebDriver driver, String name)
	{
		List<WebElement> nameList = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
		ArrayList<String> nameListText = new ArrayList<>();
		for (WebElement each : nameList)
		{
			nameListText.add(each.getText());
		}
		Assert.assertTrue(nameListText.contains(name));
	}

	public static void printNamesAndCities(WebDriver driver)
	{
		List<WebElement> nameList = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
		ArrayList<String> nameListText = new ArrayList<>();
		for (WebElement each : nameList)
		{
			nameListText.add(each.getText());
		}

		List<WebElement> cityList = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));
		ArrayList<String> cityListText = new ArrayList<>();
		for (WebElement each : cityList)
		{
			cityListText.add(each.getText());
		}

		int count = 0;
		for (int i = 0; i < 8; i++)
		{
			count++;
			System.out.println("Name" + count + ": " + nameListText.get(i) + " ,City" + count + ": " + cityListText.get(i));
		}
	}
}
