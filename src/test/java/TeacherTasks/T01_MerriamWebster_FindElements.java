package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T01_MerriamWebster_FindElements
{
	public static void main(String[] args)
	{
		//1. Open Chrome browser

		WebDriver driver = WebDriverFactory.getDriver("chrome");

		//2. Go to https://www.merriam-webster.com/

		driver.get("https://www.merriam-webster.com/");

		//3. Print out the texts of all links

		List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
		int linkWithText = 0;
		int linkWithoutText = 0;

		for (WebElement each : allLinks)
		{
			System.out.println(each.getAttribute("href"));
			if (each.getText().isEmpty())
			{
				linkWithoutText++;
			}
			else linkWithText++;
		}
		//4. Print out how many link is missing text

		System.out.println("Links without text: " + linkWithoutText);

		//5. Print out how many link has text

		System.out.println("Links with text: " + linkWithText);

		//6. Print out how many total link

		System.out.println("Total Links: " + (linkWithoutText + linkWithText));

		driver.close();

	}
}
