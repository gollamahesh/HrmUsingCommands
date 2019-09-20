package way2Autiomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LIB.baseClass;

public class workingWithWebTable extends baseClass {
	
	
	@BeforeMethod
	public void start()
	{
		initilizeBrowser("chrome", "http://www.way2automation.com/angularjs-protractor/webtables/");
		wait=new WebDriverWait(driver, 10);
		
	}
	@Test(enabled=false)
	public void autocomplete()
	{
		String beforexpath="/html/body/table/tbody/tr[";
		String afterxpath="]/td[1]";
		List<WebElement> opt=driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		for(int i=1;i<opt.size();i++)
		{
			String actualxpath=beforexpath+i+afterxpath;

			WebElement name=driver.findElement(By.xpath(actualxpath));
			System.out.println(name.getText());
		}
		
		
	}
	@Test
	public void testheaders()
	{
		String beforexpath="/html/body/table/thead/tr/th[";
		String afterxpath="]";
		
		List<WebElement> headers=driver.findElements(By.xpath("/html/body/table/thead/tr/th"));
		for(int i=1;i<headers.size();i++)
		{
			String actualxpath=beforexpath+i+afterxpath;
			WebElement ele=driver.findElement(By.xpath(actualxpath));
			System.out.println(ele.getText());
			
			
		}
		
		
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	

}
