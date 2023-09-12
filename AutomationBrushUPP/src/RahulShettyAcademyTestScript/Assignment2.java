package RahulShettyAcademyTestScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2

{

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
//		String path = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\driver\\chromedriver.exe";
//		System.setProperty("WebDriver.Chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");

		WebElement table = driver.findElement(By.id("product"));

		System.out.println(table.findElements(By.tagName("tr")).size());

	 
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> listofrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		for (int i = 0; i < listofrow.size(); i++) {

			System.out.println(listofrow.get(i).getText());
		}
	}
}
