package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.poi.ss.usermodel.Cell;

import LIB.baseClass;

public class practice extends baseClass{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			FileInputStream fis=new FileInputStream("/Users/maheshbabugolla/Documents/demo.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			Row r=sheet.getRow(1);
			Cell c=r.getCell(1);
			System.out.println(c);
			
//		System.setProperty("webdriver.chrome.driver", "/Volumes/Files/Softwares/Selenium/chromedriver 5");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.get("https://www.phptravels.net/");
//		int width=driver.findElement(By.tagName("img")).getSize().getWidth();
//		int height=driver.findElement(By.tagName("img")).getSize().getWidth();
//		System.out.println(width+"   "+height);
		
	}

}
