package RahulShettyAcademyTestScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bigbasket_script {

	public static void main(String[] args) {
         
		 System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.bigbasket.com/");
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     
	     driver.findElement(By.xpath("//input[@id=\"input\"]")).sendKeys("ginger");
	     List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"search-found\"]//li//b"));
	     
	     System.out.println(driver.findElements(By.xpath("//*[@qa=\"prodListAS\"]")).size());
	     
	     for(WebElement option : options) {
	    	 
	    	 if(option.getText().equalsIgnoreCase("Ginger - Chopped")) {
	    		 
	    		 option.click();
	    		 break;
	    	 }
	    	 
	     }
	     
	}
}


