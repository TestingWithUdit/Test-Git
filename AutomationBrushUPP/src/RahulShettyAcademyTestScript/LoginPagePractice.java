package RahulShettyAcademyTestScript;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePractice {

	public static void main(String[] args) throws InterruptedException {

		int j = 0;
		String username = "rahulshettyacademy";
		String password = "learning";

		String path = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe";
		System.setProperty("WebDriver.Chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		 

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//label[@class=\"customradio\"]//span[text()=' User']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id=\\\"okayBtn\\\"]")));
		driver.findElement(By.cssSelector("[id=\"okayBtn\"]")).click();

		WebElement list = driver.findElement(By.xpath("//select[@class=\"form-control\"]"));

		Select sel = new Select(list);

		sel.selectByIndex(2);
		System.out.println(sel.getFirstSelectedOption().getText());

		driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"signInBtn\"]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4[class=\\\"card-title\\\"]")));

		List<WebElement> listOfMobiles = driver.findElements(By.cssSelector("h4[class=\"card-title\"]"));

		for (int i = 0; i < listOfMobiles.size(); i++) {
			driver.findElements(By.xpath("//button[@class=\"btn btn-info\"]")).get(i).click();
		}

	}
}
