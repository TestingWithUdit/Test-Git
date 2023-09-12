package RahulShettyAcademyTestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class end2end_vistara {
	
	String path="C:\\\\Users\\\\AVITA\\\\eclipse-workspace\\\\AutomationBrushUPP\\\\ExcelData\\\\ExcelData.xlsx";
	
	public void vistaratesting()
	{
	
		System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.airvistara.com/in/en");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[text()=\"CV Points\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"acceptAllBtn\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"sign-up-btn col-sm-6\"]//a[@class=\"aubergine-button-dark col-xs-12 enroll-btn\"]")).click();
		WebElement selectoption = driver.findElement(By.id("customer_title"));
		
		Select selector = new Select(selectoption);
		
		selector.selectByIndex(1);
		System.out.println(selector.getFirstSelectedOption().getText());

		
		
		driver.findElement(By.cssSelector("input[id=\"firstNam e\"]")).sendKeys(getExcelData(path, 0, 1, 0));
		driver.findElement(By.cssSelector("input[id=\"lastName\"]")).sendKeys(getExcelData(path, 0, 1, 1));
		driver.findElement(By.xpath("//input[contains(@id,'dobField')]")).sendKeys(getExcelData(path, 0, 1, 4));
		driver.findElement(By.xpath("//input[contains(@id,'emailId')]")).sendKeys(getExcelData(path, 0, 1, 2));
		driver.findElement(By.cssSelector("input[id=\"mobile\"]")).sendKeys(getExcelData(path, 0, 1, 3));
		driver.findElement(By.xpath("//label[contains(@for,'euCitizenYes')]")).click();
		//driver.findElement(By.xpath("//*[@value=\"N\"]")).click();
		driver.findElement(By.className("checkmark")).click();
		driver.findElement(By.className("reg-btn")).click();		
		
		
		
	

	}
	
	public static String getExcelData(String path, int Sheetno, int rowno, int colno) 
	{
		String value= "";
		
		try {	
			//GettingDataFromExcelSheet
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			DataFormatter format = new DataFormatter();
			value = format.formatCellValue(sheet.getRow(rowno).getCell(colno));
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Issue in get read data "+e);
			
		}
	
		return value;
		
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		
	    end2end_vistara ob = new end2end_vistara();
	    ob.vistaratesting();
		

	}

}
