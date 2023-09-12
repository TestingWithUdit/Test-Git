package RahulShettyAcademyTestScript;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTTP_ResponseCode_Link {

	public static void main(String[] ags) throws MalformedURLException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		SoftAssert a = new SoftAssert();

		List<WebElement> links = driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));

		for (int i = 0; i < links.size(); i++) {

			String url = links.get(i).getAttribute("href");

			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

			connection.setRequestMethod("HEAD");
			connection.connect();
			int value = connection.getResponseCode();
			
			System.out.println(value);

			a.assertTrue(value < 400, "Link is Broken with response code " + value);

		}
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		a.assertAll();
		
		
	}
	
	
	

}
