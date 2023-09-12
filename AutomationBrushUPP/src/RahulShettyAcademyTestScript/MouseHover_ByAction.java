package RahulShettyAcademyTestScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover_ByAction {

	public static void main(String[] args) {
		System.setProperty("WebDriver.Chrome.driver",
				"C:\\\\Users\\\\AVITA\\\\eclipse-workspace\\\\AutomationBrushUPP\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		// MouseHoverElement
		WebElement mouseHover = driver.findElement(By.id("nav-link-accountList"));

		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).build().perform();
		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("iphone").build().perform();

		List<WebElement> options = driver.findElements(By.xpath("//div[@class=\"s-suggestion-container\"]"));

		for (WebElement dd :  options) {

			if (dd.getText().equalsIgnoreCase("iphone 13 pro")) {
				System.out.println(dd.getText());
				dd.click();
				break;
			}

		}

	}

}
