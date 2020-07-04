package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T03_Apple_findElements2
{
	public static void main(String[] args)
	{
		int emptyLinkCounter = 0;
		int linksWithText = 0;
		//1. Open Chrome browser
		WebDriver driver = WebDriverFactory.getDriver("chrome");
		//2. Go to https://www.apple.com
		driver.get("https://www.apple.com");
		//3. Click to all of the headers one by one
		//a. Mac, iPad, iPhone, Watch, TV, Music, Support
		List<WebElement> headers = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

		for (int i = 1; i < 8; i++)
		{
			headers.get(i).click();
			List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
			System.out.println("Number of Links on page: " + driver.getTitle() + " : " + listOfLinks.size());
			for (WebElement link : listOfLinks)
			{
				if (!link.getText().isEmpty())
				{
					linksWithText++;
				}
				else
				{
					emptyLinkCounter++;
				}

			}
			driver.navigate().back();
			headers = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
		}
		System.out.println("Number of EmptyLinks: \t" + emptyLinkCounter);
		System.out.println("Number of Links with text: \t" + linksWithText);

	}
}
