package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LIB.baseClass;
import net.bytebuddy.asm.Advice.Argument;

public class javascriptExecutor extends baseClass{
	JavascriptExecutor jse;
	@BeforeMethod
	public void start()
	{
		initilizeBrowser("chrome", "https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		jse=(JavascriptExecutor)driver;
		
	}
	@Test
	public void highlight()
	{
		WebElement element=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/h5"));
		jse.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red;')",element);
		
	}
	@AfterMethod
	public void stop()
	{
		driver.close();
	}
	
}
