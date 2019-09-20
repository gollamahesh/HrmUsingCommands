package tests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LIB.baseClass;
import pages.loginPage;

public class workingWithPopUps extends baseClass{
	loginPage page;
	
	WebDriverWait wait;
	@BeforeMethod
	public void start()
	{
		initilizeBrowser("chrome", "https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		wait=new WebDriverWait(driver, 10);
	}
@Test
	public void verifypopUps()
	{
		WebElement followontwit=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a")));
		followontwit.click();
		String parent=driver.getWindowHandle();
		
		Set<String> childs=driver.getWindowHandles();
		
		Iterator<String> it=childs.iterator();
		
		while(it.hasNext())
		{
			String child=it.next().toString();
			if(!child.equals(parent))
			{
				driver.switchTo().window(child);
				System.out.println(driver.getCurrentUrl());
				driver.close();
				
			}else {
				driver.switchTo().window(parent);		
			}
			
		}
		
	}
@AfterMethod
public void stop()
{
	driver.close();}
	
	
}
