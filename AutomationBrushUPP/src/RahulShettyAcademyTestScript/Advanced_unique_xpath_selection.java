package RahulShettyAcademyTestScript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Advanced_unique_xpath_selection {

	public static void main(String[] args) throws InterruptedException {

		int j = 0;
		System.setProperty("WebDriver.Chrome.driver",
				"C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String[] veggies = { "Cucumber", "Brocolli", "Carrot" };

		List items = Arrays.asList(veggies);

		List<WebElement> productname = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < productname.size(); i++) {

			// Brocolli - 1Kg
			String[] filterName = productname.get(i).getText().split("-");
			String finalName = filterName[0].trim();

			if (items.contains(finalName)) {

				j++;
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();

			}

			if (j == veggies.length) {
				break;
			}
		}
		
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		scroll.executeScript("window.scrollBy(0,400)");
		

	}
}
