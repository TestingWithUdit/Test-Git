package RahulShettyAcademyTestScript;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle_Assignment {

	public static void main(String[] args) {

		System.setProperty("WebDriver.Chrome.driver",
				"C:\\\\Users\\\\AVITA\\\\eclipse-workspace\\\\AutomationBrushUPP\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//*[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//*[text()='Click Here']")).click();

		Set<String> option = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<>(option);
		driver.switchTo().window(li.get(1));
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		driver.close();
		driver.switchTo().window(li.get(0));
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());

	}

}
