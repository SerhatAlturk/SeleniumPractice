package TeacherTasks;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T10_Dropdown3
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
	public void test1() throws Exception
	{
		//2. Go to http://practice.cybertekschool.com/dropdown

		driver.get("http://practice.cybertekschool.com/dropdown");

		//3. Select “December 1st, 1921” and verify it is selected.
		//Select year using : visible text
		//Select month using : value attribute
		//Select day using : index number

		Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));

		Thread.sleep(3000);
		selectYear.selectByVisibleText("1921");
		System.out.println(selectYear.getFirstSelectedOption().getText());

		Thread.sleep(3000);
		selectMonth.selectByValue("11");
		System.out.println(selectMonth.getFirstSelectedOption().getText());

		Thread.sleep(3000);
		selectDay.selectByIndex(0);
		System.out.println(selectDay.getFirstSelectedOption().getText());
		Thread.sleep(3000);

	}
}
