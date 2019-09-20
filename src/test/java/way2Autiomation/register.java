package way2Autiomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LIB.baseClass;

public class register extends baseClass{
	
	WebDriverWait wait;
	@BeforeMethod
	public void start()
	{
		initilizeBrowser("chrome", "https://www.google.co.in/");
		wait=new WebDriverWait(driver, 10);
		
	}
	@Test
	public void autocomplete()
	{
		driver.findElement(By.xpath("//input[@title=\"Search\"]")).click();
		
		driver.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys("test");
		
		autocompleteSearch("//ul[@role=\"listbox\"]//li", "testing");
//		List<WebElement> list=driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li"));
//		
//		for(int i=0;i<list.size();i++)
//		{
//			String expected="testing";
//			System.out.println(list.get(i).getText());
//			if(list.get(i).getText().equals(expected))
//			{
//				list.get(i).click();
//				break;
//			}
//				
//		}

	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	

}
