package TeacherTasks;

import Utilities.ColorClass;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T15_Cybertek_Dropdown1 extends ColorClass
{
	WebDriver driver;
	Faker faker;

	@BeforeMethod
	public void beforeMethod()
	{
		//1. Open browser
		driver = WebDriverFactory.getDriver("chrome");
		faker = new Faker();
		System.out.println(ANSI_GREEN + "Environment setup complete." + ANSI_RESET);
	}

	@AfterMethod
	public void afterMethod()
	{
		driver.close();
		System.out.println(ANSI_GREEN + "Environment tear down complete." + ANSI_RESET);
	}

	@Test
	public void test1()
	{
		System.out.println(ANSI_GREEN + "Test 1 running." + ANSI_RESET);

		//2. Go to website: http://practice.cybertekschool.com/dropdown
		driver.get("http://practice.cybertekschool.com/dropdown");

		//3. Verify default value is always showing the current month
		//o Expected: If currently in June, should show June selected.
		Select select = new Select(driver.findElement(By.id("month")));

		String actualMonth = select.getFirstSelectedOption().getText();
		String expectedMonth = LocalDate.now().getMonth().toString();

		Assert.assertTrue(actualMonth.equalsIgnoreCase(expectedMonth));
		System.out.println(ANSI_GREEN + "Test 1 PASS!" + ANSI_RESET);


		//1. Do both verifications in the same test
		//2. Verify list of months are correct as expected.
		//o Expected: Options should contain all 12 months of the year.
		System.out.println(ANSI_GREEN + "Test 2 running." + ANSI_RESET);

		String[] Months = new DateFormatSymbols().getMonths();
		ArrayList<String> ExpectedMonthsList = new ArrayList<>(Arrays.asList(Months));


		List<WebElement> tempList = select.getOptions();
		ArrayList<String> ActualMonthsList = new ArrayList<>();
		for (WebElement each : tempList)
		{
		    ActualMonthsList.add(each.getText());
		}


		for (int i = 0; i < 12; i++)
		{
			String temp1 = ExpectedMonthsList.get(i);
			String temp2 = ActualMonthsList.get(i);
			Assert.assertEquals(temp1,temp2);
		}

		System.out.println(ANSI_GREEN + "Test 2 PASS!" + ANSI_RESET);
	}
}
