package RahulShettyAcademyTestScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripCompleteBookingScript {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/hotels/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String mobilenumber = "7011773701";

		driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys(mobilenumber);

		driver.findElement(By.xpath("//*[@class=\"cntrycode__wrap makeRelative\"]")).click();

		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(
				By.cssSelector("[class=\"li makeFlex hrtlCenter font12\"] [class=\"flag__sprite offset flag-in\"]")))
				.click().build().perform();

		driver.findElement(By.xpath("//*[text()='Continue']")).click();

//		driver.findElement(By.xpath("//input[contains(@class,'react-autosuggest__input--open')]")).sendKeys("jim");
//		
//		List<WebElement> options = driver.findElements(By.cssSelector("[role='listbox'] [class='react-autosuggest__suggestions-list']"));
//		
//		for (WebElement option : options) {
//			
//			if(option.getText().contains("Jim Corbett (Ramnagar)")) {
//				
//				option.click();
//				break;
//			}
//		}

	}

}
