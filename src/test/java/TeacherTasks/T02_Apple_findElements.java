package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T02_Apple_findElements
{
	public static void main(String[] args)
	{
		//1. Open Chrome browser

		WebDriver driver = WebDriverFactory.getDriver("chrome");

		//2. Go to https://www.apple.com

		driver.get("https://www.apple.com");

		//3. Click to iPhone

		driver.findElement(By.xpath("//a[@href='/iphone/']")).click();

		//4. Print out the texts of all links

		List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
		int linksWithTexts = 0;
		int linksWithoutTexts = 0;

		for (WebElement each : allLinks)
		{
			if (each.getText().isEmpty())
			{
				linksWithoutTexts++;
			}
			else
			{
				linksWithTexts++;
				System.out.println(each.getText());
			}
		}

		//5. Print out how many link is missing text

		System.out.println("Links without Text: " + linksWithoutTexts);

		//6. Print out how many link has text

		System.out.println("Links with Text: " + linksWithTexts);

		//7. Print out how many total link

		System.out.println("Total Links: " + allLinks.size());

		driver.close();
	}
}
