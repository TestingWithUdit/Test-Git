package RahulShettyAcademyTestScript;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import junit.framework.Assert;
import okio.Timeout;

public class AutomationScript {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String path = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe";

		System.setProperty("WebDriver.Chrome.Driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		WebElement staticSelector = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_DropDownListCurrency\"]"));

		Select selector = new Select(staticSelector);

		selector.selectByIndex(3);
		System.out.println(selector.getFirstSelectedOption().getText());
		selector.selectByVisibleText("AED");
		System.out.println(selector.getFirstSelectedOption().getText());
		selector.selectByValue("INR");
		System.out.println(selector.getFirstSelectedOption().getText());

		driver.findElement(By.xpath("//div[contains(@class,\"paxinfo\")]")).click();

		for (int i = 1; i <= 8; i++) {
			driver.findElement(By.xpath("//span[contains(@id,\"hrefIncAdt\")]")).click();
		}

		for (int i = 8; i >= 1; i--) {

			driver.findElement(By.xpath("//span[contains(@id,\"hrefDecAdt\")]")).click();
		}

		driver.findElement(By.xpath("//input[contains(@id,\"btnclosepaxoption\")]")).click();

		driver.findElement(By.xpath("//input[contains(@id,\"originStation1_CTXT\")]")).click();
		driver.findElement(By.xpath("//*[text()=\" Goa (GOI)\"]")).click();
		driver.findElement(By.xpath("(//*[text()=\" Bangkok (BKK)\"])[2]")).click();

		// AutoSuggest
		driver.findElement(By.id("autosuggest")).sendKeys("Can");

		List<WebElement> options = driver.findElements(By.xpath("//ul[@id=\"ui-id-1\"]//a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Canada")) {
				option.click();
				break;
			}
		}

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

			System.out.println("IS ENABLED ");
			org.junit.Assert.assertTrue(true);
		} else {

			System.out.println("IS DISABLED");
			org.junit.Assert.assertFalse(false);
		}

		driver.findElement(By.xpath("//input[contains(@id,'Trip_2')]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class=\"MultiCityContent\"]//child::p[1]")).getText());
		org.junit.Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class=\"MultiCityContent\"]//child::p[1]")).getText(),
				"Multicity booking does not mean connecting flight. Customers must ensure sufficient connecting time between flights. QAclickjet will not be responsible for missed connections due to any reason.");
		driver.findElement(By.id("MultiCityModelAlert")).click();
	}
}
