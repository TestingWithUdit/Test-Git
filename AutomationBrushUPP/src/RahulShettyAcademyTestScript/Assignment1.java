package RahulShettyAcademyTestScript;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		String path = "C:\\\\Users\\\\AVITA\\\\eclipse-workspace\\\\AutomationBrushUPP\\\\chromedriver.exe";
		System.setProperty("WebDriver.Chrome.Driver", path);

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String option2 = driver.findElement(By.xpath("//label[@for=\"benz\"]")).getText();
		driver.findElement(By.xpath("//* [@id=\"checkBoxOption2\"]")).click();

		WebElement selectoption = driver.findElement(By.xpath("//*[@id=\"dropdown-class-example\"]"));

		Select sel = new Select(selectoption);

		sel.selectByVisibleText(option2);

		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(option2);
		driver.findElement(By.xpath("//input[@id=\"alertbtn\"]")).click();

		String text = driver.switchTo().alert().getText();

		if (text.contains(option2)) {

			System.out.println("Alert Message is Perfect");
		} else {
			System.out.println("Alert Message is not as per Expected");
		}

		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	}
}
