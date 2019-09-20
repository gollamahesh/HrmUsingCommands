package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LIB.baseClass;
import pages.loginPage;

public class loginPageTestUsingExcel extends baseClass {
	loginPage page;

	@BeforeMethod
	public void start()
	{
		initilizeBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");
		page=new loginPage();
		
	}
	@Test
	public void logintoappexcel()
	{
		page.loginExcel();
	}
	
	
}
