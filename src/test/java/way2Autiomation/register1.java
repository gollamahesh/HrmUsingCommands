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

public class register1 extends baseClass{

	WebDriverWait wait;
	@BeforeMethod
	public void start()
	{
		initilizeBrowser("chrome", "http://www.way2automation.com/angularjs-protractor/webtables/");
		wait=new WebDriverWait(driver, 10);
		
	}
	@Test
	public void autocomplete()
	{
		List<WebElement> list=driver.findElements(By.xpath("/html/body/table/tbody/tr/td[5]"));
		int s=list.size();
int count=0;
int i;
		for(i=0;i<s;i++)
		{
			String value=list.get(i).getText();
//			if(value.isEmpty())
//			{
//				//System.out.println("num value came at position"+i);
//				
//			}
			System.out.println(list.get(i).getText()+" "+i+1);

			
		}
		
		

	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	
	
}
