package RahulShettyAcademyTestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling_java {

	public static void main(String[] args) throws InterruptedException {
		String path = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe";
		System.setProperty("WebDriver.Chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[contains(@id,'name')]")).sendKeys("Udit Sharma");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"alertbtn\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[@id=\"confirmbtn\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        
	}

}
