package RahulShettyAcademyTestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileInputStream_DataPractise {

	public static String getReadData(String path, int sheetno, int rowno, int colno) throws IOException {

		String data = "";
		path = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\ExcelData\\Practise_data.xlsx";
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			data = sheet.getRow(rowno).getCell(colno).getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue in get Read Data " + e);
		}
		return data;
	}

	public static void main(String[] args) throws IOException {

		String path = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\ExcelData\\Practise_data.xlsx";
		String path1 = "C:\\Users\\AVITA\\eclipse-workspace\\AutomationBrushUPP\\chromedriver.exe";
		System.setProperty("WebDriver.Chrome.driver", path);

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(getReadData(path, 0, 1, 0));
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(getReadData(path, 0, 0, 1));

	}

}
