package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T04_Cybertek_Checkboxes
{
	public static void main(String[] args)
	{
		WebDriver driver = WebDriverFactory.getDriver("chrome");
		//1. Go to http://practice.cybertekschool.com/checkboxes

		driver.get("http://practice.cybertekschool.com/checkboxes");

		//2. Confirm checkbox #1 is NOT selected by default

		if (driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected())
		{
			System.out.println("Checkbox #1 is selected (1): Fail");
		}
		else System.out.println("Checkbox #1 is not selected (1): Pass");

		//3. Confirm checkbox #2 is SELECTED by default.

		if (driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected())
		{
			System.out.println("Checkbox #2 is selected (1): Pass");
		}
		else System.out.println("Checkbox #2 is not selected (1): Fail");

		//4. Click checkbox #1 to select it.

		driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();

		//5. Click checkbox #2 to deselect it.

		driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();

		//6. Confirm checkbox #1 is SELECTED.

		if (driver.findElement(By.xpath("//input[@type='checkbox'][1]")).isSelected())
		{
			System.out.println("Checkbox #1 is selected (2): Pass");
		}
		else System.out.println("Checkbox #1 is not selected (2): Fail");

		//7. Confirm checkbox #2 is NOT selected.

		if (driver.findElement(By.xpath("//input[@type='checkbox'][2]")).isSelected())
		{
			System.out.println("Checkbox #2 is selected (2): Fail");
		}
		else System.out.println("Checkbox #2 is not selected (2): Pass");
		driver.close();
	}
}
