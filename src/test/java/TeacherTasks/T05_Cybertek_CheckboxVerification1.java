package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T05_Cybertek_CheckboxVerification1
{
	public static void main(String[] args)
	{
		//1. Open Chrome browser

		WebDriver driver = WebDriverFactory.getDriver("chrome");

		//2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html

		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

		//3. Verify “Success – Check box is checked” message is NOT displayed.

		if (driver.findElement(By.xpath("//div[@id='txtAge']")).getAttribute("style").contains("none"))
		{
			System.out.println("Success Message is not displayed (1): Pass");
		}
		else System.out.println("Success Message is displayed (1): Fail");

		//4. Click to checkbox under “Single Checkbox Demo” section

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		//5. Verify “Success – Check box is checked” message is displayed.

		if (driver.findElement(By.xpath("//div[@id='txtAge']")).getAttribute("style").contains("none"))
		{
			System.out.println("Success Message is not displayed (2): Fail");
		}
		else System.out.println("Success Message is displayed (2): Pass");
		driver.close();
	}
}
