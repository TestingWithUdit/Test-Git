package RahulShettyAcademyTestScript;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasket_AddinglistScript {

	public static void main(String[] args) {

		int j = 0;
		String path = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe";
		System.setProperty("WebDriver.Chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("Vegetables" + Keys.ENTER);

		String product = "Potato";

		JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
		scrollDown.executeScript("window.scrollBy(0,180)");

		List<WebElement> veggies = driver.findElements(By.cssSelector("div[qa=\"product_name\"]"));

		for (int i = 0; i < veggies.size(); i++) {
			if (veggies.contains(product)) {
				j++;
				driver.findElements(By.xpath("button[qa=\"add\"]")).get(i).click();
			}

			if (j == product.length()) {
				break;
			}
		}

	}
}
